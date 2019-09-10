package com.rleon.EWS060819ApiRestCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rleon.EWS060819ApiRestCrud.entity.User;
import com.rleon.EWS060819ApiRestCrud.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/getUsers")
    public Iterable<User> getUsers() {
        return repository.findAll();
    }

    @PostMapping("/add/{name}/{lastname}")
    public void addUser(@PathVariable("name") String name, @PathVariable("lastname") String lastname) {

        User u = new User();
        u.setName(name);
        u.setLastName(lastname);
        repository.save(u);

    }

}
