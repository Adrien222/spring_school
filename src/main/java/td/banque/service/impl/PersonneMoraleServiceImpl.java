package td.banque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import td.banque.model.PersonneMorale;
import td.banque.repository.PersonneMoraleRepository;
import td.banque.service.PersonneMoraleService;

import java.util.List;

@Service
public class PersonneMoraleServiceImpl implements PersonneMoraleService {

    private final PersonneMoraleRepository personneMoraleRepository;

    @Autowired
    public PersonneMoraleServiceImpl(PersonneMoraleRepository personneMoraleRepository) {
        this.personneMoraleRepository = personneMoraleRepository;
    }

    @Override
    public List<PersonneMorale> getAllPersonneMorale() {
        return personneMoraleRepository.findAll();
    }

    @Override
    public PersonneMorale persistPersonneMorale(PersonneMorale personneMorale) {
        return personneMoraleRepository.save(personneMorale);
    }

    @Override
    public PersonneMorale getPersonneMoraleById(Long id) {
        return personneMoraleRepository.findById(id).orElseThrow(() -> new RuntimeException("Personne Morale non trouvée"));
    }

    @Override
    public PersonneMorale updatePersonneMorale(PersonneMorale personneMorale) {
        return personneMoraleRepository.save(personneMorale);
    }

    @Override
    public void deletePersonneMoraleById(Long id) {
        personneMoraleRepository.findById(id).orElseThrow(() -> new RuntimeException("Personne Morale non trouvée"));
        personneMoraleRepository.deleteById(id);
    }
}
