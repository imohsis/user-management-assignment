package com.simonimoh.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "CITY_MASTER")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_ID")
    private Long cityId;

    @Column(name = "CITY_NAME")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "STATE_ID")
    private StateEntity state;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", state=" + state +
                '}';
    }
}
