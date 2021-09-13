CREATE TABLE TB_USER
(
    USER_INDEX      INT(10)         AUTO_INCREMENT PRIMARY KEY  COMMENT '사용자 INDEX',
    USER_ID         VARCHAR(100)    NOT NULL                    COMMENT '사용자 아이디',
    USER_PASSWORD   VARCHAR(100)    NOT NULL                    COMMENT '사용자 비밀번호',
    USER_NAME       VARCHAR(100)    NOT NULL                    COMMENT '사용자 이름',
    USER_AUTHORITY  INT(1)          NOT NULL                    COMMENT '사용자 권한'
)
COMMENT '사용자 테이블';

CREATE INDEX pk_Idx_User_UserIndex ON TB_USER (USER_INDEX ASC);

CREATE TABLE TB_COMPETITION
(
    COMPETITION_INDEX               INT(10)         AUTO_INCREMENT PRIMARY KEY  COMMENT '대회 INDEX',
    COMPETITION_CLASSIFICATION      VARCHAR(5)      NOT NULL                    COMMENT '대회 앱 구분',
    COMPETITION_NAME_KO             VARCHAR(100)    NOT NULL                    COMMENT '대회 이름(한글)',
    COMPETITION_NAME_EN             VARCHAR(100)    NOT NULL                    COMMENT '대회 이름(영어)',
    COMPETITION_GRADE               INT(1)          NOT NULL                    COMMENT '대회 등급',
    COMPETITION_HOST_INSTITUTION_KO VARCHAR(50)     NOT NULL                    COMMENT '주최 기관(한글)',
    COMPETITION_HOST_INSTITUTION_EN VARCHAR(50)     NOT NULL                    COMMENT '주최 기관(영어)',
    COMPETITION_START_DATE          DATE            NOT NULL                    COMMENT '대회 시작 날짜',
    COMPETITION_END_DATE            DATE            NOT NULL                    COMMENT '대회 종료 날짜',
    REGISTRATION_START_DATE         DATE            NOT NULL                    COMMENT '등록 시작 날짜',
    REGISTRATION_END_DATE           DATE            NOT NULL                    COMMENT '등록 종료 날짜',
    CORRECTION_START_DATE           DATE            NOT NULL                    COMMENT '정정 시작 날짜',
    CORRECTION_END_DATE             DATE            NOT NULL                    COMMENT '정정 종료 날짜',
    COMPETITION_HOMEPAGE            VARCHAR(255)    NOT NULL                    COMMENT '대회 홈페이지',
    COMPETITION_LOGO_PATH           VARCHAR(255)    NOT NULL                    COMMENT '대회 로고 S3경로',
    COMPETITION_IMAGE_PATH          VARCHAR(255)    NOT NULL                    COMMENT '대회 이미지 S3경로'
)
COMMENT '대회 테이블';

CREATE INDEX pk_Idx_Competition_CompetitionIndex ON TB_COMPETITION (COMPETITION_INDEX ASC);

