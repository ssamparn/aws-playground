package com.aws.rds.mysql.userservicerdsmysql.repository;

import com.aws.rds.mysql.userservicerdsmysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
