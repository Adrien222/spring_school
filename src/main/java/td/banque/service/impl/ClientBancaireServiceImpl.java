package td.banque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import td.banque.model.ClientBancaire;
import td.banque.repository.ClientBancaireRepository;
import td.banque.service.ClientBancaireService;

import java.util.List;

@Service
public class ClientBancaireServiceImpl implements ClientBancaireService {

    private final ClientBancaireRepository clientBancaireRepository;

    @Autowired
    public ClientBancaireServiceImpl(ClientBancaireRepository clientBancaireRepository) {
        this.clientBancaireRepository = clientBancaireRepository;
    }

    @Override
    public List<ClientBancaire> getAllClientBancaires() {
        return clientBancaireRepository.findAll();
    }

    @Override
    public ClientBancaire persistClientBancaire(ClientBancaire clientBancaire) {
        return clientBancaireRepository.save(clientBancaire);
    }

    @Override
    public ClientBancaire getClientBancaireById(Long id) {
        return clientBancaireRepository.findById(id).orElseThrow(() -> new RuntimeException("Client Bancaire non trouvé"));
    }

    @Override
    public ClientBancaire updateClientBancaire(ClientBancaire clientBancaire) {
        return clientBancaireRepository.save(clientBancaire);
    }

    @Override
    public void deleteClientBancaireById(Long id) {
        clientBancaireRepository.findById(id).orElseThrow(() -> new RuntimeException("Client Bancaire non trouvé"));
        clientBancaireRepository.deleteById(id);
    }
}
