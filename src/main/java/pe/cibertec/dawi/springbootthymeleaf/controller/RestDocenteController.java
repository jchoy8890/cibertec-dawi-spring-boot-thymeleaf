package pe.cibertec.dawi.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.dawi.springbootthymeleaf.model.DocenteEntity;
import pe.cibertec.dawi.springbootthymeleaf.repository.DocenteRepository;

import java.util.List;

@RestController
public class RestDocenteController {

    @Autowired
    private DocenteRepository docenteRepository;

    @GetMapping("/saludo")
    public String saludoCibertec() {
        return "Hola Cibertec";
    }


    @GetMapping("/home/docentes")
    public List<DocenteEntity> getDocentes() {
        return docenteRepository.findAll();
    }


}
