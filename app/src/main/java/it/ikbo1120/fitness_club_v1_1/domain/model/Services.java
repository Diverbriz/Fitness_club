package it.ikbo1120.fitness_club_v1_1.domain.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Services {
    @PrimaryKey
    private Long id_services;
    private String name_services;
    private String description_services;
    private Float price_services;
    private String url;

    public Services(Long id_services, String name_services, String description_services, Float price_services, String url) {
        this.id_services = id_services;
        this.name_services = name_services;
        this.description_services = description_services;
        this.price_services = price_services;
        this.url = url;
    }

    public Services() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId_services() {
        return id_services;
    }

    public void setId_services(Long id_services) {
        this.id_services = id_services;
    }

    public String getName_services() {
        return name_services;
    }

    public void setName_services(String name_services) {
        this.name_services = name_services;
    }

    public String getDescription_services() {
        return description_services;
    }

    public void setDescription_services(String description_services) {
        this.description_services = description_services;
    }

    public int getIntPrice(){
        return price_services.intValue();
    }

    public Float getPrice_services() {
        return price_services;
    }

    public void setPrice_services(Float price_services) {
        this.price_services = price_services;
    }
}