package com.movieuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movieuser.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
