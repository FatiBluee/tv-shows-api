package api_rest.tv_shows.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 20)
    @Column(name = "first_name")
    private String name;

    @NotNull
    @NotEmpty
    private String residenceCountry;

    @OneToOne
    private Biography biography;

    @ManyToOne
    private Agency agency;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Shows> showsSet = new HashSet<>(); //PAra evitar duplicados

    @Override
    public String toString() {
        return "Actors{" +
                " \nid=" + id +
                ", \nrole=" + role +
                ", \nname='" + name + '\'' +
                ", \nresidenceCountry='" + residenceCountry + '\'' +
                ", \nbiography=" + biography +
                ", \nagency=" + (agency != null ? agency.getName() : "null") +
                ", \nshows=" + showsSet +
                '}';
    }
}
