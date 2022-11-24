package com.covid.project.location;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VaccineService {

    private final VaccineRepository vaccineRepository;


    public VaccineService(VaccineRepository vaccineRepository){this.vaccineRepository=vaccineRepository;   }


    public List<VaccineData> getClosestLocation(VaccineLocation vaccineLocation){
        List<VaccineData> list=vaccineRepository.findVaccineDataInDistance(vaccineLocation.getLatitude(), vaccineLocation.getLongitude(), 5);
        List<VaccineData> list2=list.stream().limit(5).collect(Collectors.toList());
        return list2;
    }



}
