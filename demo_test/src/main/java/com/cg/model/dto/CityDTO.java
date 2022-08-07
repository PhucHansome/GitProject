package com.cg.model.dto;


import com.cg.model.City;
import com.cg.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CityDTO {
    private Long id;

    @NotNull(message = "Tên thành phố bắt buộc nhập")
    @Size(min = 5, max = 30, message = "Tên thành phố nằm trong khoảng 5-30 ký tự")
    private String cityName;

    @NotNull(message = "Tên quốc gia bắt buộc chọn")
    private CountryDTO country;

    @NotNull(message = "Diện tích thành phố bắt buộc nhập")
    @Min(value = 9999, message = "Diện tích thành phố phải lớn hơn 10.000 km2")
    @Max(value = 49999, message = "Diện tích thành phố phải bé hơn 50.000 km2")
    private int area;

    @NotNull(message = "Tổng dân số bắt buộc nhập")
    @DecimalMin(value = "21", message = "Tổng dân số phải lớn hơn 20 triệu người")
    @DecimalMax(value = "100", message = "Tổng dân số phải bé hơn 100 triệu người")
    private BigDecimal population;

    @NotNull(message = "GDP bắt buộc nhập")
    @Min(value = 2, message = "GDP bé nhất là 2")
    @Max(value = 10, message = "GDP lớn nhất là 10")
    private float gdp;

    @NotNull(message = "Mô tả về thành phố bắt buộc nhập")
    @Size(min = 10, message = "Mô tả quá ngắn")
    private String description;

    public CityDTO(Long id, String cityName, Country country, int area, BigDecimal population, float gdp, String description) {
        this.id = id;
        this.cityName = cityName;
        this.country = country.toCountryDTO();
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public City toCity(){
        return new City()
                .setCityName(cityName)
                .setArea(area)
                .setCountry(country.toCountry())
                .setDescription(description)
                .setGdp(gdp)
                .setPopulation(population)
                .setId(id);
    }
}
