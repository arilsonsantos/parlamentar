package br.com.orion.parlamentar.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class MandatoLegislatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer codigoLegislatura;
	private LocalDate dataIinicio;
	private LocalDate dataFim;
	private int legislatura; // 1ª ou 2ª Legislatura

	@ManyToOne
	private Mandato mandato;

}
