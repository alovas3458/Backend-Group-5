package com.covid.project.survey;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SurveyService {
    public final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository){this.surveyRepository=surveyRepository;}


    public SurveyData addSurveyData(SurveyData surveyData){
        return surveyRepository.save(surveyData);
    }

    public SurveyData findSurveyDataById(Long id){
        return surveyRepository.findDataById(id).orElseThrow();
    }

    public SurveyData updateSurveyData(SurveyData surveyData){return surveyRepository.save(surveyData);}

    public List<SurveyData> findAllSurveyData(){
        return surveyRepository.findAll();
    }


}
