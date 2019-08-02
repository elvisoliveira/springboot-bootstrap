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
    public void testRedirect() {
        ModelAndView mav = controller.redirect(request);
        assertEquals(mav.getViewName(), new ModelAndView("redirect:/equipment/all").getViewName());
    }

    @Test
    public void testGetAll() {
        ArrayList<EquipmentEntity> equips = new ArrayList<EquipmentEntity>();
        Mockito.when(service.getAll()).thenReturn(equips);
        assertEquals(equips, controller.getAll());
    }

    @Test
    public void testGetOne() {
        EquipmentEntity equip = new EquipmentEntity();
        Mockito.when(service.getById(Mockito.any())).thenReturn(equip);
        assertEquals(equip, controller.getOne(Mockito.any()));
    }
}