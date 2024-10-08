package td.banque.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public class ProduitBancaire {

    @Id
    @SequenceGenerator(
            name = "produit_bancaire_sequence",
            sequenceName = "produit_bancaire_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "produit_bancaire_sequence"
    )
    @Column(
            name = "id"
    )
    protected Long id;

    @Column(
            name = "solde_courant",
            nullable = false,
            columnDefinition = "FLOAT"
    )
    private float solde_courant;

    @Column(
            name = "numero_compte",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String numeroCompte;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conditions_generales_id")
    private ConditionsGenerales conditionsGenerales;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_bancaire_id")
    private ClientBancaire clientBancaire;

    // Relation One-to-Many avec Operation
    @OneToMany(mappedBy = "produitBancaire", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Operation> operations = new HashSet<>();

    public ProduitBancaire(float solde_courant, String numeroCompte, ConditionsGenerales conditionsGenerales) {
        this.solde_courant = solde_courant;
        this.numeroCompte = numeroCompte;
        this.conditionsGenerales = conditionsGenerales;
        conditionsGenerales.getProduitsBancaires().add(this);
    }

    public ProduitBancaire() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getSolde_courant() {
        return solde_courant;
    }

    public void setSolde_courant(float solde_courant) {
        this.solde_courant = solde_courant;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public ConditionsGenerales getConditionsGenerales() {
        return conditionsGenerales;
    }

    public void setConditionsGenerales(ConditionsGenerales conditionsGenerales) {
        this.conditionsGenerales = conditionsGenerales;
    }

    public ClientBancaire getClientBancaire() {
        return clientBancaire;
    }

    public void setClientBancaire(ClientBancaire clientBancaire) {
        this.clientBancaire = clientBancaire;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
        operation.setProduitBancaire(this);
    }

    public void removeOperation(Operation operation) {
        operations.remove(operation);
        operation.setProduitBancaire(null);
    }

    @PreRemove
    private void gererLiens() {
        if (conditionsGenerales != null) {
            conditionsGenerales.getProduitsBancaires().remove(this);
        }
        conditionsGenerales = null;

        if (clientBancaire != null) {
            clientBancaire.getProduitsBancaires().remove(this);
        }
        clientBancaire = null;

        for (Operation operation : this.operations) {
            operation.setProduitBancaire(null);
        }
        this.operations.clear();
    }

    @Override
    public String toString() {
        return "\nProduitBancaire{" +
                "\n\tid=" + id +
                ", \n\tsolde_courant=" + solde_courant +
                ", \n\tnumeroCompte =" + numeroCompte +
                ", \n\tconditionsGenerales=" + conditionsGenerales +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduitBancaire that = (ProduitBancaire) o;
        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
