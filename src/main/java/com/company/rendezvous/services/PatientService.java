package com.company.rendezvous.services;

import com.company.rendezvous.entities.Patient;

public interface PatientService {
    Patient ajouterPatient(Patient patient);
    boolean supprimerPatient(Patient patient);
    void modifierPatient(Patient patient);
}
