package com.gdsc.domain.track.controller;

import com.gdsc.domain.track.entity.Track;
import com.gdsc.domain.track.model.TrackRequest;
import com.gdsc.domain.track.model.TrackResponse;
import com.gdsc.domain.track.service.TrackService;
import com.gdsc.domain.user.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "트랙", description = "트랙 API")
@RestController
@RequestMapping("/api/v1/track")
@RequiredArgsConstructor
public class TrackController {

    private final TrackService trackService;

    @GetMapping("/init/{keyword}")
    public ResponseEntity<List<TrackResponse>> findInitTrackByKeyword(@PathVariable(value = "keyword") String keyword){
        List<Track> initTracks = trackService.findByKeyword(keyword);

        List<TrackResponse> trackResponses = getTrackResponses(initTracks);

        return ResponseEntity.ok(trackResponses);
    }

    @GetMapping
    public ResponseEntity<List<TrackResponse>> findUserTrack(@AuthenticationPrincipal User user){
        List<Track> tracks = trackService.findByUser(user);

        List<TrackResponse> trackResponses = getTrackResponses(tracks);

        return ResponseEntity.ok(trackResponses);
    }

    @PostMapping
    public ResponseEntity<TrackResponse> saveTrack(@AuthenticationPrincipal User user,
                                                         @RequestBody @Validated TrackRequest trackRequest){
        Track track = trackService.save(trackRequest, user);

        return ResponseEntity.ok(TrackResponse.of(track));
    }

    @DeleteMapping("/{trackId}")
    public ResponseEntity<Void> deleteTrack(@PathVariable(value = "trackId") Long trackId){
        if(trackId == null) {
            return ResponseEntity.badRequest().build(); // 클라이언트가 유효하지 않은 요청을 보냈을 경우 400 Bad Request 응답을 반환
        }

        boolean deleted = trackService.delete(trackId);

        if(deleted) {
            return ResponseEntity.noContent().build(); // 트랙이 성공적으로 삭제되었을 경우 204 No Content 응답을 반환
        } else {
            return ResponseEntity.notFound().build(); // 해당 ID에 해당하는 트랙을 찾을 수 없을 경우 404 Not Found 응답을 반환
        }
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteAllTrack(@AuthenticationPrincipal User user){
        trackService.delete(user);

        return ResponseEntity.noContent().build();
    }

    private static List<TrackResponse> getTrackResponses(List<Track> tracks) {
        return tracks.stream()
                .map(TrackResponse::of)
                .toList();
    }
}