CREATE TABLE TB_EVENT
(
    EVENT_INDEX                         INT(10)         AUTO_INCREMENT PRIMARY KEY  COMMENT '종목 INDEX',
    COMPETITION_INDEX                   INT(10)         NOT NULL                    COMMENT '대회 INDEX',
    EVENT_NAME_KO                       VARCHAR(100)    NOT NULL                    COMMENT '종목 이름(한글)',
    EVENT_NAME_EN                       VARCHAR(100)    NOT NULL                    COMMENT '종목 이름(영어)',
    EVENT_CLASSIFICATION                INT(1)          NOT NULL                    COMMENT '분류',
    EVENT_TYPE                          INT(1)          NOT NULL                    COMMENT '유형',
    EVENT_RATING                        INT(1)          NOT NULL                    COMMENT '등급',
    ROUND_CNT                           INT(1)          NOT NULL                    COMMENT '라운드 수',
    -- ROUND 1 INFO
    ROUND_ONE_GAME_TIME                 INT(3)          NOT NULL                    COMMENT '1라운드 경기 시간',
    ROUND_ONE_BREAK_TIME                INT(3)          NULL                        COMMENT '1라운드 휴식 시간',
    ROUND_ONE_DOUBLE_TARGET_MITT_CNT    INT(1)          NULL                        COMMENT '1라운드 더블타겟 미트 갯수',
    ROUND_ONE_LARGE_MITT_CNT            INT(1)          NULL                        COMMENT '1라운드 대형 미트 갯수',
    -- ROUND 2 INFO
    ROUND_TWO_GAME_TIME                 INT(3)          NULL                        COMMENT '2라운드 경기 시간',
    ROUND_TWO_BREAK_TIME                INT(3)          NULL                        COMMENT '2라운드 휴식 시간',
    ROUND_TWO_DOUBLE_TARGET_MITT_CNT    INT(1)          NULL                        COMMENT '2라운드 더블타겟 미트 갯수',
    ROUND_TWO_LARGE_MITT_CNT            INT(1)          NULL                        COMMENT '2라운드 대형 미트 갯수',
    -- ROUND 3 INFO
    ROUND_TREE_GAME_TIME                INT(3)          NULL                        COMMENT '3라운드 경기 시간',
    ROUND_TREE_BREAK_TIME               INT(3)          NULL                        COMMENT '3라운드 휴식 시간',
    ROUND_TREE_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '3라운드 더블타겟 미트 갯수',
    ROUND_TREE_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '3라운드 대형 미트 갯수',
    -- ROUND 4 INFO
    ROUND_FOUR_GAME_TIME                INT(3)          NULL                        COMMENT '4라운드 경기 시간',
    ROUND_FOUR_BREAK_TIME               INT(3)          NULL                        COMMENT '4라운드 휴식 시간',
    ROUND_FOUR_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '4라운드 더블타겟 미트 갯수',
    ROUND_FOUR_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '4라운드 대형 미트 갯수',
    -- ROUND 5 INFO()
    ROUND_FIVE_GAME_TIME                INT(3)          NULL                        COMMENT '5라운드 경기 시간',
    ROUND_FIVE_BREAK_TIME               INT(3)          NULL                        COMMENT '5라운드 휴식 시간',
    ROUND_FIVE_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '5라운드 더블타겟 미트 갯수',
    ROUND_FIVE_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '5라운드 대형 미트 갯수',
    EVENT_ORDER                         INT(3)          NOT NULL                    COMMENT '종목 정렬순서'
)
COMMENT '종목 테이블';

ALTER TABLE TB_EVENT
    ADD CONSTRAINT fk_Event_CompetitionIndex
        FOREIGN KEY (COMPETITION_INDEX) REFERENCES TB_COMPETITION (COMPETITION_INDEX);

CREATE INDEX pk_Idx_Event_EventIndex ON TB_EVENT (EVENT_INDEX ASC);
CREATE INDEX fk_Idx_Event_CompetitionIndex ON TB_EVENT (COMPETITION_INDEX ASC);
CREATE INDEX Idx_Event_EventOrder ON TB_EVENT (EVENT_ORDER ASC);

