package td.banque.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import td.banque.model.*;
import td.banque.repository.*;
import td.banque.service.*;

import java.util.*;

@Service
public class ConsitionsGeneralesServiceImpl implements ConditionsGeneralesService {
    // Dépendance : le Service dépend du Repository
    private ConditionsGeneralesRepository conditionsGeneralesRepository;
    // Injection de dépendance par constructeur. Le répository est créé par le framework et passé en paramètre
    // dans le constructeur => injection de dépendance
    @Autowired
    public ConsitionsGeneralesServiceImpl(ConditionsGeneralesRepository conditionsGeneralesRepository) {
        this.conditionsGeneralesRepository = conditionsGeneralesRepository;
    }

    @Override
    public List<ConditionsGenerales> getAllConditionsGenerales()
    {
        return conditionsGeneralesRepository.findAll();
    }

    @Override
    public ConditionsGenerales persistConditionsGenerales(ConditionsGenerales conditionsGenerales)
    {
        return conditionsGeneralesRepository.save(conditionsGenerales);
    }

    @Override
    public ConditionsGenerales getConditionsGeneralesById(Long id)
    {
        return conditionsGeneralesRepository.findById(id).orElseThrow();
    }

    @Override
    public ConditionsGenerales updateConditionsGenerales(ConditionsGenerales conditionsGenerales)
    {
        return conditionsGeneralesRepository.save(conditionsGenerales);
    }

    @Override
    public void deleteConditionsGeneralesById(Long id)
    {
        conditionsGeneralesRepository.findById(id).orElseThrow();
        conditionsGeneralesRepository.deleteById(id);
    }
}

