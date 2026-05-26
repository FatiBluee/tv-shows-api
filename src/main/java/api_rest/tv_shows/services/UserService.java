package api_rest.tv_shows.services;

import api_rest.tv_shows.dtos.CreateUserDTO;
import api_rest.tv_shows.models.User;

public interface UserService {
    User registerUser(CreateUserDTO user);
}
