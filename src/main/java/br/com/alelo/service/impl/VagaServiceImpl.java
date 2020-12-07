package br.com.alelo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import br.com.alelo.dao.VagaDAO;
import br.com.alelo.dto.Vaga;
import br.com.alelo.service.VagaService;

@Service
public class VagaServiceImpl implements VagaService {

	@Autowired
	private VagaDAO dao;

	@Override
	public void incluirVaga(Vaga vaga) {
		dao.save(vaga);
		dao.flush();
		
	}

	@Override
	public void removerVaga(Long id) {
		dao.deleteById(id);
		dao.flush();
	}

	@Override
	public void removeVeiculoVaga(Vaga vaga) {
		dao.save(vaga);
		dao.flush();
	}

	@Override
	public List<Vaga> listarVaga() {
		return (List<Vaga>)dao.findAll();
	}

	@Override
	public void incluirVeiculoVaga(Vaga vaga) {
		dao.saveAndFlush(vaga);
		
	}

	@Override
	public List<Vaga> listarVagaDesocupada() {
		return dao.listarVagasDesocupadas();
	}

	@Override
	public Optional<Vaga> buscarVagaPorVeiculo(Long idVeiculo) {
		return dao.findById(idVeiculo);
	}
}
