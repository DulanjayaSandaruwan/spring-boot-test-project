package com.example.example.controller;

import com.example.example.dto.UserDTO;
import com.example.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 18/06/2022
 **/

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser() {
        return userService.getUserAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO) {
        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getUserByUserID/{userId}")
    public UserDTO getUserByUserID(@PathVariable String userId){
        return userService.getUserByUserID(userId);
    }

    @GetMapping("/getUserByUserIDAndAddress/{userID}/{address}")
    public UserDTO getUserByUserIDAndAddress(@PathVariable String userID ,@PathVariable String address){
        System.out.println("User ID :"+ userID +"User address :" +address);
        return userService.getUserByUserIDAndAddress(userID,address);
    }
}
