package com.tecylab.ms.students.app.student_service.infrastructure.adapters.output.persistence.mapper;

import com.tecylab.ms.students.app.student_service.domain.model.Student;
import com.tecylab.ms.students.app.student_service.infrastructure.adapters.output.persistence.entity.StudentEntity;

import java.util.List;

public interface StudentPersistenceMapper {

    StudentEntity toStudentEntity(Student student);

    Student toStudent(StudentEntity studentEntity);

    List<Student> toStudentList(List<StudentEntity> entities);
}
