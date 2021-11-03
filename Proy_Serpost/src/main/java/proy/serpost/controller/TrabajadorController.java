package proy.serpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proy.serpost.model.Trabajador;

import proy.serpost.repository.ICargoRepository;
import proy.serpost.repository.ITrabajadorRepository;



@Controller
@RequestMapping(path = "/trabajador")
public class TrabajadorController {
	
	@Autowired
	private ITrabajadorRepository repo;
	
	@Autowired
	private ICargoRepository repoCargo;
	
	@GetMapping("/cargar")
	public String cargarPag(Model model) {
		model.addAttribute("trabajador", new Trabajador());
		model.addAttribute("lstCargo",repoCargo.findAll());
		model.addAttribute("lstTrabajador",repo.findAll());
		System.out.println("Listado abierto");
		return "mantenimiento-trabajador";
	}
	
	@PostMapping("/guardar")
	public String guardarTrabajador(@ModelAttribute Trabajador t,Model model){
		model.addAttribute("trabajador", new Trabajador());
		model.addAttribute("lstTrabajador",repo.findAll());
		model.addAttribute("lstCargo",repoCargo.findAll());
		model.addAttribute("mensaje", "Trabajador agregado");
		
		repo.save(t);
			
		return "redirect:/trabajador/cargar";
	}
	
	@PostMapping("/eliminar")
	public String eliminarLibro (@ModelAttribute Trabajador t, Model model ) {
		repo.deleteById(t.getCodigoTra());
		model.addAttribute("lstTrabajador",repo.findAll());
		return "redirect:/trabajador/cargar";
	}
	
}
