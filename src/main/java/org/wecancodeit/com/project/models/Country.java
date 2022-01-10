package org.wecancodeit.com.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Country {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String imageUrl;
    private String continent;
    @ManyToMany(mappedBy = "countries")
    private Collection<Island> islands;

    public String getContinent() {
        return continent;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Country(){

    }
    public Country(String continent, String imageUrl) {
        this.continent = continent;
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
