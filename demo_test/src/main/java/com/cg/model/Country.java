package com.cg.model;

import com.cg.model.dto.CountryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
@Accessors(chain = true)
public class Country extends  BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_name")
    private String nameCountry;

    public CountryDTO toCountryDTO(){
        return new CountryDTO()
                .setNameCountry(nameCountry)
                .setId(id);
    }
}
