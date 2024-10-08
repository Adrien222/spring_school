package td.banque.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public class ClientBancaire {

    @Id
    @SequenceGenerator(name = "client_bancaire_sequence", sequenceName = "client_bancaire_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "client_bancaire_sequence")
    @Column(name = "id")
    protected Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "client_personne",
            joinColumns = { @JoinColumn(name = "client_bancaire_id") },
            inverseJoinColumns = { @JoinColumn(name = "personne_id") }
    )
    private Set<Personne> personnes = new HashSet<>();

    // Ajout de la relation One-to-Many avec ProduitBancaire
    @OneToMany(mappedBy = "clientBancaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProduitBancaire> produitsBancaires = new HashSet<>();

    public ClientBancaire() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Set<Personne> personnes) {
        this.personnes = personnes;
    }

    public Set<ProduitBancaire> getProduitsBancaires() {
        return produitsBancaires;
    }

    public void setProduitsBancaires(Set<ProduitBancaire> produitsBancaires) {
        this.produitsBancaires = produitsBancaires;
    }

    public void addPersonne(Personne personne) {
        personnes.add(personne);
        personne.addClientBancaire(this);
    }

    public void removePersonne(Personne personne) {
        personnes.remove(personne);
        personne.getClientsBancaires().remove(this);
    }

    // Méthode pour ajouter un produit bancaire à un client
    public void addProduitBancaire(ProduitBancaire produitBancaire) {
        produitsBancaires.add(produitBancaire);
        produitBancaire.setClientBancaire(this);
    }

    // Méthode pour retirer un produit bancaire d'un client
    public void removeProduitBancaire(ProduitBancaire produitBancaire) {
        produitsBancaires.remove(produitBancaire);
        produitBancaire.setClientBancaire(null);
    }

    @PreRemove
    private void gererLiens() {
        for (Personne personne : this.personnes) {
            personne.getClientsBancaires().remove(this);
        }
        this.personnes.clear();

        for (ProduitBancaire produitBancaire : this.produitsBancaires) {
            produitBancaire.setClientBancaire(null);
        }
        this.produitsBancaires.clear();
    }

    @Override
    public String toString() {
        return "\nClientBancaire{" +
                "\n\tid=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientBancaire that = (ClientBancaire) o;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
