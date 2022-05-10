package com.company.rendezvous.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Patient {
    @Id
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateNaissance;
    private boolean malde;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

    public Patient(String nom, Date dateNaissance){
        this.id= new Random().nextLong();
        this.nom=nom;
        this.dateNaissance = dateNaissance;
        this.malde=false;
    }
}