CREATE TABLE TB_WEIGHT_CLASS
(
    WEIGHT_CLASS_INDEX                  INT(10)         AUTO_INCREMENT PRIMARY KEY  COMMENT '체급 INDEX',
    EVENT_INDEX                         INT(10)         NOT NULL                    COMMENT '종목 INDEX',
    WEIGHT_CLASS_NAME_KO                VARCHAR(100)    NOT NULL                    COMMENT '체급명(한글)',
    WEIGHT_CLASS_NAME_EN                VARCHAR(100)    NOT NULL                    COMMENT '체급명(영어)',
    ROUND_CNT                           INT(10)         NOT NULL                    COMMENT '라운드 수',
    -- ROUND 1 INFO
    ROUND_ONE_GAME_TIME                 INT(3)          NOT NULL                    COMMENT '1라운드 경기 시간',
    ROUND_ONE_BREAK_TIME                INT(3)          NULL                        COMMENT '1라운드 휴식 시간',
    ROUND_ONE_DOUBLE_TARGET_MITT_CNT    INT(1)          NULL                        COMMENT '1라운드 더블타겟 미트 갯수',
    ROUND_ONE_LARGE_MITT_CNT            INT(1)          NULL                        COMMENT '1라운드 대형 미트 갯수',
    -- ROUND 2 INFO
    ROUND_TWO_GAME_TIME                 INT(3)          NULL                        COMMENT '2라운드 경기 시간',
    ROUND_TWO_BREAK_TIME                INT(3)          NULL                        COMMENT '2라운드 휴식 시간',
    ROUND_TWO_DOUBLE_TARGET_MITT_CNT    INT(1)          NULL                        COMMENT '2라운드 더블타겟 미트 갯수',
    ROUND_TWO_LARGE_MITT_CNT            INT(1)          NULL                        COMMENT '2라운드 대형 미트 갯수',
    -- ROUND 3 INFO
    ROUND_TREE_GAME_TIME                INT(3)          NULL                        COMMENT '3라운드 경기 시간',
    ROUND_TREE_BREAK_TIME               INT(3)          NULL                        COMMENT '3라운드 휴식 시간',
    ROUND_TREE_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '3라운드 더블타겟 미트 갯수',
    ROUND_TREE_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '3라운드 대형 미트 갯수',
    -- ROUND 4 INFO
    ROUND_FOUR_GAME_TIME                INT(3)          NULL                        COMMENT '4라운드 경기 시간',
    ROUND_FOUR_BREAK_TIME               INT(3)          NULL                        COMMENT '4라운드 휴식 시간',
    ROUND_FOUR_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '4라운드 더블타겟 미트 갯수',
    ROUND_FOUR_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '4라운드 대형 미트 갯수',
    -- ROUND 5 INFO()
    ROUND_FIVE_GAME_TIME                INT(3)          NULL                        COMMENT '5라운드 경기 시간',
    ROUND_FIVE_BREAK_TIME               INT(3)          NULL                        COMMENT '5라운드 휴식 시간',
    ROUND_FIVE_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '5라운드 더블타겟 미트 갯수',
    ROUND_FIVE_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '5라운드 대형 미트 갯수',
    WEIGHT_CLASS_ORDER                  INT(3)          NOT NULL                    COMMENT '체급 정렬순서'
)
COMMENT '체급 테이블';

ALTER TABLE TB_WEIGHT_CLASS
    ADD CONSTRAINT fk_WeightClass_EventIndex
        FOREIGN KEY (EVENT_INDEX) REFERENCES TB_EVENT (EVENT_INDEX);

CREATE INDEX pk_Idx_WeightClass_WeightClassIndex ON TB_WEIGHT_CLASS (WEIGHT_CLASS_INDEX ASC);
CREATE INDEX fk_Idx_WeightClass_EventIndex ON TB_WEIGHT_CLASS (EVENT_INDEX ASC);
CREATE INDEX Idx_WeightClass_WeightClassOrder ON TB_WEIGHT_CLASS (WEIGHT_CLASS_ORDER ASC);

-- TEMPLATE TABLE CREATE

CREATE TABLE TB_COMPETITION_TEMPLATE
(
    COMPETITION_INDEX               INT(10)         AUTO_INCREMENT PRIMARY KEY  COMMENT '대회 INDEX',
    COMPETITION_NAME                VARCHAR(100)    NOT NULL                    COMMENT '대회 이름',
    COMPETITION_GRADE               INT(1)          NULL                        COMMENT '대회 등급',
    COMPETITION_HOST_INSTITUTION    VARCHAR(50)     NOT NULL                    COMMENT '주최 기관',
    COMPETITION_START_DATE          DATE            NOT NULL                    COMMENT '대회 시작 날짜',
    COMPETITION_END_DATE            DATE            NOT NULL                    COMMENT '대회 종료 날짜',
    REGISTRATION_START_DATE         DATE            NOT NULL                    COMMENT '등록 시작 날짜',
    REGISTRATION_END_DATE           DATE            NOT NULL                    COMMENT '등록 종료 날짜',
    CORRECTION_START_DATE           DATE            NOT NULL                    COMMENT '정정 시작 날짜',
    CORRECTION_END_DATE             DATE            NOT NULL                    COMMENT '정정 종료 날짜',
    COMPETITION_LOGO_PATH           VARCHAR(255)    NOT NULL                    COMMENT '대회 로고 S3경로',
    COMPETITION_IMAGE_PATH          VARCHAR(255)    NOT NULL                    COMMENT '대회 이미지 S3경로'
)
    COMMENT '대회 테이블';

