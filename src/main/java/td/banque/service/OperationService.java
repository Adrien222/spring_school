package td.banque.service;

import td.banque.model.Operation;
import java.util.List;

public interface OperationService {

    List<Operation> getAllOperations();

    Operation persistOperation(Operation operation);

    Operation getOperationById(Long id);

    Operation updateOperation(Operation operation);

    void deleteOperationById(Long id);
}
