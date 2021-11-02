package proy.serpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import proy.serpost.model.Cliente;
import proy.serpost.repository.IClienteRepository;

@Controller
public class ClienteController {
	@Autowired
	private IClienteRepository repoc;
	
	@GetMapping("/cargarCli")
	public String cargarCli(Model model) {
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("lstClientes", repoc.findAll());
		return "mantenimientoCliente";
	}
	
	@PostMapping("/grabarCli")
	public String grabarPag(@ModelAttribute Cliente cliente, Model model) {
		System.out.println("Listo para grabar");
		System.out.println(cliente);
		repoc.save(cliente);
		model.addAttribute("lstClientes", repoc.findAll());
		return "mantenimientoCliente";
	}
	
	@GetMapping("/listarCli")
	public String listadoCliente(Model model) {
		model.addAttribute("lstClientes", repoc.findAll());
		return "listadoCliente";
	}
	
	@PostMapping("/editarCli")
	public String buscarCli(@ModelAttribute Cliente c, Model model) {
		System.out.println(c);
		model.addAttribute("cliente", repoc.findById(c.getCodigoCli()));
		return "manteminientoCliente";
	}
	
	@PostMapping("/eliminarCli")
	public String eliminarCli(@ModelAttribute Cliente cliente, Model model) {
		System.out.println("Listo para eliminar");
		System.out.println(cliente);
		repoc.delete(cliente);
		model.addAttribute("lstClientes", repoc.findAll());
		return "manteminientoCliente";
	}
}
