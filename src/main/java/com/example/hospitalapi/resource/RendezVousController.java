package com.example.hospitalapi.resource;

import com.example.hospitalapi.Pojo.RendezVousPojo;
import com.example.hospitalapi.appuser.AppUser;
import com.example.hospitalapi.appuser.AppUserRepository;
import com.example.hospitalapi.exception.ResourceNotFoundException;
import com.example.hospitalapi.models.RendezVous;
import com.example.hospitalapi.models.Structure;
import com.example.hospitalapi.repository.RendezVousRepository;
import com.example.hospitalapi.repository.StructureRepository;
import com.example.hospitalapi.service.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rendezvous")
public class RendezVousController {




    private RendezVousService rendezVousService;

    public RendezVousController(RendezVousService rendezVousService){

        this.rendezVousService = rendezVousService;

    }
    @PostMapping("/addRendezVous")
    public ResponseEntity<RendezVous> createRendezVous( @RequestBody RendezVousPojo rendezVousPojo){

        RendezVous newRendezVous= rendezVousService.addRendezVous(rendezVousPojo);

        return new ResponseEntity<>(newRendezVous, HttpStatus.CREATED);
    }
}
