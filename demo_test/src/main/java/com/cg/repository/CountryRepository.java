package com.cg.repository;

import com.cg.model.Country;
import com.cg.model.dto.CityDTO;
import com.cg.model.dto.CountryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query("SELECT NEW com.cg.model.dto.CountryDTO (" +
            "c.id, " +
            "c.nameCountry )  " +
            "FROM Country c  WHERE c.deleted = false ")
    List<CountryDTO> findAllCountryDTO();
}
