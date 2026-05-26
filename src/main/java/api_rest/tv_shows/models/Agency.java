package api_rest.tv_shows.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Agency {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    int id;

    String name;
    String city;

    @OneToMany(mappedBy = "agency", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Actors> actorsList = new ArrayList<>();

    public Agency() {
    }

    public Agency(int id, String name, String city, List<Actors> actorsList) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.actorsList = actorsList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Actors> getActorsList() {
        return actorsList;
    }

    public void setActorsList(List<Actors> actorsList) {
        this.actorsList = actorsList;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", actorsList=" + actorsList +
                '}';
    }
}
