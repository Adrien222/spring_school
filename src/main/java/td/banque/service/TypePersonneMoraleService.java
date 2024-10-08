package td.banque.service;

import td.banque.model.TypePersonneMorale;
import java.util.List;

public interface TypePersonneMoraleService {

    List<TypePersonneMorale> getAllTypePersonneMorale();

    TypePersonneMorale persistTypePersonneMorale(TypePersonneMorale typePersonneMorale);

    TypePersonneMorale getTypePersonneMoraleById(Long id);

    TypePersonneMorale updateTypePersonneMorale(TypePersonneMorale typePersonneMorale);

    void deleteTypePersonneMoraleById(Long id);
}
