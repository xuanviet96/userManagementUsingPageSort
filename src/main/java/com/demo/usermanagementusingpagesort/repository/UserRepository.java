package com.demo.usermanagementusingpagesort.repository;

import com.demo.usermanagementusingpagesort.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer>{
    List<User> findByNameContaining(String term);
}
