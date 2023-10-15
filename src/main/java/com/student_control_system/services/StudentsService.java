package com.student_control_system.services;

import com.student_control_system.domain.Students;

import java.util.List;

public interface StudentsService {
    public List<Students> listAllStudents();
    public Students saveStudent(Students student);
    public Students getStudentById(long id);
    public Students updateStudent(Students student);

    public void deleteStudent(long id);

}
