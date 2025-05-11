package com.AirbnbClone.airbnb.Service;

import com.AirbnbClone.airbnb.Entity.User;
import com.AirbnbClone.airbnb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Get all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //createUser
    public User createUser(User user){
        return userRepository.save(user);
    }

    //GetUserById
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    //deleteUser
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
