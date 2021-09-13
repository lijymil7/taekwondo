-- PROD
CREATE DATABASE TAEKWONDO_PROD CHARACTER SET='utf8mb4' COLLATE='utf8mb4_unicode_ci';

CREATE USER taekwondo_prod IDENTIFIED BY 'taekwondo_prod';

GRANT ALL PRIVILEGES ON TAEKWONDO_PROD.* TO 'taekwondo_prod'@'%' WITH GRANT OPTION;

ALTER  USER 'taekwondo_prod'@'%' IDENTIFIED  WITH  mysql_native_password  BY 'taekwondo_prod';

FLUSH PRIVILEGES;

-- DEV
CREATE DATABASE TAEKWONDO_DEV CHARACTER SET='utf8mb4' COLLATE='utf8mb4_unicode_ci';

CREATE USER taekwondo_dev IDENTIFIED BY 'taekwondo_dev';

GRANT ALL PRIVILEGES ON TAEKWONDO_DEV.* TO 'taekwondo_dev'@'%' WITH GRANT OPTION;

ALTER  USER 'taekwondo_dev'@'%' IDENTIFIED  WITH  mysql_native_password  BY 'taekwondo_dev';

FLUSH PRIVILEGES;

-- LOCAL
CREATE DATABASE TAEKWONDO_LOCAL CHARACTER SET='utf8mb4' COLLATE='utf8mb4_unicode_ci';

CREATE USER taekwondo_local IDENTIFIED BY 'taekwondo_local';

GRANT ALL PRIVILEGES ON TAEKWONDO_LOCAL.* TO 'taekwondo_local'@'%' WITH GRANT OPTION;

ALTER  USER 'taekwondo_local'@'%' IDENTIFIED  WITH  mysql_native_password  BY 'taekwondo_local';

FLUSH PRIVILEGES;
