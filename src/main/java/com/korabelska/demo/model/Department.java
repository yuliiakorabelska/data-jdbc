package com.korabelska.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    private Long id;

    private String name;

    @MappedCollection
    private Set<Doctor> doctors;

    public static Department create(String name,Set<Doctor> doctors) {
        Department department = new Department(null,name,doctors);
        return department;
    }

    public void addDoctor(Doctor doctor) {
        if(doctors==null) {
            doctors = new HashSet<>();
        }
        doctors.add(doctor);
    }

}
