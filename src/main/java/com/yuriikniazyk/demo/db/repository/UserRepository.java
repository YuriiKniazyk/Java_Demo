package com.yuriikniazyk.demo.db.repository;

import com.yuriikniazyk.demo.db.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {}