CREATE INDEX pk_Idx_CompetitionTemplate_CompetitionIndex ON TB_COMPETITION_TEMPLATE (COMPETITION_INDEX ASC);

CREATE TABLE TB_EVENT_TEMPLATE
(
    EVENT_INDEX                         INT(10)         AUTO_INCREMENT PRIMARY KEY  COMMENT '종목 INDEX',
    COMPETITION_INDEX                   INT(10)         NOT NULL                    COMMENT '대회 INDEX',
    EVENT_NAME                          VARCHAR(100)    NOT NULL                    COMMENT '종목 이름',
    EVENT_CLASSIFICATION                INT(1)          NOT NULL                    COMMENT '분류',
    EVENT_TYPE                          INT(1)          NOT NULL                    COMMENT '유형',
    EVENT_RATING                        INT(1)          NOT NULL                    COMMENT '등급',
    ROUND_CNT                           INT(1)          NOT NULL                    COMMENT '라운드 수',
    -- ROUND 1 INFO
    ROUND_ONE_GAME_TIME                 INT(3)          NOT NULL                    COMMENT '1라운드 경기 시간',
    ROUND_ONE_BREAK_TIME                INT(3)          NULL                        COMMENT '1라운드 휴식 시간',
    ROUND_ONE_DOUBLE_TARGET_MITT_CNT    INT(1)          NULL                        COMMENT '1라운드 더블타겟 미트 갯수',
    ROUND_ONE_LARGE_MITT_CNT            INT(1)          NULL                        COMMENT '1라운드 대형 미트 갯수',
    -- ROUND 2 INFO
    ROUND_TWO_GAME_TIME                 INT(3)          NULL                        COMMENT '2라운드 경기 시간',
    ROUND_TWO_BREAK_TIME                INT(3)          NULL                        COMMENT '2라운드 휴식 시간',
    ROUND_TWO_DOUBLE_TARGET_MITT_CNT    INT(1)          NULL                        COMMENT '2라운드 더블타겟 미트 갯수',
    ROUND_TWO_LARGE_MITT_CNT            INT(1)          NULL                        COMMENT '2라운드 대형 미트 갯수',
    -- ROUND 3 INFO
    ROUND_TREE_GAME_TIME                INT(3)          NULL                        COMMENT '3라운드 경기 시간',
    ROUND_TREE_BREAK_TIME               INT(3)          NULL                        COMMENT '3라운드 휴식 시간',
    ROUND_TREE_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '3라운드 더블타겟 미트 갯수',
    ROUND_TREE_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '3라운드 대형 미트 갯수',
    -- ROUND 4 INFO
    ROUND_FOUR_GAME_TIME                INT(3)          NULL                        COMMENT '4라운드 경기 시간',
    ROUND_FOUR_BREAK_TIME               INT(3)          NULL                        COMMENT '4라운드 휴식 시간',
    ROUND_FOUR_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '4라운드 더블타겟 미트 갯수',
    ROUND_FOUR_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '4라운드 대형 미트 갯수',
    -- ROUND 5 INFO()
    ROUND_FIVE_GAME_TIME                INT(3)          NULL                        COMMENT '5라운드 경기 시간',
    ROUND_FIVE_BREAK_TIME               INT(3)          NULL                        COMMENT '5라운드 휴식 시간',
    ROUND_FIVE_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '5라운드 더블타겟 미트 갯수',
    ROUND_FIVE_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '5라운드 대형 미트 갯수'
)
    COMMENT '종목 테이블';

ALTER TABLE TB_EVENT_TEMPLATE
    ADD CONSTRAINT fk_EventTemplate_CompetitionIndex
        FOREIGN KEY (COMPETITION_INDEX) REFERENCES TB_COMPETITION_TEMPLATE (COMPETITION_INDEX);

