package com.itmuch.cloud.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itmuch.cloud.user.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
