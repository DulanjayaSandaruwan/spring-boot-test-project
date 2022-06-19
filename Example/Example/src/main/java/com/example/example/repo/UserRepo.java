package com.example.example.repo;

import com.example.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 18/06/2022
 **/
public interface UserRepo extends JpaRepository<User, Integer> {
}
