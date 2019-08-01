package br.com.elvisoliveira.Controllers;

import br.com.elvisoliveira.Entities.MaintenanceEntity;
import br.com.elvisoliveira.Services.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@SpringBootApplication
@RequestMapping(value = "/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService service;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView redirect(HttpServletRequest request) {
        request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.PERMANENT_REDIRECT);
        return new ModelAndView("redirect:/maintenance/browse");
    }

    @RequestMapping(path = "/browse", method = RequestMethod.GET)
    public List<MaintenanceEntity> browse() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MaintenanceEntity read(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<MaintenanceEntity> addOrEdit(@Valid @RequestBody MaintenanceEntity employee) {
        MaintenanceEntity entity = service.addOrEdit(employee);
        return new ResponseEntity<MaintenanceEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}