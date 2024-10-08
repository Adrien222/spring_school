package td.banque.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import td.banque.model.Operation;
import td.banque.repository.OperationRepository;
import td.banque.service.OperationService;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;

    @Autowired
    public OperationServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    @Override
    public Operation persistOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public Operation getOperationById(Long id) {
        return operationRepository.findById(id).orElseThrow(() -> new RuntimeException("Opération non trouvée"));
    }

    @Override
    public Operation updateOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public void deleteOperationById(Long id) {
        operationRepository.findById(id).orElseThrow(() -> new RuntimeException("Opération non trouvée"));
        operationRepository.deleteById(id);
    }
}
