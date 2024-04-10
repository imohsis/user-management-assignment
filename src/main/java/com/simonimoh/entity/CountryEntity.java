package com.simonimoh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COUNTRY_MASTER")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID")
    private Long countryId;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @OneToMany(mappedBy = "country")
    private List<StateEntity> states;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<StateEntity> getStates() {
        return states;
    }

    public void setStates(List<StateEntity> states) {
        this.states = states;
    }
}
