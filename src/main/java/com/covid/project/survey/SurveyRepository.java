package com.covid.project.survey;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface SurveyRepository extends JpaRepository<SurveyData, Long> {

    Optional<SurveyData> findDataById(Long id);


}
