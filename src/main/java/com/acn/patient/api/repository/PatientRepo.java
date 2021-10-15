package com.acn.patient.api.repository;

import com.acn.patient.api.model.PatientInnerJSON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<PatientInnerJSON, String> {

    @Override
    Optional<PatientInnerJSON> findById(String hci);
}
