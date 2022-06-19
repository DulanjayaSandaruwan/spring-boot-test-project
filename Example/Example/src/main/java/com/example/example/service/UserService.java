package com.example.example.service;

import com.example.example.dto.UserDTO;
import com.example.example.entity.User;
import com.example.example.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 18/06/2022
 **/

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getUserAllUsers(){
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    //user id > user details
    //select * from user where id = 2

    public UserDTO getUserByUserID(String userId){
        User user = userRepo.getUserByUserID(userId);
        return modelMapper.map(user, UserDTO.class);
    }

    //user id, address > user details
    //select * from user where id = 2 and address = "Kalawana"
    public UserDTO getUserByUserIDAndAddress(String userId, String address){
        User user =userRepo.getUserByUserIDAndAddress(userId,address);
        return modelMapper.map(user,UserDTO.class);
    }
}
