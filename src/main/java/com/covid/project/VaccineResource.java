package com.covid.project;

import com.covid.project.appuser.AppUserRepository;
import com.covid.project.appuser.AppUserRole;
import com.covid.project.location.VaccineData;
import com.covid.project.location.VaccineLocation;
import com.covid.project.location.VaccineService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/vaccine")
public class VaccineResource {

    private final VaccineService vaccineService;

    public VaccineResource(VaccineService vaccineService){this.vaccineService=vaccineService;}


    @PostMapping("/location")
    public ResponseEntity<List<VaccineData>> getNearbyLocations(@RequestBody VaccineLocation location){
        List<VaccineData> vaccineDataList=vaccineService.getClosestLocation(location);
        return new ResponseEntity<>(vaccineDataList, HttpStatus.OK);
    }




}
