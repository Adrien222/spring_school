package td.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import td.banque.model.ConditionsGenerales;

import java.util.ArrayList;

public interface ConditionsGeneralesRepository extends JpaRepository<ConditionsGenerales, Long> {
    @Query("SELECT c FROM ConditionsGenerales  c where c.typeProduit = :typeProduit")
    ArrayList<ConditionsGenerales> findByTypeProduit(@Param("typeProduit")String typeProduit);
    ArrayList<ConditionsGenerales> findByTypeProduitLike(String typeProduit);
    ArrayList<ConditionsGenerales> findByTypeProduitContains(String typeProduit);
    ArrayList<ConditionsGenerales> findFirst3ByOrderByIdDesc();
    ArrayList<ConditionsGenerales> findByTauxInteretAgiosGreaterThanEqualOrderByTauxInteretAgiosAsc(float taux);
}

