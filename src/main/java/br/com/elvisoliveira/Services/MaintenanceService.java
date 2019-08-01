package br.com.elvisoliveira.Services;

import br.com.elvisoliveira.Entities.MaintenanceEntity;
import br.com.elvisoliveira.Repositories.MaintenanceRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    private static final Logger logger = LogManager.getLogger(MaintenanceService.class);

    private String NO_RECORD = "We couldn't find an maintenance record for given id";
    private String NO_SCHEDULE = "There is no maintenance schedule on the database";

    @Autowired
    MaintenanceRepository repository;

    public List<MaintenanceEntity> getAll() {
        List<MaintenanceEntity> maintenanceList = repository.findAll();
        if (maintenanceList.isEmpty()) {
            logger.info(this.NO_SCHEDULE);
        }
        return maintenanceList;
    }

    public MaintenanceEntity getById(Long id) {
        Optional<MaintenanceEntity> maintenance = repository.findById(id);
        if (maintenance.isPresent()) {
            return maintenance.get();
        } else {
            logger.info(this.NO_RECORD);
        }
        return null;
    }

    public MaintenanceEntity addOrEdit(MaintenanceEntity entity) {
        if (entity.getId() == null) {
            return repository.save(entity);
        } else {
            Optional<MaintenanceEntity> maintenance = repository.findById(entity.getId());
            MaintenanceEntity editedEntity = maintenance.get();
            editedEntity.setDate(entity.getDate());
            editedEntity.setEquipment(entity.getEquipment());
            return repository.save(editedEntity);
        }
    }

    public void deleteById(Long id) {
        Optional<MaintenanceEntity> maintenance = repository.findById(id);
        if (maintenance.isPresent()) {
            repository.deleteById(id);
        } else {
            logger.info(this.NO_RECORD);
        }
    }

}