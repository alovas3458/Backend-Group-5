package com.covid.project.location;

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
@Table(name="vaccinedata")
public class VaccineData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable=false,  updatable=false)
    private Long id;
    private String loc_street1;
    private String loc_street2;
    private String loc_name;
    private String loc_city;
    private String loc_state;
    private String loc_zip;
    private String website;
    private float latitude;
    private float longitude;



}
