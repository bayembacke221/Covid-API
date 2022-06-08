package com.example.hospitalapi.service;
import com.example.hospitalapi.Pojo.RendezVousPojo;
import com.example.hospitalapi.appuser.AppUser;
import com.example.hospitalapi.appuser.AppUserRepository;
import com.example.hospitalapi.exception.ModelNotFoundException;
import com.example.hospitalapi.exception.ResourceNotFoundException;
import com.example.hospitalapi.models.RendezVous;
import com.example.hospitalapi.models.Structure;
import com.example.hospitalapi.repository.RendezVousRepository;
import com.example.hospitalapi.repository.StructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RendezVousService {

    @Autowired
    AppUserRepository appUserRepository;


    @Autowired
    StructureRepository structureRepository;
    private final RendezVousRepository rendezVousRepository;

    @Autowired
    public RendezVousService(RendezVousRepository rendezVousRepository){

        this.rendezVousRepository=rendezVousRepository;

    }
    public RendezVous addRendezVous(RendezVousPojo rendezVousPojo){

        AppUser appUser = appUserRepository.findById(rendezVousPojo.user_id);

        Structure structure = structureRepository.findById(rendezVousPojo.structure_id);

        RendezVous rendezVous = new RendezVous();
        rendezVous.setDateRv(rendezVousPojo.dateRv);
        rendezVous.setObjetRv(rendezVousPojo.objetRv);
        rendezVous.setResultAnalyse(rendezVousPojo.resultAnalyse);
        rendezVous.setStatusRv(rendezVousPojo.statusRv);
        rendezVous.setStructure(structure);
        rendezVous.setAppUser(appUser);
        return rendezVousRepository.save(rendezVous);

    }
    public  List<RendezVous> findAllRendezVous(){

        return rendezVousRepository.findAll();

    }

    public RendezVous updateRendezVous(RendezVous rendezVous){

        return rendezVousRepository.save(rendezVous);

    }

    public void deleteRendezVous(int IdRendezVous){

        rendezVousRepository.deleteById(IdRendezVous);
    }


}
