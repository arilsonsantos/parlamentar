package br.com.orion.parlamentar.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = { "suplentes", "exercicios", "legislaturas" })
@EqualsAndHashCode(exclude = { "suplentes", "exercicios", "legislaturas" })
@Entity
public class Mandato {

	@Id
	private Integer id;
	private String descricaoParticipacao;

	@OneToOne
	@JoinColumn(name = "parlamentar_id", referencedColumnName = "id", insertable = true)
	private Parlamentar parlamentar;

	@OneToMany(mappedBy = "mandato", cascade = CascadeType.MERGE)
	private List<MandatoLegislatura> legislaturas;

	@OneToMany(mappedBy = "mandato", cascade = CascadeType.MERGE)
	private List<Suplente> suplentes;

	@OneToMany(mappedBy = "mandato", cascade = CascadeType.MERGE)
	private List<Exercicio> exercicios;

}
