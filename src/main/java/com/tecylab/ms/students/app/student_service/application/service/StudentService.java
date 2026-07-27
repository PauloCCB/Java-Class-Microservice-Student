package com.tecylab.ms.students.app.student_service.application.service;

import com.tecylab.ms.students.app.student_service.StudentServiceApplication;
import com.tecylab.ms.students.app.student_service.application.ports.input.StudentInputPort;
import com.tecylab.ms.students.app.student_service.application.ports.output.StudentPersistencePort;
import com.tecylab.ms.students.app.student_service.domain.exception.StudentNotFoundException;
import com.tecylab.ms.students.app.student_service.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


// Un caso de uso implementa un puerto de entrada y usa un puerto de salida
@Service
@RequiredArgsConstructor
public class StudentService implements StudentInputPort {
    //Uso de puerto de salida
    private final StudentPersistencePort persistencePort;
    //? Retorno de un supplier
    @Override
    public Student findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }

    @Override
    public Student save(Student student) {
        return persistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {

        return persistencePort.findById(id)
                .map(savedStudent -> {
                    savedStudent.setFirstName(student.getFirstName());
                    savedStudent.setLastName(student.getLastName());
                    savedStudent.setAge(student.getAge());
                    savedStudent.setAddress(student.getAddress());
                    return persistencePort.save(savedStudent);
                })
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(persistencePort.findById(id).isEmpty()) {
            throw new StudentNotFoundException();
        }
        persistencePort.deleteById(id);
    }
}
