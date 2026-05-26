package api_rest.tv_shows.services;

import api_rest.tv_shows.dtos.CreateUserDTO;
import api_rest.tv_shows.models.User;
import api_rest.tv_shows.models.UserRole;
import api_rest.tv_shows.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User registerUser(CreateUserDTO user) {
        //Buscar si existe el usuario
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario ya existe");
        }

        User newUser = new User();
        newUser.setRole(UserRole.ROLE_USER);
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword())); //HASHEAR PASSWORD

        return userRepository.save(newUser);
    }
}
