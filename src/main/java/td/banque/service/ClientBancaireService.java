package td.banque.service;

import td.banque.model.ClientBancaire;
import java.util.List;

public interface ClientBancaireService {

    List<ClientBancaire> getAllClientBancaires();

    ClientBancaire persistClientBancaire(ClientBancaire clientBancaire);

    ClientBancaire getClientBancaireById(Long id);

    ClientBancaire updateClientBancaire(ClientBancaire clientBancaire);

    void deleteClientBancaireById(Long id);
}
