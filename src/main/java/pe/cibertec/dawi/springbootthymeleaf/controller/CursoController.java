package pe.cibertec.dawi.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.cibertec.dawi.springbootthymeleaf.model.CursoEntity;
import pe.cibertec.dawi.springbootthymeleaf.repository.CursoRepository;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;


//    localhost:9091/curso/
    @GetMapping("/")
    public String retornaSaludo(Model model) {
        List<CursoEntity> cursoLst = cursoRepository.findAll();
        model.addAttribute("cursos", cursoLst);
        model.addAttribute("curso", new CursoEntity());
        model.addAttribute("message", "Formulario para CRUD Curso");
        return "cursos";
    }


    //    localhost:9091/curso/guardar
    @PostMapping("/guardar")
    public String guardarCurso(@ModelAttribute("curso") CursoEntity curso, Model model) {
        cursoRepository.save(curso);


        List<CursoEntity> cursoLst = cursoRepository.findAll();
        model.addAttribute("cursos", cursoLst);
        model.addAttribute("curso", new CursoEntity());
        model.addAttribute("message", "Formulario para CRUD Curso");

        return "redirect:/curso/?success=Curso+agregado+correctamente&action=save";

    }


    //    localhost:9091/curso/delete
    @PostMapping("/delete")
    public String deleteCurso(@ModelAttribute("cursoId") int cursoId, Model model) {

        cursoRepository.deleteById(cursoId);
        List<CursoEntity> cursoLst = cursoRepository.findAll();
        model.addAttribute("curso", new CursoEntity());
        model.addAttribute("cursos", cursoLst);
        model.addAttribute("message", "Formulario para CRUD Curso");

        return "redirect:/curso/?success=Curso+eliminado+correctamente&action=delete";
    }


}
