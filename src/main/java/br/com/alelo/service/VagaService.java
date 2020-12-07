package br.com.alelo.service;

import java.util.List;

import java.util.Optional;
import br.com.alelo.dto.Vaga;

public interface VagaService {

	public void incluirVaga(Vaga vaga);
	public void removerVaga(Long id);
	public void removeVeiculoVaga(Vaga vaga) ;
	public List<Vaga> listarVaga();
	public List<Vaga> listarVagaDesocupada();
	public void incluirVeiculoVaga(Vaga vaga);
	public Optional<Vaga> buscarVagaPorVeiculo(Long idVeiculo);
}
