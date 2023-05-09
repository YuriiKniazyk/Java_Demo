package com.yuriikniazyk.demo.db.repository;

import com.yuriikniazyk.demo.db.entities.ClassOfSchool;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<ClassOfSchool, Integer> {}
