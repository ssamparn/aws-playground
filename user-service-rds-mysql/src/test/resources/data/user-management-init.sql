create table `user` (
                           `user_id` serial PRIMARY KEY,
                           `user_name` VARCHAR(30) NOT NULL,
                           `user_salary` DOUBLE PRECISION(7, 2) NOT NULL
);

insert into `user` (`user_name`, `user_salary`) values ('Sashank', 59.60);
insert into `user` (`user_name`, `user_salary`) values ('Aparna', 30.40);
insert into `user` (`user_name`, `user_salary`) values ('Nalini', 46.40);