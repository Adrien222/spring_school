package td.banque.service;

import td.banque.model.PersonnePhysique;
import java.util.List;

public interface PersonnePhysiqueService {

    List<PersonnePhysique> getAllPersonnePhysique();

    PersonnePhysique persistPersonnePhysique(PersonnePhysique personnePhysique);

    PersonnePhysique getPersonnePhysiqueById(Long id);

    PersonnePhysique updatePersonnePhysique(PersonnePhysique personnePhysique);

    void deletePersonnePhysiqueById(Long id);
}
