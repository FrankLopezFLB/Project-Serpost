package proy.serpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import proy.serpost.model.Destino;
import proy.serpost.repository.IRepositoryDestino;
import proy.serpost.repository.IRepositoryRegion;

@Controller
@RequestMapping(path = "/destino")
public class DestinoController {
	
	@Autowired
	private IRepositoryDestino repod;
	
	@Autowired
	private IRepositoryRegion repor;
	
	String incrementaCodigo(String Codigo) {
		
		Codigo = Codigo.substring(1, Codigo.length());
		int num = Integer.parseInt(Codigo)+1;
		int largo = (num+"").length();
		int repetir = 0;
		if(largo < 4)
			repetir = 4-largo;
		Codigo = "D" + "0".repeat(repetir) + num;
		//System.out.println("Numero: " + num + " | Largo: " + largo + " | Repetir: " + repetir+ " | Codigo: " + Codigo);
		return Codigo;
	}
	
	@GetMapping("/cargar")
	public String cargarPag(Model model) {
		model.addAttribute("destino", new Destino(null, null, null, null, -1));
		model.addAttribute("lstRegiones", repor.findAll());
		model.addAttribute("lstDestinos", repod.findAll());
		
		return "mantenimientoDestino";
	}
	
	
	/*String ultimoCodigo = repod.getMaxCodigoDestino();
		ultimoCodigo = incrementaCodigo(ultimoCodigo);*/
	
	@PostMapping("/guardar")
	public String actualizarReg(@ModelAttribute Destino d, Model model) {
		repod.save(d);
		
		model.addAttribute("mensaje", "Registro eliminado");
		
		model.addAttribute("destino", new Destino());
		model.addAttribute("lstRegiones", repor.findAll());
		model.addAttribute("lstDestinos", repod.findAll());
		return "mantenimientoDestino";
		
		/*try {
			Destino destino_actualizar = repod.findByCodigo(d.getCodigo());
			repod.save(destino_actualizar);
			
			model.addAttribute("mensaje", "Registro eliminado");
			
			model.addAttribute("destino", new Destino());
			model.addAttribute("lstRegiones", repor.findAll());
			model.addAttribute("lstDestinos", repod.findAll());
			return "mantenimientoDestino";
			
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al eliminar");
			
			model.addAttribute("destino", new Destino());
			model.addAttribute("lstRegiones", repor.findAll());
			model.addAttribute("lstDestinos", repod.findAll());
			return "mantenimientoDestino";
		}*/
	}
	
	/*@PostMapping("/eliminar")
	public String eliminarReg(@ModelAttribute Destino d, Model model) {
		repod.deleteById(d.getCodigo());
		boolean aux = repod.findByCodigolibro(d.getCodigo()) == null;
		if(aux == true) {
			model.addAttribute("mensaje", "Registro eliminado");
		} else {
			model.addAttribute("mensaje", "Error al eliminar");
		}
		model.addAttribute("destino", new Destino());
		model.addAttribute("lstRegiones", repor.findAll());
		model.addAttribute("lstDestinos", repod.findAll());
		
		return "mantenimientoDestino";
	}*/
}
