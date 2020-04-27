package com.korabelska.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    private Long id;
    private String firstName;
    private LocalDate dateOfBirth;

    @MappedCollection
    private List<PatientDiagnosis> patientDiagnoses;

    @MappedCollection
    private Set<Bill>bills;

    public static Patient create(String firstName, LocalDate dateOfBirth) {
        return new Patient(null, firstName, dateOfBirth, null,null);
    }

    public static Patient create(String firstName, LocalDate dateOfBirth,
                                 List<PatientDiagnosis> patientDiagnoses) {
        return new Patient(null, firstName, dateOfBirth, patientDiagnoses,null);
    }

    public static Patient create(String firstName, LocalDate dateOfBirth,
                                 List<PatientDiagnosis> patientDiagnoses,Set<Bill> bills) {
        return new Patient(null, firstName, dateOfBirth, patientDiagnoses,bills);
    }

    public void addPatientDiagnosis(PatientDiagnosis patientDiagnosis) {
        if(this.patientDiagnoses == null){
            patientDiagnoses = new ArrayList<>();
        }
        this.patientDiagnoses.add(patientDiagnosis);
    }

    public void addBill(Bill bill) {
        if(this.bills == null){
            bills = new HashSet<>();
        }
        this.bills.add(bill);
    }


}
