package com.recolhealimenta.recolhe_alimenta.Controllers;

import com.recolhealimenta.recolhe_alimenta.Dtos.UserDTO;
import com.recolhealimenta.recolhe_alimenta.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity allUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findUser(@PathVariable(value = "id") @RequestBody Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity newUser(@RequestBody UserDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable(value = "id") Long id, @RequestBody UserDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
