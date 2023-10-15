package com.student_control_system.services;

import com.student_control_system.domain.Students;
import com.student_control_system.repos.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentsServiceImpl implements StudentsService{

    @Autowired
    private StudentsRepository repository;
    @Override
    public List<Students> listAllStudents() {
        return repository.findAll();
    }

    @Override
    public Students saveStudent(Students student) {
        return repository.save(student);
    }



    @Override
    public Students getStudentById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Students updateStudent(Students student) {
        return repository.save(student);
    }
    @Override
    public void deleteStudent(long id) {
        repository.deleteById(id);
    }


}
