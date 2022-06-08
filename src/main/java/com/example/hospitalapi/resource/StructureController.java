package com.example.hospitalapi.resource;
import com.example.hospitalapi.appuser.AppUserRole;
import com.example.hospitalapi.models.Structure;
import com.example.hospitalapi.service.StructureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
}
