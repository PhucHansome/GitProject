package com.cg.model;

import com.cg.model.dto.CityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "cities")
@Accessors(chain = true)

public class City  extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "area")
    private int area;

    @Column(name = "population")
    private BigDecimal population;

    @Column(name = "gdp")
    private float gdp;

    @Column(name = "description")
    private String description;

    public CityDTO toCityDTO(){
        return new CityDTO()
                .setCityName(cityName)
                .setArea(area)
                .setCountry(country.toCountryDTO())
                .setDescription(description)
                .setGdp(gdp)
                .setId(id)
                .setPopulation(population)
                ;
    }


}
