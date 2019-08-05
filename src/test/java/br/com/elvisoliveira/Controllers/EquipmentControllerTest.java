package br.com.elvisoliveira.Controllers;

import br.com.elvisoliveira.Entities.EquipmentEntity;
import br.com.elvisoliveira.Services.EquipmentService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EquipmentControllerTest {

    @Mock
    EquipmentService service;

    @Mock
    HttpServletRequest request;

    @Spy
    @InjectMocks
    EquipmentController controller;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testServerSideRedirection_shouldReturnRedirectionString() {
        ModelAndView mav = controller.redirect(request);
        assertEquals(mav.getViewName(), new ModelAndView("redirect:/equipment/all").getViewName());
    }

    @Test
    public void testIfControllerWontManipulateServiceResults_shouldReturnEmptyList() {
        Mockito.when(service.getAll()).thenReturn(new ArrayList<EquipmentEntity>());
        assertEquals(0, controller.getAll().size());
    }

    @Test
    public void testIfGetOneWillReturnProperEntity_shouldReturnProperValues() {
        Long id = Long.valueOf(0);
        String name = "Drilling Machine";
        EquipmentEntity equipEntity = new EquipmentEntity();
        equipEntity.setId(id);
        equipEntity.setName(name);
        Mockito.when(service.getById(Mockito.any())).thenReturn(equipEntity);
        EquipmentEntity equip = controller.getOne(Mockito.any());
        assertEquals(id, equip.getId());
        assertEquals(name, equip.getName());
    }
}
