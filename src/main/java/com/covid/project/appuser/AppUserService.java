package com.covid.project.appuser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final static String USER_NOT_FOUND = "user with email %s not found";
    private final AppUserRepository appUserRepository;

    @Override
    public AppUser loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND, email)));
    }

    public AppUser signUpUser(AppUser appUser){
        boolean userExists=appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        if(userExists){
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword=bCryptPasswordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        return appUserRepository.save(appUser);
    }


    public AppUser findUserById(Long id){
        return appUserRepository.findUserById(id).orElseThrow(() -> new UsernameNotFoundException("user by id "+id+" was not found"));
    }


    public AppUser updateUserSurvey(SurveyInput surveyInput){
        AppUser appUser=findUserById(surveyInput.userid);
        appUser.setSurveyId(surveyInput.surveyid);
        return appUserRepository.save(appUser);



    }

    public List<AppUser> getAllUserData(){
        return appUserRepository.findAll();
    }

    public void deleteUser(Long id){
        appUserRepository.deleteById(id);
    }

}
