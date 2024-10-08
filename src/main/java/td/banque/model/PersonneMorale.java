package td.banque.model;

import jakarta.persistence.*;

@Entity(name = "PersonneMorale")
@Table(
        name = "personne_morale"
)
public class PersonneMorale extends Personne {

    @Column(
            name = "siret",
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
    )
    private String siret;

    @Column(
            name = "nom",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nom;

    @ManyToOne
    @JoinColumn(name = "type_personne_morale_id", nullable = false)
    private TypePersonneMorale typePersonneMorale;

    public PersonneMorale() {
        super();
    }

    public PersonneMorale(String adresse, String siret, String nom, TypePersonneMorale typePersonneMorale) {
        super(adresse);
        this.siret = siret;
        this.nom = nom;
        this.typePersonneMorale = typePersonneMorale;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypePersonneMorale getTypePersonneMorale() {
        return typePersonneMorale;
    }

    public void setTypePersonneMorale(TypePersonneMorale typePersonneMorale) {
        this.typePersonneMorale = typePersonneMorale;
    }

    @PreRemove
    private void gererLiensPM()
    {
        if (typePersonneMorale!=null)typePersonneMorale.getPersonnesMorales().remove(this);
        typePersonneMorale=null;
    }

    @Override
    public String toString() {
        return "PersonneMorale{" +
                "id=" + id +
                ", siret='" + siret + '\'' +
                ", adresse='" + adresse + '\'' +
                ", nom='" + nom + '\'' +
                ", typePersonneMorale=" + typePersonneMorale.getLibelle() +
                '}';
    }
}
