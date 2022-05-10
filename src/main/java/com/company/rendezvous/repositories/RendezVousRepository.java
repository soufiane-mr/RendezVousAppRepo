package com.company.rendezvous.repositories;

import com.company.rendezvous.entities.Patient;
import com.company.rendezvous.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
