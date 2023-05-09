package com.yuriikniazyk.demo.controllers;


import com.yuriikniazyk.demo.db.entities.ClassOfSchool;
import com.yuriikniazyk.demo.models.ClassRequestModel;
import com.yuriikniazyk.demo.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("classes")
public class ClassController {
    @Autowired
    private ClassService classService = new ClassService();

    @PostMapping()
    public @ResponseBody Integer addNewClass (@RequestBody ClassRequestModel classRequestModel) throws Exception {
        try {
            return classService.createClass(classRequestModel);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @PutMapping(path="/{classId}")
    public @ResponseBody Integer updateClass (@PathVariable int classId, @RequestBody ClassRequestModel classRequestModel) throws Exception {
        try {
            return classService.updateClass(classId, classRequestModel);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @DeleteMapping(path="/{classId}")
    public @ResponseBody HttpStatus deleteClass (@PathVariable int classId) throws Exception {
        try {
            return classService.deleteClass(classId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping()
    public @ResponseBody Iterable<ClassOfSchool> getAllClasses() throws Exception {
        try {
            return classService.getAllClasses();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    @GetMapping(path="/{classId}")
    public @ResponseBody ClassOfSchool getClassById(@PathVariable int classId) throws Exception {
        try {
            return classService.getClassById(classId);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}