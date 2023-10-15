package com.student_control_system.controller;

import com.student_control_system.domain.Students;
import com.student_control_system.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {
    @Autowired
    private StudentsService service;

    @GetMapping("/")
    public String listStudents(Model model) {
        model.addAttribute("students", service.listAllStudents());
        return "home/index";
    }
    @GetMapping("/new")
    public String createStudentForm(Model model) {
        Students student = new Students();
        model.addAttribute("student", student);
        return "home/newstudent";
    }
    @PostMapping("/")
    public String saveStudent(@ModelAttribute("student") Students student) {
        service.saveStudent(student);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "home/editstudent";
    }
    @PostMapping("/{id}")
    public String updateStudent(@PathVariable long id, @ModelAttribute("student") Students student, Model model) {
        Students existingStudent = service.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setName(student.getName());
        existingStudent.setLastname(student.getLastname());
        existingStudent.setEmail(student.getEmail());
        service.updateStudent(existingStudent);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }

}
