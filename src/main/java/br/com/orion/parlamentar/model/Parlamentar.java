package br.com.orion.parlamentar.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Parlamentar {

	@Id
	private Integer id;
	private String nome;
	private String nomeCompleto;
	private String sexo;
	private String formaTratamento;
	private String urlFoto;
	private String urlSite;
	private String urlGlossario;
	private String email;
	private String siglaPartido;
	private String uf;

	@OneToOne(cascade = CascadeType.MERGE, mappedBy = "parlamentar")
	private Mandato mandato;

}
