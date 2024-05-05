package pe.cibertec.dawi.springbootthymeleaf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.dawi.springbootthymeleaf.model.CursoEntity;
import pe.cibertec.dawi.springbootthymeleaf.repository.CursoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestCursoController {


    @Autowired
    CursoRepository cursoRepository;

    @GetMapping(path = "/cursos")
    @ResponseBody
    public List<CursoEntity> getAllCursos() {
        return cursoRepository.findAll();
    }

    @GetMapping("/flag")
    public boolean saludo() {
        return true;
    }

    @GetMapping(path = "/saludos")
    public String saludoStr() {
        return "Hola Cibertec";
    }




}
