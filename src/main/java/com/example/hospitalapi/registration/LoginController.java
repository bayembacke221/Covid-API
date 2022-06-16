package com.example.hospitalapi.registration;

import com.example.hospitalapi.appuser.AppUser;
import com.example.hospitalapi.appuser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()));

        if (authentication!=null){
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Optional<AppUser> appUser = appUserRepository.findByEmail(loginDto.getEmail());
            return new ResponseEntity<>(appUser, HttpStatus.OK);
        }
         return new  ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
}

