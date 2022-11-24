package com.covid.project;

import com.covid.project.appuser.*;
import com.covid.project.registration.LoginRequest;
import com.covid.project.registration.RegistrationRequest;
import com.covid.project.survey.SurveyData;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class AppUserResource {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final AppUserService appUserService;
    public AppUserResource(AppUserService appUserService){ this.appUserService = appUserService;}

    @PostMapping("/register/USER")
    public ResponseEntity<AppUser> registerUser(@RequestBody RegistrationRequest request){
        System.out.println("Making user: "+request.getFirstName());
        AppUser appUser =new AppUser(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword(), AppUserRole.USER);
        AppUser newUser=appUserService.signUpUser(appUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PostMapping("/register/ADMIN")
    public ResponseEntity<AppUser> registerAdmin(@RequestBody RegistrationRequest request){
        System.out.println("Making user: "+request.getFirstName());
        AppUser appUser =new AppUser(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword(), AppUserRole.ADMIN);
        AppUser newUser=appUserService.signUpUser(appUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AppUser> loginUser(@RequestBody LoginRequest login){
        AppUser user = appUserService.loadUserByUsername(login.getEmail());
        if(encoder.matches(login.getPassword(), user.getPassword())){
            return ResponseEntity.ok(user);
        }
        return (ResponseEntity<AppUser>) ResponseEntity.internalServerError();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AppUser> getAppUserById(@PathVariable("id") Long id){
        AppUser appUser=appUserService.findUserById(id);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }
    @PostMapping("/survey")
    public ResponseEntity<AppUser> updateSurveyId(@RequestBody SurveyInput surveyInput){
        AppUser appUser=appUserService.updateUserSurvey(surveyInput);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }




}
