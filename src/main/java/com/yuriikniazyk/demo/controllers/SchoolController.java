package com.yuriikniazyk.demo.controllers;

import com.yuriikniazyk.demo.db.entities.School;
import com.yuriikniazyk.demo.models.SchoolRequestModel;
import com.yuriikniazyk.demo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService = new SchoolService();

    @PostMapping()
    public @ResponseBody Integer addNewSchool (@RequestBody SchoolRequestModel schoolRequestModel) throws Exception {
        try {
            return schoolService.createSchool(schoolRequestModel);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @PutMapping(path="/{schoolId}")
    public @ResponseBody Integer updateSchool (@PathVariable int schoolId, @RequestBody SchoolRequestModel schoolRequestModel) throws Exception {
        try {
            return schoolService.updateSchool(schoolId, schoolRequestModel);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @DeleteMapping(path="/{schoolId}")
    public @ResponseBody HttpStatus deleteSchool (@PathVariable int schoolId) throws Exception {
        try {
            return schoolService.deleteSchool(schoolId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping()
    public @ResponseBody Iterable<School> getAllSchools() throws Exception {
        try {
            return schoolService.getAllSchools();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    @GetMapping(path="/{schoolId}")
    public @ResponseBody School getSchoolById(@PathVariable int schoolId) throws Exception {
        try {
            return schoolService.getSchoolById(schoolId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}