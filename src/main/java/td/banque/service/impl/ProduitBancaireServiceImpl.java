package td.banque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import td.banque.model.ProduitBancaire;
import td.banque.repository.ProduitBancaireRepository;
import td.banque.service.ProduitBancaireService;

import java.util.List;

@Service
public class ProduitBancaireServiceImpl implements ProduitBancaireService {

    private final ProduitBancaireRepository produitBancaireRepository;

    @Autowired
    public ProduitBancaireServiceImpl(ProduitBancaireRepository produitBancaireRepository) {
        this.produitBancaireRepository = produitBancaireRepository;
    }

    @Override
    public List<ProduitBancaire> getAllProduitBancaire() {
        return produitBancaireRepository.findAll();
    }

    @Override
    public ProduitBancaire persistProduitBancaire(ProduitBancaire produitBancaire) {
        return produitBancaireRepository.save(produitBancaire);
    }

    @Override
    public ProduitBancaire getProduitBancaireById(Long id) {
        return produitBancaireRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit Bancaire non trouvé"));
    }

    @Override
    public ProduitBancaire updateProduitBancaire(ProduitBancaire produitBancaire) {
        return produitBancaireRepository.save(produitBancaire);
    }

    @Override
    public void deleteProduitBancaireById(Long id) {
        produitBancaireRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit Bancaire non trouvé"));
        produitBancaireRepository.deleteById(id);
    }
}
