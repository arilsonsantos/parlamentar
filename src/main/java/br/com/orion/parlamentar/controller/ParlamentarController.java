package br.com.orion.parlamentar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.orion.parlamentar.service.ParlamentarService;

@Controller
public class ParlamentarController {

	@Autowired
	private ParlamentarService parlamentarService;

	@RequestMapping("/parlamentares")
	public String index() {
		parlamentarService.findAllToPersisteInDataBase();
		return "index";
	}
}
