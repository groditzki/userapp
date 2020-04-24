package com.haegerconsulting.userservice.controller;

import com.haegerconsulting.userservice.model.User;
import com.haegerconsulting.userservice.service.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RestController
public class UserController {

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    private UserService userService;

    @GetMapping(value="/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<User>> getUsers ()
    {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping (value="/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser (@RequestBody User user)
    {
        User savedUser = userService.create(user);
        return ResponseEntity.created(URI.create("/"+savedUser.getUserName())).body(savedUser);
    }

    @GetMapping (value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser (@PathVariable("id") Long id)
    {
        User foundUser = userService.get(id);
        return ResponseEntity.ok(foundUser);

    }

    @DeleteMapping (value = "/users/{id}")
    public HttpStatus deleteUser (@PathVariable("id") Long id)
    {
        userService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping (value = "/searchByUserName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<User>> searchUsers(@RequestParam(name = "userName") String searchString)
    {
        return ResponseEntity.ok(userService.searchUsersByUserName(searchString));
    }


}
