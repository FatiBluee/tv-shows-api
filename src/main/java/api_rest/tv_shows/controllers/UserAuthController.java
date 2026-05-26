package api_rest.tv_shows.controllers;

import api_rest.tv_shows.dtos.CreateUserDTO;
import api_rest.tv_shows.models.User;
import api_rest.tv_shows.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User signup(@RequestBody CreateUserDTO user) {
        return userService.registerUser(user);
    }
}
