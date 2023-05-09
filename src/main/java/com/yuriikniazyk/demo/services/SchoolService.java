package com.yuriikniazyk.demo.services;

import com.yuriikniazyk.demo.db.entities.School;
import com.yuriikniazyk.demo.db.repository.SchoolRepository;
import com.yuriikniazyk.demo.enums.Status;
import com.yuriikniazyk.demo.models.SchoolRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;
    public int createSchool(SchoolRequestModel schoolRequestModel) throws Exception {
        try {
            School school = new School();

            school.setName(schoolRequestModel.getName());
            school.setStatus(Status.ACTIVE);
            schoolRepository.save(school);

            return school.getId();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public int updateSchool(int schoolId, SchoolRequestModel schoolRequestModel) throws Exception {
        try {
            School school = schoolRepository.findById(schoolId).orElseThrow(() -> new Exception("School not exist with id: " + schoolId));

            school.setName(schoolRequestModel.getName());
            schoolRepository.save(school);

            return school.getId();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public HttpStatus deleteSchool(int schoolId) throws Exception {
        try {
            School school = schoolRepository.findById(schoolId).orElseThrow(() -> new Exception("School not exist with id: " + schoolId));
            schoolRepository.deleteById(schoolId);

            return HttpStatus.OK;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Iterable<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    public School getSchoolById(int schoolId) throws Exception {
        try {
            return schoolRepository.findById(schoolId).orElseThrow(() -> new Exception("School not exist with id: " + schoolId));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
