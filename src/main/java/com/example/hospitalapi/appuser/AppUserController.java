package com.example.hospitalapi.appuser;

import com.example.hospitalapi.models.Structure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appUser")
public class AppUserController {

    private AppUserService appUserService;
    public AppUserController (AppUserService appUserService){

        this.appUserService=appUserService;
    }

    @GetMapping("/find/user/{id}")
    public ResponseEntity<AppUser> findUserByID(@PathVariable("id") int id){


        AppUser appUser = appUserService.findUserByID(id);

        return new ResponseEntity<>(appUser, HttpStatus.OK);

    }
}
