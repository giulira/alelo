package br.com.alelo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alelo.dto.Vaga;
import br.com.alelo.dto.Veiculo;
import br.com.alelo.service.VagaService;

@RestController
@RequestMapping("estacionamento")
public class EstacionamentoController {

	@Autowired
	private VagaService service;
	
	@RequestMapping(value = "/incluirVaga", method = RequestMethod.POST)
	public ResponseEntity<Object> incluirVaga(@RequestBody Vaga vaga){
		service.incluirVaga(vaga);
		return new ResponseEntity<>("Vaga criada com sucesso", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/removerVaga", method = RequestMethod.DELETE)
	public ResponseEntity<Object> removerVaga(@RequestBody Long id){
		service.removerVaga(id);
		return new ResponseEntity<>("Vaga removida.", HttpStatus.OK); 
	}
	
	  
	@RequestMapping(value = "/listarVaga", method = RequestMethod.GET)
	public ResponseEntity<Object> listarVaga(){
		List<Vaga> vagas = service.listarVaga();
		if(vagas != null) {
			return new ResponseEntity<>(vagas, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Não existem vagas cadastradas", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/incluirVeiculoVaga", method = RequestMethod.POST)
	public ResponseEntity<Object> incluirVeiculoVaga(@RequestBody Veiculo veiculo){
		List<Vaga> vagas = service.listarVagaDesocupada();
		if(vagas.isEmpty()) {
			return new ResponseEntity<>("Estacionamento Lotado!", HttpStatus.OK);
		}else {
			Vaga v = vagas.get(0);
			v.setVeiculo(veiculo);
			v.setOcupado(true);
			service.incluirVeiculoVaga(v);
			return new ResponseEntity<>("Veiculo adicionado na vaga", HttpStatus.CREATED);	
		}
	}
	
	@RequestMapping(value = "/removerVeiculoVaga", method = RequestMethod.PUT)
	public ResponseEntity<Object> removerVeiculoVaga(@RequestParam(name="id") Long id){
		Optional<Vaga> vaga = service.buscarVagaPorVeiculo(id);
		vaga.get().setVeiculo(null);
		vaga.get().setOcupado(false);
		service.removeVeiculoVaga(vaga.get());
		return new ResponseEntity<>("Veiculo removido da vaga", HttpStatus.OK);		
	}
}
