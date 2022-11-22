package com.covid.project.location;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VaccineService {

    private final VaccineRepository vaccineRepository;


    public VaccineService(VaccineRepository vaccineRepository){this.vaccineRepository=vaccineRepository;   }


    public List<VaccineData> getClosestLocation(VaccineLocation vaccineLocation){
        return vaccineRepository.findVaccineDataInDistance(vaccineLocation.getLatitude(), vaccineLocation.getLongitude(), 5);
    }



}
