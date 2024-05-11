DROP TABLE IF EXISTS user CASCADE;

create table `user` (
    `user_id` serial PRIMARY KEY,
    `user_name` VARCHAR(30) NOT NULL,
    `user_salary` DOUBLE PRECISION(7, 2) NOT NULL
);