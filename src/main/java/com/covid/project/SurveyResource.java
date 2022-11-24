package com.covid.project;


import com.covid.project.survey.SurveyData;
import com.covid.project.survey.SurveyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyResource {

    private final SurveyService surveyService;

    public SurveyResource(SurveyService surveyService){this.surveyService=surveyService;}

    @PostMapping("/add")
    public ResponseEntity<SurveyData> addSurveyData(@RequestBody SurveyData surveyData){
        SurveyData newSurveyData=surveyService.addSurveyData(surveyData);
        return new ResponseEntity<>(newSurveyData, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SurveyData> updateSurveyData(@RequestBody SurveyData surveyData){
        SurveyData updateSurveyData=surveyService.updateSurveyData(surveyData);
        return new ResponseEntity<>(updateSurveyData, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SurveyData> findSurveyDataById(@PathVariable("id") Long id){
        SurveyData surveyData=surveyService.findSurveyDataById(id);
        return new ResponseEntity<>(surveyData, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<SurveyData>> getAllSurveyData(){
        List<SurveyData> surveyDataList=surveyService.findAllSurveyData();
        return new ResponseEntity<>(surveyDataList, HttpStatus.OK);
    }




}
