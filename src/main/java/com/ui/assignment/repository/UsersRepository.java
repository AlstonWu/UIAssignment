package com.ui.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ui.assignment.entities.UserEntity;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, String> {

}