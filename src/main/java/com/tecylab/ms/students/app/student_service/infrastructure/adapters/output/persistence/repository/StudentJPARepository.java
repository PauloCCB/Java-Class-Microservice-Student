package com.tecylab.ms.students.app.student_service.infrastructure.adapters.output.persistence.repository;

import com.tecylab.ms.students.app.student_service.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJPARepository extends JpaRepository<StudentEntity,Long> {
}
