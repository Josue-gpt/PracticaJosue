package Practica_JosueAlfaroZumbado.controller;

import Practica_JosueAlfaroZumbado.domain.Arbol;
import Practica_JosueAlfaroZumbado.service.ArbolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/arbol")
public class ArbolController {

    private final ArbolService arbolService;

    public ArbolController(ArbolService arbolService) {
        this.arbolService = arbolService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("arboles", arbolService.listar());
        return "arbol/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("arbol", new Arbol());
        return "arbol/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Arbol arbol,
                          @RequestParam("imagenFile") MultipartFile imagenFile) {
        arbolService.save(arbol, imagenFile);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("arbol", arbolService.obtenerPorId(id));
        return "arbol/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        arbolService.eliminar(id);
        return "redirect:/arbol/listado";
    }
}
