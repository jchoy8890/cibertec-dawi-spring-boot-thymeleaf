package pe.cibertec.dawi.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.cibertec.dawi.springbootthymeleaf.model.DocenteEntity;
import pe.cibertec.dawi.springbootthymeleaf.repository.DocenteRepository;

import java.util.List;

@Controller
public class DocenteController {

    @Autowired
    private DocenteRepository docenteRepository;

    @GetMapping("/hola")
    public String retornaSaludo(Model model) {

        List<DocenteEntity> docenteLst = docenteRepository.findAll();

        for (DocenteEntity docente : docenteLst) {
            System.out.println(docente.getName() + " " + docente.getLastName());
        }

        model.addAttribute("docentes", docenteLst);
        model.addAttribute("message", "Desde Lima Perú. Saludos a todo el mundo");
        return "home";
    }


}
