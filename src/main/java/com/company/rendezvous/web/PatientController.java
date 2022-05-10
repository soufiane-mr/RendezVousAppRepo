package com.company.rendezvous.web;

import com.company.rendezvous.entities.Patient;
import com.company.rendezvous.repositories.PatientRepository;
import groovyjarjarpicocli.CommandLine;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PatientController {
    final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {

        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients")
    public String listerPatient(Model model,
                                @RequestParam(name = "page", defaultValue = "0") int pageNumber,
                                @RequestParam(name = "size", defaultValue = "10") int size,
                                @RequestParam(name="keyword", defaultValue = "") String keyword){
        Page<Patient> patientPage = patientRepository.findByNomContains(keyword, PageRequest.of(pageNumber, size));
        model.addAttribute("patients", patientPage.getContent());
        model.addAttribute("pages", new int[patientPage.getTotalPages()]);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/supprimer")
    public String supprimerPatient(Long id, String keyword, int page){
        patientRepository.deleteById(id);
        return "redirect:patients?page="+page+"&keyword="+keyword;

    }

    @GetMapping("/")
    public String home(){
        return "redirect:patients";
    }

    @PostMapping("/save")
    public String ajouterPatient(Model model, Patient patient, String keyword, int page){
        patientRepository.save(patient);
        return "redirect:patients?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/formPatient")
    public String modifierPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "formPatient";
    }

    @GetMapping("/modifier")
    public String modifier(Model model, Long id, String keyword, int page){
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient==null) throw new RuntimeException("patient non trouvé");
        model.addAttribute("patient", patient);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "formPatient";
    }
}
