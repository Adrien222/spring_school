package td.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import td.banque.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
