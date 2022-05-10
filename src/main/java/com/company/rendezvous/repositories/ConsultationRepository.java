package com.company.rendezvous.repositories;

import com.company.rendezvous.entities.Consultation;
import com.company.rendezvous.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
