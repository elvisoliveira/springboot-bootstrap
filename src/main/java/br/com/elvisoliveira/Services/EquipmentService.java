package br.com.elvisoliveira.Services;

import br.com.elvisoliveira.Entities.EquipmentEntity;
import br.com.elvisoliveira.Repositories.EquipmentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    private static final Logger logger = LogManager.getLogger(MaintenanceService.class);

    private String NO_RECORD = "We couldn't find an equipment with the given id";
    private String NO_DATA = "There is no equipments on the database";

    @Autowired
    EquipmentRepository repository;

    public List<EquipmentEntity> getAll() {
        List<EquipmentEntity> equipmentList = repository.findAll();
        if (equipmentList.isEmpty()) {
            logger.info(this.NO_DATA);
        }
        return equipmentList;
    }

    public EquipmentEntity getById(Long id) {
        Optional<EquipmentEntity> employee = repository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            logger.info(this.NO_RECORD);
        }
        return null;
    }

}