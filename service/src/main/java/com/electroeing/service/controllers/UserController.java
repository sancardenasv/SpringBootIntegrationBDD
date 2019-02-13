package com.electroeing.service.controllers;

import com.electroeing.service.dto.RestResponse;
import com.electroeing.service.entities.UserEntity;
import com.electroeing.service.exceptions.UserException;
import com.electroeing.service.repository.UserRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserRepository userRepository;

    @Value("${application.enabled}")
    private boolean enabled;

    @RequestMapping(method = RequestMethod.GET, path = "/getAll")
    public RestResponse getAllUsers() {
        try {
            RestResponse response = new RestResponse("OK", "");
            response.addDataEntry("userList", new Gson().toJson(userRepository.findAll()));
            return response;
        } catch (Exception e) {
            logger.error("Error getting user list", e);
            throw new UserException("Error getting user list - ".concat(e.getMessage()));
        }
    }
}
