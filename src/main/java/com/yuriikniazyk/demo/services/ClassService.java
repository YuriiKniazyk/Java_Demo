package com.yuriikniazyk.demo.services;

import com.yuriikniazyk.demo.db.entities.ClassOfSchool;
import com.yuriikniazyk.demo.db.entities.School;
import com.yuriikniazyk.demo.db.repository.ClassRepository;
import com.yuriikniazyk.demo.db.repository.SchoolRepository;
import com.yuriikniazyk.demo.enums.Status;
import com.yuriikniazyk.demo.models.ClassRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    public int createClass(ClassRequestModel classRequestModel) throws Exception {
        try {
            ClassOfSchool classOfSchool = new ClassOfSchool();
            classOfSchool.setName(classRequestModel.getName());
            classOfSchool.setStatus(Status.ACTIVE);

            School school = schoolRepository.findById(classRequestModel.getSchoolId()).orElseThrow(() -> new Exception("School not exist with id: " + classRequestModel.getSchoolId()));
            classOfSchool.setSchool(school);
            classRepository.save(classOfSchool);

            return classOfSchool.getId();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public int updateClass(int classId, ClassRequestModel classRequestModel) throws Exception {
        try {
            ClassOfSchool classOfSchool = classRepository.findById(classId).orElseThrow(() -> new Exception("Class not exist with id: " + classId));
            classOfSchool.setName(classRequestModel.getName());

            School school = schoolRepository.findById(classRequestModel.getSchoolId()).orElseThrow(() -> new Exception("School not exist with id: " + classRequestModel.getSchoolId()));
            classOfSchool.setSchool(school);
            classRepository.save(classOfSchool);

            return classOfSchool.getId();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public HttpStatus deleteClass(int classId) throws Exception {
        try {
            ClassOfSchool classOfSchool = classRepository.findById(classId).orElseThrow(() -> new Exception("Class not exist with id: " + classId));
            classRepository.deleteById(classId);

            return HttpStatus.OK;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Iterable<ClassOfSchool> getAllClasses(){
        return classRepository.findAll();
    }

    public ClassOfSchool getClassById(int classId) throws Exception {
        try {
            return classRepository.findById(classId).orElseThrow(() -> new Exception("Class not exist with id: " + classId));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
