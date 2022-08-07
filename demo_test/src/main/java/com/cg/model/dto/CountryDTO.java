package com.cg.model.dto;

import com.cg.model.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CountryDTO {

    private Long id;

    private String nameCountry;

    public Country toCountry(){
        return new Country()
                .setNameCountry(nameCountry)
                .setId(id);
    }

}
