package com.cg.repository;

import com.cg.model.City;
import com.cg.model.dto.CityDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {


    @Query("SELECT NEW com.cg.model.dto.CityDTO (c.id," +
            "c.cityName, " +
            "c.country, " +
            "c.area, " +
            "c.population, " +
            "c.gdp, " +
            "c.description )  " +
            "FROM City c  WHERE c.deleted = false ")
    List<CityDTO> findAllCityDTO();


}
