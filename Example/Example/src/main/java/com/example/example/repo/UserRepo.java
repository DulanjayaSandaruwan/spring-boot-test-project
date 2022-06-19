package com.example.example.repo;

import com.example.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 18/06/2022
 **/
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user WHERE id = ?1", nativeQuery = true)
    User getUserByUserID(String userId);

    @Query(value = "SELECT * FROM user WHERE id =?1 AND address =?2",nativeQuery = true)
    User getUserByUserIDAndAddress(String userId,String address);

}
