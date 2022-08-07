package com.cg.service.city;

import com.cg.model.City;
import com.cg.model.dto.CityDTO;
import com.cg.service.IGeneralService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICityService extends IGeneralService<City> {

    List<CityDTO> findAllCityDTO();
}
