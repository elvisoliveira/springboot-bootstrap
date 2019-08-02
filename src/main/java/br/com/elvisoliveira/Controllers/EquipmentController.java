package br.com.elvisoliveira.Controllers;

import br.com.elvisoliveira.Entities.EquipmentEntity;
import br.com.elvisoliveira.Services.EquipmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping(value = "/equipment")
public class EquipmentController {

    private static final Logger logger = LogManager.getLogger(EquipmentController.class);

    @Autowired
    private EquipmentService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView redirect(HttpServletRequest request) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
        return new ModelAndView("redirect:/equipment/all");
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<EquipmentEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EquipmentEntity getOne(@PathVariable("id") Long id) {
            return service.getById(id);
    }
}