package com.bycorp.crud.controller;

import com.bycorp.crud.entity.Mascota;
import com.bycorp.crud.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/mascotas")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    private String listarMascotas(Model model){
        List<Mascota> mascotas = mascotaService.obtenerTodas();
        model.addAttribute("listaMascotas", mascotas);
        return "listar";
    }

    @GetMapping("/nueva")
    private String mostarFormularioNuevaMascota(Model model){
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("accion", "/api/mascotas/nueva");
        return "formulario";
    }

    @PostMapping("/nueva")
    private String nuevaMascota(@ModelAttribute Mascota mascota){
        mascotaService.crearMascota(mascota);
        return "redirect:/api/mascotas";
    }

    @GetMapping("/editar/{id}")
    private String mostarFormularioEditarMascota(@PathVariable Long id,@ModelAttribute Mascota mascota , Model model){
        model.addAttribute("mascota", mascota);
        model.addAttribute("accion", "/api/mascotas/editar/"+id);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    private String editarMascota(@PathVariable Long id, @ModelAttribute Mascota mascota){
        mascotaService.editarMascota(mascota, id);
        return "redirect:/api/mascotas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable Long id){
        mascotaService.eliminarMascota(id);
        return "redirect:/api/mascotas";
    }
}
