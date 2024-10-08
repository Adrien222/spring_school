package td.banque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import td.banque.model.PersonnePhysique;
import td.banque.repository.PersonnePhysiqueRepository;
import td.banque.service.PersonnePhysiqueService;

import java.util.List;

@Service
public class PersonnePhysiqueServiceImpl implements PersonnePhysiqueService {

    private final PersonnePhysiqueRepository personnePhysiqueRepository;

    @Autowired
    public PersonnePhysiqueServiceImpl(PersonnePhysiqueRepository personnePhysiqueRepository) {
        this.personnePhysiqueRepository = personnePhysiqueRepository;
    }

    @Override
    public List<PersonnePhysique> getAllPersonnePhysique() {
        return personnePhysiqueRepository.findAll();
    }

    @Override
    public PersonnePhysique persistPersonnePhysique(PersonnePhysique personnePhysique) {
        return personnePhysiqueRepository.save(personnePhysique);
    }

    @Override
    public PersonnePhysique getPersonnePhysiqueById(Long id) {
        return personnePhysiqueRepository.findById(id).orElseThrow(() -> new RuntimeException("Personne Physique non trouvée"));
    }

    @Override
    public PersonnePhysique updatePersonnePhysique(PersonnePhysique personnePhysique) {
        return personnePhysiqueRepository.save(personnePhysique);
    }

    @Override
    public void deletePersonnePhysiqueById(Long id) {
        personnePhysiqueRepository.findById(id).orElseThrow(() -> new RuntimeException("Personne Physique non trouvée"));
        personnePhysiqueRepository.deleteById(id);
    }
}
