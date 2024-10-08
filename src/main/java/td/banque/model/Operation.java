package td.banque.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public class Operation {

    @Id
    @SequenceGenerator(
            name = "operation_sequence",
            sequenceName = "operation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "operation_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "date_operation",
            nullable = false
    )
    @Temporal(TemporalType.DATE)
    private Date dateOperation;

    @Column(
            name = "montant",
            nullable = false,
            columnDefinition = "FLOAT"
    )
    private float montant;

    @Column(
            name = "type",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String type;

    @Column(
            name = "libelle",
            columnDefinition = "TEXT"
    )
    private String libelle;

    // Relation Many-to-One avec ProduitBancaire
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_bancaire_id", nullable = false)
    private ProduitBancaire produitBancaire;

    public Operation() {}

    public Operation(Date dateOperation, float montant, String type, String libelle, ProduitBancaire produitBancaire) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.type = type;
        this.libelle = libelle;
        this.produitBancaire = produitBancaire;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ProduitBancaire getProduitBancaire() {
        return produitBancaire;
    }

    public void setProduitBancaire(ProduitBancaire produitBancaire) {
        this.produitBancaire = produitBancaire;
    }

    @Override
    public String toString() {
        return "\nOperation{" +
                "id=" + id +
                ", dateOperation=" + dateOperation +
                ", montant=" + montant +
                ", type='" + type + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return id.equals(operation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
