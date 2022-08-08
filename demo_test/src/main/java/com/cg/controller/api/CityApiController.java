package com.cg.controller.api;


import com.cg.exception.ResourceNotFoundException;
import com.cg.model.City;
import com.cg.model.dto.CityDTO;
import com.cg.model.dto.CountryDTO;
import com.cg.service.city.ICityService;
import com.cg.service.country.ICountryService;
import com.cg.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/city")
public class CityApiController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @Autowired
    private AppUtil appUtils;

    @GetMapping()
    public ResponseEntity<?> showAllCity() {
        List<CityDTO> cityDTOList = cityService.findAllCityDTO();

        return new ResponseEntity<>(cityDTOList, HttpStatus.OK);
    }
    @GetMapping("/country")
    public ResponseEntity<?> getCountry() {

        List<CountryDTO> countryDTOS = countryService.findAllCountryDTO();

        return new ResponseEntity<>(countryDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            throw new ResourceNotFoundException("Invalid User Id");
        }
        return new ResponseEntity<>(cityOptional.get().toCityDTO(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@Validated @RequestBody CityDTO cityDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        cityDTO.setId(0L);
        City newCity = cityService.save(cityDTO.toCity());
        return new ResponseEntity<>(newCity.toCityDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> doUpdate(@Validated @RequestBody CityDTO cityDTO, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        City updateCity = cityService.save(cityDTO.toCity());

        return new ResponseEntity<>(updateCity.toCityDTO(), HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/{Id}")
    public ResponseEntity<?> doDelete(@PathVariable Long Id) {

        Optional<City> optionalCity = cityService.findById(Id);

        if (optionalCity.isPresent()) {
            cityService.softDelete(optionalCity.get());
            return new ResponseEntity<>("Delete customer success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error for deleted customer", HttpStatus.BAD_REQUEST);

        }


    }
}
