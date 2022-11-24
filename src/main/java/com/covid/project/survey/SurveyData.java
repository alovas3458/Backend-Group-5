package com.covid.project.survey;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name="Survey")
public class SurveyData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false,  updatable=false)
    private Long id;
    private String Date_Taken;
    private String Sex;
    private Long Age;
    private String Parish;
    private String Contracted;
    private String Vaccinated;
    private String Vaccine_Given;
    private Long Symptom_ID;
    private String Health_Issues;


}
