package td.banque.service;

import td.banque.model.*;

import java.util.*;

public interface ConditionsGeneralesService {
    public List<ConditionsGenerales> getAllConditionsGenerales();

    public ConditionsGenerales persistConditionsGenerales(ConditionsGenerales conditionsGenerales);

    public ConditionsGenerales getConditionsGeneralesById(Long id);

    public ConditionsGenerales updateConditionsGenerales(ConditionsGenerales conditionsGenerales);

    public void deleteConditionsGeneralesById(Long id);
}

