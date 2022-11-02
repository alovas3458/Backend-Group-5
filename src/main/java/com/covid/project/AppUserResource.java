package com.covid.project;

import com.covid.project.appuser.AppUserRepository;
import com.covid.project.appuser.AppUserRole;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.covid.project.appuser.AppUser;
import com.covid.project.appuser.AppUserService;


import java.util.List;

@RestController
@RequestMapping("/user")
public class AppUserResource {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final AppUserService appUserService;
    public AppUserResource(AppUserService appUserService){ this.appUserService = appUserService;}

    @PostMapping("/register/USER")
    public ResponseEntity<AppUser> registerUser(@RequestBody String firstName, String lastName, String email, String password){
        AppUser appUser =new AppUser(firstName, lastName, email, password, AppUserRole.USER);
        AppUser newUser=appUserService.signUpUser(appUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PostMapping("/register/ADMIN")
    public ResponseEntity<AppUser> registerAdmin(@RequestBody String firstName, String lastName, String email, String password){
        AppUser appUser =new AppUser(firstName, lastName, email, password, AppUserRole.ADMIN);
        AppUser newUser=appUserService.signUpUser(appUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<AppUser> loginUser(@RequestBody String email, String password){
        AppUser user = appUserService.loadUserByUsername(email);
        if(encoder.matches(password, user.getPassword())){
            return ResponseEntity.ok(user);
        }
        return (ResponseEntity<AppUser>) ResponseEntity.internalServerError();
    }




}
