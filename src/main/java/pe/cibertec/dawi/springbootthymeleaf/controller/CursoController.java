package pe.cibertec.dawi.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.cibertec.dawi.springbootthymeleaf.model.CursoEntity;
import pe.cibertec.dawi.springbootthymeleaf.model.DocenteEntity;
import pe.cibertec.dawi.springbootthymeleaf.repository.CursoRepository;
import pe.cibertec.dawi.springbootthymeleaf.repository.DocenteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;


    @Autowired
    private DocenteRepository docenteRepository;

    //    localhost:9091/curso/
    @GetMapping("/")
    public String listarCursos(Model model) {
        List<CursoEntity> cursoLst = cursoRepository.findAll();
        model.addAttribute("cursos", cursoLst);
        model.addAttribute("curso", new CursoEntity());
        model.addAttribute("message", "Formulario para CRUD Curso");
        return "cursos";
    }

    @GetMapping("/asignar")
    public String listarCursosAsignar(Model model) {
        List<CursoEntity> cursoLst = cursoRepository.findAll().stream().filter(docente -> docente.getDocenteEntity() == null).collect(Collectors.toList());

        List<CursoEntity> newCursoLst = new ArrayList<>();
        for(CursoEntity c: cursoLst){
            if(c.getDocenteEntity() == null)
                newCursoLst.add(c);
        }


        model.addAttribute("cursos", cursoLst);
        model.addAttribute("curso", new CursoEntity());
        model.addAttribute("editar", true);
        model.addAttribute("message", "Asignar docente a curso");
        return "cursos";
    }

    @PostMapping("/asignarDocente")
    public String asignarDocente(@ModelAttribute("cursoId") int cursoId, Model model) {
        Optional<CursoEntity> cursoEntity = cursoRepository.findById(cursoId);
        cursoEntity.ifPresent(entity -> model.addAttribute("curso", entity));
        model.addAttribute("message", "Asignar docente a curso");
        model.addAttribute("docentes", docenteRepository.findAll());
        return "asignarDocente";
    }

    @PostMapping("/confirm")
    public String asignarDocente(@ModelAttribute("curso") CursoEntity curso, Model model) {
        System.out.println(curso.toString());
        System.out.println("DocenteId: " + curso.getDocenteEntity().getId());
        Optional<DocenteEntity> docenteEntity = docenteRepository.findById(curso.getDocenteEntity().getId());
        docenteEntity.ifPresent(curso::setDocenteEntity);
        cursoRepository.save(curso);
        model.addAttribute("docentes", docenteRepository.findAll());
        model.addAttribute("docente", new DocenteEntity());
        model.addAttribute("message", "Formulario para CRUD Docente");
        return "index";
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
