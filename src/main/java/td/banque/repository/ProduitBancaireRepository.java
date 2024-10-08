package td.banque.repository;

import org.springframework.data.jpa.repository.*;
import td.banque.model.*;


public interface ProduitBancaireRepository <T extends ProduitBancaire> extends JpaRepository<T, Integer>
{ }