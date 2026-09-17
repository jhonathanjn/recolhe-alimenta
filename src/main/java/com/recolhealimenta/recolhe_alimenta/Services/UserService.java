package com.recolhealimenta.recolhe_alimenta.Services;

import com.recolhealimenta.recolhe_alimenta.Dtos.UserDTO;
import com.recolhealimenta.recolhe_alimenta.Models.User;
import com.recolhealimenta.recolhe_alimenta.Repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepositorie userRepositorie;

    public List<User> getAll(){
        List<User> users = userRepositorie.findAll();
        return users;
    }

    public User getById(Long id){
        User user = userRepositorie.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        return user;
    }

    public User addUser(UserDTO dto){
        User newUser = new User();

        if (dto.getName() == null || dto.getPassword() == null){
            throw new RuntimeException("Preencha os campos obrigatórios!");
        }else if (dto.getEmail().isEmpty()){
            throw new RuntimeException("Email ja em uso!");
        }else {

            newUser.setName(dto.getName());
            newUser.setEmail(dto.getEmail());
            newUser.setPassword(dto.getPassword());
        }

        return userRepositorie.save(newUser);
    }

    public User updateUser(Long id, UserDTO dto){
        User user = userRepositorie.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (dto.getName() == null || dto.getName().isEmpty()
                || dto.getEmail() == null || dto.getEmail().isEmpty()
                || dto.getPassword() == null || dto.getPassword().isEmpty()){
            throw new RuntimeException("Preencha os campos obrigatórios!");
        }else if (userRepositorie.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email ja em uso!");
        }else {

            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
        }

        return userRepositorie.save(user);
    }

    public void deleteById(Long id){
        User user = userRepositorie.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        userRepositorie.delete(user);
    }

}
