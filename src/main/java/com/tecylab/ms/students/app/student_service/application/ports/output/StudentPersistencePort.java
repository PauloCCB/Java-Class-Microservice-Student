package com.tecylab.ms.students.app.student_service.application.ports.output;

import com.tecylab.ms.students.app.student_service.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentPersistencePort {
    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Long id);

}
