package com.demo.usermanagementusingpagesort.service;

import com.demo.usermanagementusingpagesort.entity.User;
import com.demo.usermanagementusingpagesort.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> search(String term) {
        return userRepository.findByNameContaining(term);
    }

    @Override
    public User findOne(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
