package br.com.alelo.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo implements Serializable{

	private static final long serialVersionUID = -4315642695780021729L;
	
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY) 
 	private Long id;
	private String placaVeiculo;
	private String modelo;
	private String documento;
	private String nome;
	
	public Long getId() { 
		return id;
	} 
	public void setId(Long id) { 
		this.id = id;
	}
	public String getPlacaVeiculo() {
		return placaVeiculo;
	}
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
