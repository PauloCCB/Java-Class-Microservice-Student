package com.tecylab.ms.students.app.student_service.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {
    //"  " Esto son espacios en blancos, el notblank es para que no tenga espacios en blanco
    @NotBlank(message = "Field first Name cannot be empty or null")
    private String firstName;

    @NotBlank(message = "Field last Name cannot be empty or null")
    private String lastName;

    @NotNull(message = "Field age cannot be null")
    @Min(value = 1, message = "Field age greater than zero")
    private String age;

    private String address;

}
