package com.yuriikniazyk.demo.db.repository;

import com.yuriikniazyk.demo.db.entities.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepository extends CrudRepository<School, Integer> {}
