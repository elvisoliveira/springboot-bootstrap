package br.com.elvisoliveira.Repositories;

import br.com.elvisoliveira.Entities.MaintenanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceEntity, Long> {}