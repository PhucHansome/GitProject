package com.cg.service.city;

import com.cg.model.City;
import com.cg.model.dto.CityDTO;
import com.cg.repository.CityRepository;
import com.cg.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements ICityService{
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public Boolean existById(Long id) {
        return null;
    }

    @Override
    public Optional<City> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public City getById(Long id) {
        return null;
    }

    @Override
    public City save(City city) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void softDelete(City city) {

    }

    @Override
    public List<CityDTO> findAllCityDTO() {
        return cityRepository.findAllCityDTO();
    }
}
