package br.com.elvisoliveira.Services;

import br.com.elvisoliveira.Entities.EquipmentEntity;
import br.com.elvisoliveira.Repositories.EquipmentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EquipmentServiceTest {

    @Mock
    EquipmentRepository repository;

    @Spy
    @InjectMocks
    EquipmentService service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllWithEmptyParam_shouldReturnEmptyList() {
        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());
        assertEquals(service.getAll().size(), 0);
    }

    @Test
    public void testGetByIdWithCorrectIdNumber_shouldReturnEquipmentEntity() {
        Optional<EquipmentEntity> employee = Optional.of(new EquipmentEntity());
        Mockito.when(repository.findById(Mockito.any())).thenReturn(employee);
    }
}