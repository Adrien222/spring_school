package td.banque.service;

import td.banque.model.PersonneMorale;
import java.util.List;

public interface PersonneMoraleService {

    List<PersonneMorale> getAllPersonneMorale();

    PersonneMorale persistPersonneMorale(PersonneMorale personneMorale);

    PersonneMorale getPersonneMoraleById(Long id);

    PersonneMorale updatePersonneMorale(PersonneMorale personneMorale);

    void deletePersonneMoraleById(Long id);
}
