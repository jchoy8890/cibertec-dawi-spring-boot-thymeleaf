package pe.cibertec.dawi.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.springbootthymeleaf.model.DocenteEntity;
import pe.cibertec.dawi.springbootthymeleaf.repository.DocenteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class RestDocenteController {

    @Autowired
    private DocenteRepository docenteRepository;

    @GetMapping("/saludo")
    public String saludoCibertec() {
        return "Hola Cibertec";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/docentes")
    public List<DocenteEntity> getDocentes() {
        return docenteRepository.findAll();
    }


}
