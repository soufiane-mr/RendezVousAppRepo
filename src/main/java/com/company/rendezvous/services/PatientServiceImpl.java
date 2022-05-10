package com.company.rendezvous.services;

import com.company.rendezvous.entities.Patient;
import com.company.rendezvous.entities.RendezVous;
import com.company.rendezvous.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class PatientServiceImpl implements PatientService{

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Patient ajouterPatient(Patient patient) {
        Patient pat = new Patient(patient.getId(), patient.getNom(), patient.getDateNaissance(), patient.isMalde(), new ArrayList<RendezVous>());
        patientRepository.save(pat);
        return pat;
    }

    @Transactional
    public boolean supprimerPatient(Patient patient) {
        return false;
    }

    @Transactional
    public void modifierPatient(Patient patient) {

    }
}
