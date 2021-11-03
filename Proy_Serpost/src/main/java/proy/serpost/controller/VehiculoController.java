package proy.serpost.controller;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proy.serpost.model.Vehiculo;
import proy.serpost.repository.IRepositoryConductor;
import proy.serpost.repository.IRepositoryVehiculo;

@Controller
@RequestMapping(path = "/vehiculo")
public class VehiculoController {
	
	@Autowired
	private IRepositoryVehiculo repov;
	
	@Autowired
	private IRepositoryConductor repocon;
	
	String incrementaCodigo(String cod) {
		
		cod = cod.substring(1, cod.length());
		int siguiente = Integer.parseInt(cod)+1;
		cod ="V"+ new DecimalFormat("0000").format(siguiente);
		return cod;
	}
	
	@GetMapping("/cargar")
	public String cargarVehiculos(Model model) {
		System.out.println(incrementaCodigo(repov.getMaxCodigoVehiculo()));
		model.addAttribute("vehiculo",new Vehiculo(null,null,null,null,null,-1));
		model.addAttribute("lstVehiculos",repov.findAll());
		model.addAttribute("lstConductores",repocon.findAll());
		return "mantenimientoVehiculo";
	}
	
	@PostMapping("/guardar")
	public String guardarVehiculo(@ModelAttribute Vehiculo v,Model model){
		repov.save(v);
		model.addAttribute("mensaje", "Vehiculo agregado");
		model.addAttribute("lstVehiculos",repov.findAll());
		model.addAttribute("lstConductores",repocon.findAll());
		return "mantenimientoVehiculo";
	}
}