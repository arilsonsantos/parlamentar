package br.com.orion.parlamentar.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Exercicio {

	@Id
	private Integer id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private LocalDate dataLeitura;
	private String siglaCausaAfastamento;

	@ManyToOne
	private Mandato mandato;
}
