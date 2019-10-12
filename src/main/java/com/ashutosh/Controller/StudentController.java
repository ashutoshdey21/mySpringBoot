package com.ashutosh.Controller;

import com.ashutosh.Entity.Student;
import com.ashutosh.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/getStudents", method = RequestMethod.GET)
    public Collection<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentByID(@PathVariable("id") int id){
        return this.studentService.getStudentByID(id);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeStudentByID(@PathVariable("id") int id){
        this.studentService.removeStudentByID(id);

    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student){
        this.studentService.updateStudent(student);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student){
        this.studentService.insertStudent(student);
    }
}
