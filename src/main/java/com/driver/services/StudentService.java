package com.driver.services;

import com.driver.models.Student;
import com.driver.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    CardService cardService4;

    @Autowired
    StudentRepository studentRepository4;

    public List<Student> getStudent()
    {
        return studentRepository4.findAll();
    }
    public Student getDetailsByEmail(String email){
        Student student = null;
        List<Student> s = studentRepository4.findAll();
        for(Student st : s)
        {
            if(st.getEmailId().equals(email))
            {
                return st;
            }
        }
        return student;
    }

    public Student getDetailsById(int id){
        Student student = null;
        Optional<Student> s = studentRepository4.findById(id);
        return s.get();
    }

    public void createStudent(Student student){
         studentRepository4.save(student);
    }

    public void updateStudent(Student student){
            studentRepository4.save(student);
            //studentRepository4.save(s);

    }

    public void deleteStudent(int id){
        //Delete student and deactivate corresponding card
        studentRepository4.deleteById(id);
    }
}
