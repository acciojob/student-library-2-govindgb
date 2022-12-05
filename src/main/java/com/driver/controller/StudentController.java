package com.driver.controller;

import com.driver.models.Student;
import com.driver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Add required annotations
@RestController
public class StudentController {


    @Autowired
    StudentService studentService;

    @GetMapping("/getStudent")
    List<Student> getStudent()
    {
        return studentService.getStudent();
    }


    //Add required annotations


    @GetMapping("/student/studentByEmail/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email){
        Student s = studentService.getDetailsByEmail(email);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    //Add required annotations

    @GetMapping("/student/studentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){

       Student s =  studentService.getDetailsById(id);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    //Add required annotations


    @PostMapping("/createStudent")
    public ResponseEntity createStudent(@RequestBody() Student student){

        studentService.createStudent(student);
        return new ResponseEntity<>("the student is successfully added to the system", HttpStatus.CREATED);
    }

    //Add required annotations

    @PutMapping("/updateStudent")
    public ResponseEntity updateStudent(@RequestBody() Student student){
        studentService.updateStudent(student);
        return new ResponseEntity<>("student is updated", HttpStatus.ACCEPTED);
    }

    //Add required annotations
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }

}
