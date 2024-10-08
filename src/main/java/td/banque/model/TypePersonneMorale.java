package td.banque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity(name = "TypePersonneMorale")
@Table(
        name = "type_personne_morale"
)
public class TypePersonneMorale {

    @Id
    @SequenceGenerator(
            name = "type_personne_morale_sequence",
            sequenceName = "type_personne_morale_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "type_personne_morale_sequence"
    )
    private Long id;

    @Column(
            name = "libelle",
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
    )
    private String libelle;

    @OneToMany(mappedBy = "typePersonneMorale")
    private List<PersonneMorale> personnesMorales;

    public TypePersonneMorale() {
    }

    public TypePersonneMorale(String libelle) {
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<PersonneMorale> getPersonnesMorales() {
        return personnesMorales;
    }

    public void setPersonnesMorales(List<PersonneMorale> personnesMorales) {
        this.personnesMorales = personnesMorales;
    }

    @Override
    public String toString() {
        return "TypePersonneMorale{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
