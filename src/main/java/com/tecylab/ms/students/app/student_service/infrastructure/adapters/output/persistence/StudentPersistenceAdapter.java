package com.tecylab.ms.students.app.student_service.infrastructure.adapters.output.persistence;

import com.tecylab.ms.students.app.student_service.application.ports.output.StudentPersistencePort;
import com.tecylab.ms.students.app.student_service.domain.model.Student;
import com.tecylab.ms.students.app.student_service.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.tecylab.ms.students.app.student_service.infrastructure.adapters.output.persistence.repository.StudentJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

    private final StudentPersistenceMapper mapper;
    private final StudentJPARepository repository;
    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id).
                map(entity -> mapper.toStudent(entity));
    }

    @Override
    public List<Student> findAll() {
        return mapper.toStudentList(repository.findAll());
    }

    @Override
    public Student save(Student student) {
        return mapper.toStudent(repository.save(mapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
