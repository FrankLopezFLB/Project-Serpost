package proy.serpost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import proy.serpost.model.TipoObjeto;
import proy.serpost.repository.IRepositoryTipoObjeto;

@Controller
public class ReporteController {
	
	@Autowired
	private IRepositoryTipoObjeto repoto;
	
	@GetMapping("/cargarReporteTipo")
	public String cargarReporteTipo(Model model) {
		model.addAttribute("tipoobjeto", new TipoObjeto(-1, null));
		model.addAttribute("lstTipoObjetos", repoto.findAll());
		return "reportetipo";
	}

	@GetMapping("/cargarReporteFecha")
	public String cargarReporteFecha() {		
		return "reportefecha";
	}
}

