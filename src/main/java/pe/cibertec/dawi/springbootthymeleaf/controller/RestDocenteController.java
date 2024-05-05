package pe.cibertec.dawi.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.dawi.springbootthymeleaf.model.DocenteEntity;
import pe.cibertec.dawi.springbootthymeleaf.repository.DocenteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@CrossOrigin(origins = "http://localhost:4200")
public class RestDocenteController {

    @Autowired
    private DocenteRepository docenteRepository;

    @GetMapping("/saludo")
    public String saludoCibertec() {
        return "Hola Cibertec";
    }


    @GetMapping("/docentes")
    public List<DocenteEntity> getDocentes() {
        return docenteRepository.findAll();
    }

    @GetMapping("/docente/{docenteId}")
    public DocenteEntity getDocente(@PathVariable("docenteId") int docenteId) {
        System.out.println("Obteniendo docente: " + docenteId);
        return docenteRepository.findById(docenteId).orElse(null);
    }


    @PostMapping("/docente")
    public List<DocenteEntity> saveDocente(@RequestBody DocenteEntity docente) {
        System.out.println("Grabando docente");
        docenteRepository.save(docente);
        return docenteRepository.findAll();
    }

    @DeleteMapping("/docente/{docenteId}")
    public List<DocenteEntity> deleteDocente(@PathVariable("docenteId") int docenteId) {
        System.out.println("Eliminando docente");
        docenteRepository.deleteById(docenteId);
        return docenteRepository.findAll();
    }

}
