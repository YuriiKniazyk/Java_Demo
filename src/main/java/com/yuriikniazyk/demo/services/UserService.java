package com.yuriikniazyk.demo.services;

import com.yuriikniazyk.demo.db.entities.School;
import com.yuriikniazyk.demo.db.entities.User;
import com.yuriikniazyk.demo.db.repository.SchoolRepository;
import com.yuriikniazyk.demo.db.repository.UserRepository;
import com.yuriikniazyk.demo.enums.Status;
import com.yuriikniazyk.demo.models.UserRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public int createUser(UserRequestModel userRequestModel) throws Exception {
        try {
            User user = new User();
            user.setName(userRequestModel.getName());
            user.setSurname(userRequestModel.getSurname());
            user.setEmail(userRequestModel.getEmail());
            user.setRole(userRequestModel.getRole());
            user.setStatus(Status.ACTIVE);

            School school = schoolRepository.findById(userRequestModel.getSchoolId()).orElseThrow(() -> new Exception("School not exist with id: " + userRequestModel.getSchoolId()));
            user.setSchool(school);
            userRepository.save(user);

            return user.getId();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public int updateUser(int userId, UserRequestModel userRequestModel) throws Exception {
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not exist with id: " + userId));

            user.setName(userRequestModel.getName());
            user.setSurname(userRequestModel.getSurname());
            user.setEmail(userRequestModel.getEmail());
            user.setRole(userRequestModel.getRole());

            School school = schoolRepository.findById(userRequestModel.getSchoolId()).orElseThrow(() -> new Exception("School not exist with id: " + userRequestModel.getSchoolId()));
            user.setSchool(school);
            userRepository.save(user);

            return user.getId();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public HttpStatus deleteUser(int userId) throws Exception {
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not exist with id: " + userId));
            userRepository.deleteById(userId);

            return HttpStatus.OK;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int userId) throws Exception {
        try {
            return userRepository.findById(userId).orElseThrow(() -> new Exception("User not exist with id: " + userId));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
