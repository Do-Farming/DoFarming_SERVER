package com.gdsc.domain.routine.model;

import com.gdsc.domain.routine.entity.Routine;
import com.gdsc.domain.track.entity.Track;
import lombok.Builder;

@Builder
public record RoutineResponse(
        Long routineId,
        String content
) {
    public static RoutineResponse of(Routine routine) {
        return RoutineResponse.builder()
                .routineId(routine.getId())
                .content(routine.getContent())
                .build();
    }
}