CREATE INDEX pk_Idx_EventTemplate_EventIndex ON TB_EVENT_TEMPLATE (EVENT_INDEX ASC);
CREATE INDEX fk_Idx_EventTemplate_CompetitionIndex ON TB_EVENT_TEMPLATE (COMPETITION_INDEX ASC);

CREATE TABLE TB_WEIGHT_CLASS_TEMPLATE
(
    WEIGHT_CLASS_INDEX                  INT(10)         AUTO_INCREMENT PRIMARY KEY  COMMENT '체급 INDEX',
    EVENT_INDEX                         INT(10)         NOT NULL                    COMMENT '종목 INDEX',
    WEIGHT_CLASS_NAME                   VARCHAR(100)    NOT NULL                    COMMENT '체급명',
    ROUND_CNT                           INT(10)         NOT NULL                    COMMENT '라운드 수',
    -- ROUND 1 INFO
    ROUND_ONE_GAME_TIME                 INT(3)          NOT NULL                    COMMENT '1라운드 경기 시간',
    ROUND_ONE_BREAK_TIME                INT(3)          NULL                        COMMENT '1라운드 휴식 시간',
    ROUND_ONE_DOUBLE_TARGET_MITT_CNT    INT(1)          NULL                        COMMENT '1라운드 더블타겟 미트 갯수',
    ROUND_ONE_LARGE_MITT_CNT            INT(1)          NULL                        COMMENT '1라운드 대형 미트 갯수',
    -- ROUND 2 INFO
    ROUND_TWO_GAME_TIME                 INT(3)          NULL                        COMMENT '2라운드 경기 시간',
    ROUND_TWO_BREAK_TIME                INT(3)          NULL                        COMMENT '2라운드 휴식 시간',
    ROUND_TWO_DOUBLE_TARGET_MITT_CNT    INT(1)          NULL                        COMMENT '2라운드 더블타겟 미트 갯수',
    ROUND_TWO_LARGE_MITT_CNT            INT(1)          NULL                        COMMENT '2라운드 대형 미트 갯수',
    -- ROUND 3 INFO
    ROUND_TREE_GAME_TIME                INT(3)          NULL                        COMMENT '3라운드 경기 시간',
    ROUND_TREE_BREAK_TIME               INT(3)          NULL                        COMMENT '3라운드 휴식 시간',
    ROUND_TREE_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '3라운드 더블타겟 미트 갯수',
    ROUND_TREE_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '3라운드 대형 미트 갯수',
    -- ROUND 4 INFO
    ROUND_FOUR_GAME_TIME                INT(3)          NULL                        COMMENT '4라운드 경기 시간',
    ROUND_FOUR_BREAK_TIME               INT(3)          NULL                        COMMENT '4라운드 휴식 시간',
    ROUND_FOUR_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '4라운드 더블타겟 미트 갯수',
    ROUND_FOUR_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '4라운드 대형 미트 갯수',
    -- ROUND 5 INFO()
    ROUND_FIVE_GAME_TIME                INT(3)          NULL                        COMMENT '5라운드 경기 시간',
    ROUND_FIVE_BREAK_TIME               INT(3)          NULL                        COMMENT '5라운드 휴식 시간',
    ROUND_FIVE_DOUBLE_TARGET_MITT_CNT   INT(1)          NULL                        COMMENT '5라운드 더블타겟 미트 갯수',
    ROUND_FIVE_LARGE_MITT_CNT           INT(1)          NULL                        COMMENT '5라운드 대형 미트 갯수'
)
    COMMENT '체급 테이블';

ALTER TABLE TB_WEIGHT_CLASS_TEMPLATE
    ADD CONSTRAINT fk_WeightClassTemplate_EventIndex
        FOREIGN KEY (EVENT_INDEX) REFERENCES TB_EVENT (EVENT_INDEX);

CREATE INDEX pk_Idx_WeightClassTemplate_WeightClassIndex ON TB_WEIGHT_CLASS_TEMPLATE (WEIGHT_CLASS_INDEX ASC);
CREATE INDEX fk_Idx_WeightClassTemplate_EventIndex ON TB_WEIGHT_CLASS_TEMPLATE (EVENT_INDEX ASC);