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
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

    @GetMapping("/views/allRendezVous")
    public  ResponseEntity<List<RendezVous>> getAllRendezVous(){

        List<RendezVous> listRendezVous = rendezVousService.findAllRendezVous();

        return new ResponseEntity<>(listRendezVous,HttpStatus.OK);
    }
    @GetMapping("/views/user/rendervous")
    public  ResponseEntity<List<RendezVous>> getRendezVousUser(@Param("user_id") int user_id, Model model){


        List<RendezVous> listRendezVous = rendezVousService.findRendezVousUser(user_id);
        model.addAttribute("listRendezVous", listRendezVous);
        model.addAttribute("user_id", user_id);

        return new ResponseEntity<>(listRendezVous,HttpStatus.OK);
    }
}
