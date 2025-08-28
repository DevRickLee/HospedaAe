package br.com.devlee.hospedaae.controller;

import br.com.devlee.hospedaae.dto.UserResponseDTO;
import br.com.devlee.hospedaae.model.UserModel;
import br.com.devlee.hospedaae.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO>getall(){return userService.getAll();}

    @PostMapping
    public UserResponseDTO create(@Valid @RequestBody UserModel user){
        UserModel savedUser = userService.save(user);
        return userService.toDTO(savedUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public UserModel update(@PathVariable UUID id, @Valid @RequestBody UserModel updatedUser){
        return userService.update(id, updatedUser);
    }
}
