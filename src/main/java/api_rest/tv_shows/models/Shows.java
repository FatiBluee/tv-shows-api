package api_rest.tv_shows.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int year;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "showsSet")
    @JsonBackReference
    private Set<Actors> actors = new HashSet<>();

    //Función para listar los nombres de los actores por show
    public List<String> getActorNames(){
        return actors.stream() //Procesar los datos de la lista
                .map(eachActor -> eachActor.getName())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Shows{" +
                "\nname='" + name + '\'' +
                ", \nyear=" + year +
                " \nactors=" +
                '}';
    }
}