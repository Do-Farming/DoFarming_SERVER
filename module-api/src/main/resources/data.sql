INSERT INTO users (id,email,username,nickname,gender,role,age,mood) VALUES (1,'admin@naver.com','admin','admin','MALE','ROLE_ADMIN',0,"HAPPY");
INSERT INTO keyword (keyword_num,user_id,keyword_content) VALUES (1,1,"학업/취업");
INSERT INTO keyword (keyword_num,user_id,keyword_content) VALUES (2,1,"직장생활");
INSERT INTO keyword (keyword_num,user_id,keyword_content) VALUES (3,1,"사랑");
INSERT INTO keyword (keyword_num,user_id,keyword_content) VALUES (4,1,"사람과의 관계");
INSERT INTO keyword (keyword_num,user_id,keyword_content) VALUES (5,1,"경제적 안정");
INSERT INTO keyword (keyword_num,user_id,keyword_content) VALUES (6,1,"자존감");
INSERT INTO keyword (keyword_num,user_id,keyword_content) VALUES (7,1,"미래에 대한 불안감");
INSERT INTO keyword (keyword_num,user_id,keyword_content) VALUES (8,1,"건강");
INSERT INTO track (track_num,track_content,user_id,keyword_id) VALUES (1,"나를 가꾸는 시간",1,8);
INSERT INTO track (track_num,track_content,user_id,keyword_id) VALUES (2,"불면증 극복",1,8);
INSERT INTO track (track_num,track_content,user_id,keyword_id) VALUES (3,"우울증 완화",1,8);
INSERT INTO track (track_num,track_content,user_id,keyword_id) VALUES (4,"가족과의 시간",1,8);
INSERT INTO routine (routine_num,routine_content,user_id,track_id) VALUES (1,"좋아하는 음악",1,1);
INSERT INTO routine (routine_num,routine_content,user_id,track_id) VALUES (2,"샤워",1,1);
INSERT INTO routine (routine_num,routine_content,user_id,track_id) VALUES (3,"스킨케어",1,1);
INSERT INTO routine (routine_num,routine_content,user_id,track_id) VALUES (4,"마스크팩",1,1);
INSERT INTO routine (routine_num,routine_content,user_id,track_id) VALUES (5,"림프관 마사지",1,1);
INSERT INTO routine (routine_num,routine_content,user_id,track_id) VALUES (6,"립밤 바르기",1,1);