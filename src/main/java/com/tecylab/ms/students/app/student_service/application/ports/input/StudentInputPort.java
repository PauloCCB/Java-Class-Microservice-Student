package com.tecylab.ms.students.app.student_service.application.ports.input;

import com.tecylab.ms.students.app.student_service.domain.model.Student;

import java.util.List;

public interface StudentInputPort {
    Student findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    Student update(Long id, Student student);
    void deleteById(Long id);
}
