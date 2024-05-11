package com.aws.rds.mysql.userservicerdsmysql.service;

import com.aws.rds.mysql.userservicerdsmysql.entity.User;
import com.aws.rds.mysql.userservicerdsmysql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User updateUserById(Long id, User user) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User originalUser = userOptional.get();

            if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
                originalUser.setUserName(user.getUserName());
            }
            if (user.getUserSalary() != 0) {
                originalUser.setUserSalary(user.getUserSalary());
            }
            return userRepository.save(originalUser);
        }
        return null;
    }

    @Override
    public String deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "No such user in the database";
    }
}
