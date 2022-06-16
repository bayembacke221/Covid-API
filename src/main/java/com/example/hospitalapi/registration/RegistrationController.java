package com.example.hospitalapi.registration;


import com.example.hospitalapi.appuser.AppUser;
import com.example.hospitalapi.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){
         registrationService.register(registrationRequest);
        Optional<AppUser> appUser = appUserRepository.findByEmail(registrationRequest.getEmail());
        return new ResponseEntity<>(appUser, HttpStatus.CREATED);
    }
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
