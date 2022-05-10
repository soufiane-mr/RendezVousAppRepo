package com.company.rendezvous;

import com.company.rendezvous.entities.Patient;
import com.company.rendezvous.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class RendezVousApplication  {

    public static void main(String[] args) {
        SpringApplication.run(RendezVousApplication.class, args);
    }

    //@Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            Stream.of("MOHAMED", "HASSAN", "AHMED","IBRAHIM","FATIMA","MAHMOUD","AICHA","ABDERRAHMAN")
                    .forEach(name->{
                        Patient patient = new Patient(name, new Date());
                        patientRepository.save(patient);
                    });

        };
    }
}
