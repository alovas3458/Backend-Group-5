package com.covid.project.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<VaccineData, Long> {

    String HAVERSINE_FORMULA = "(3961 * acos(cos(radians(:latitude)) * cos(radians(s.latitude)) *" +
            " cos(radians(s.longitude) - radians(:longitude)) + sin(radians(:latitude)) * sin(radians(s.latitude))))";

    @Query("SELECT s FROM VaccineData s WHERE " + HAVERSINE_FORMULA + " < :distance ORDER BY "+ HAVERSINE_FORMULA + " ASC")
    List<VaccineData> findVaccineDataInDistance(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("distance") double distanceWithinMile);
}
