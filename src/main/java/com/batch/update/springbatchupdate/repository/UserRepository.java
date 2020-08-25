package com.batch.update.springbatchupdate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.batch.update.springbatchupdate.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
