package com.example.hospitalapi.resource;
import com.example.hospitalapi.appuser.AppUserRole;
import com.example.hospitalapi.models.Structure;
import com.example.hospitalapi.service.StructureService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/structure")
public class StructureController {

    private StructureService structureService;

    public StructureController(StructureService structureService){

        this.structureService = structureService;

    }
    @PostMapping("/addStructure")
    public ResponseEntity<Structure> createStructure(@RequestBody Structure structure){

        Structure newStructure = structureService.addStructure(structure);

        return new ResponseEntity<>(newStructure,HttpStatus.CREATED);
    }

    @GetMapping("/view/allStructure")
    public ResponseEntity<List<Structure>> getAllStructure(){


        List <Structure> listStructures = structureService.findAllStructure();

        return new ResponseEntity<>(listStructures,HttpStatus.OK);

    }
    @GetMapping("/view/hospital/{id}")
    public ResponseEntity<Structure> findHospitalById(@PathVariable ("id") int id){


        Structure structures = structureService.findStructureById(id);

        return new ResponseEntity<>(structures,HttpStatus.OK);

    }
    @GetMapping("/view/oneStructure")
    public ResponseEntity<List<Structure>> getStructureService(@Param("keyword") String keyword, Model model) {
        List<Structure> structure = structureService.findOneStructur(keyword);
        model.addAttribute("listProducts", structure);
        model.addAttribute("keyword", keyword);
        return new ResponseEntity<>(structure,HttpStatus.OK);
    }
}
