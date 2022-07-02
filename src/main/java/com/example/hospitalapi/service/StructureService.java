package com.example.hospitalapi.service;
import com.example.hospitalapi.exception.ModelNotFoundException;
import com.example.hospitalapi.models.RendezVous;
import com.example.hospitalapi.models.Structure;
import com.example.hospitalapi.repository.StructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StructureService {
    private final StructureRepository structureRepository;

    @Autowired
    public StructureService(StructureRepository structureRepository){

        this.structureRepository= structureRepository;
    }


    public Structure addStructure(Structure structure){

        return  structureRepository.save(structure);

    }
    public Structure findStructureById(int structure){

        return  structureRepository.findById(structure);

    }

    public List<Structure> findAllStructure(){

        return  structureRepository.findAll();

    }

    public  List<Structure> findOneStructur(String keyword){

        return structureRepository.search(keyword);

    }


}
