package org.wecancodeit.com.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Ocean {
    @Id
    @GeneratedValue

    private Long id;
    private String name;
    private String imageUrl;
    @OneToMany(mappedBy = "oceans")
    private Collection<Ocean> oceans;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Ocean> getOceans() {
        return oceans;
    }

    public Ocean(){

    }

    public Ocean(String name, String imageUrl){
        this.name = name;
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ocean ocean = (Ocean)  o;
        return Objects.equals(id, ocean.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}