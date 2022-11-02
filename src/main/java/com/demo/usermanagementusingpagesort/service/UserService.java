package com.demo.usermanagementusingpagesort.service;

import com.demo.usermanagementusingpagesort.entity.User;

import java.util.List;

public interface UserService {

    Iterable<User> findAll();

    List<User> search(String term);

    User findOne(Integer id);

    void save(User contact);

    void delete(Integer id);
}
