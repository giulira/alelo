package br.com.alelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import br.com.alelo.dto.Vaga;

@Repository
public interface VagaDAO extends CrudRepository<Vaga, Long>, JpaRepository<Vaga, Long>{

	@Query(
			  value = "SELECT * FROM VAGA v WHERE v.ocupado = false", 
			  nativeQuery = true)
	public List<Vaga> listarVagasDesocupadas();
	
	public Optional<Vaga> findByVeiculo(Long idVeiculo);
}
