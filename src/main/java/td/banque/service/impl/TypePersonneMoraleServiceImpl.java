package td.banque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import td.banque.model.TypePersonneMorale;
import td.banque.repository.TypePersonneMoraleRepository;
import td.banque.service.TypePersonneMoraleService;

import java.util.List;

@Service
public class TypePersonneMoraleServiceImpl implements TypePersonneMoraleService {

    private final TypePersonneMoraleRepository typePersonneMoraleRepository;

    @Autowired
    public TypePersonneMoraleServiceImpl(TypePersonneMoraleRepository typePersonneMoraleRepository) {
        this.typePersonneMoraleRepository = typePersonneMoraleRepository;
    }

    @Override
    public List<TypePersonneMorale> getAllTypePersonneMorale() {
        return typePersonneMoraleRepository.findAll();
    }

    @Override
    public TypePersonneMorale persistTypePersonneMorale(TypePersonneMorale typePersonneMorale) {
        return typePersonneMoraleRepository.save(typePersonneMorale);
    }

    @Override
    public TypePersonneMorale getTypePersonneMoraleById(Long id) {
        return typePersonneMoraleRepository.findById(id).orElseThrow(() -> new RuntimeException("Type de Personne Morale non trouvé"));
    }

    @Override
    public TypePersonneMorale updateTypePersonneMorale(TypePersonneMorale typePersonneMorale) {
        return typePersonneMoraleRepository.save(typePersonneMorale);
    }

    @Override
    public void deleteTypePersonneMoraleById(Long id) {
        typePersonneMoraleRepository.findById(id).orElseThrow(() -> new RuntimeException("Type de Personne Morale non trouvé"));
        typePersonneMoraleRepository.deleteById(id);
    }
}
