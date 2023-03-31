package com.andres.crud.controlador;

import com.andres.crud.interfaceService.IPersonaServicio;
import com.andres.crud.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IPersonaServicio servicio;

    @GetMapping("/listar")
    public String listar(Model modelo){
        List<Persona>personas = servicio.listar();
        modelo.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/new")
    public String agregar(Model modelo){
        modelo.addAttribute("persona", new Persona());
        return "formulario";
    }

    @PostMapping("/save")
    public String save(@Validated Persona p, Model modelo){
        servicio.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model modelo){
        Optional<Persona> persona = servicio.listarId(id);
        modelo.addAttribute("persona", persona);
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model modelo, @PathVariable int id){
        servicio.delete(id);
        return "redirect:/listar";
    }
}
