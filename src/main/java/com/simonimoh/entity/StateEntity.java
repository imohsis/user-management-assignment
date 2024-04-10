package com.simonimoh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "STATE_MASTER")
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATE_ID")
    private Long stateId;

    @Column(name = "STATE_NAME")
    private String stateName;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private CountryEntity country;

    @OneToMany(mappedBy = "state")
    private List<CityEntity> cities;

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "StateEntity{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                ", country=" + country +
                ", cities=" + cities +
                '}';
    }
}

