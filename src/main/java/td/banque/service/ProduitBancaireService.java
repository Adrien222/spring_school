package td.banque.service;

import td.banque.model.ProduitBancaire;
import java.util.List;

public interface ProduitBancaireService {

    List<ProduitBancaire> getAllProduitBancaire();

    ProduitBancaire persistProduitBancaire(ProduitBancaire produitBancaire);

    ProduitBancaire getProduitBancaireById(Long id);

    ProduitBancaire updateProduitBancaire(ProduitBancaire produitBancaire);

    void deleteProduitBancaireById(Long id);
}
