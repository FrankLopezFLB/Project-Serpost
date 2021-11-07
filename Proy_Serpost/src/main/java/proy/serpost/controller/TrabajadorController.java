package proy.serpost.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class TrabajadorController {
	@GetMapping("/cargar")
	public String cargarPag(Model model) {
		System.out.println("Listado abierto");
		return "mantenimiento-trabajador";
	}
}
