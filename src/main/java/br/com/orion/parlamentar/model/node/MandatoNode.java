package br.com.orion.parlamentar.model.node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "codigoMandato", "ufParlamentar", "primeiraLegislaturaDoMandato",
		"segundaLegislaturaDoMandato", "urlPaginaNoMandato", "descricaoParticipacao", "titular", "suplentes",
		"exercicios" })
@XmlRootElement(name = "Mandato")
public class MandatoNode {

	@XmlElement(name = "CodigoMandato")
	private Integer codigoMandato;

	@XmlElement(name = "UfParlamentar")
	private String ufParlamentar;

	@XmlElement(name = "PrimeiraLegislaturaDoMandato")
	private PrimeiraLegislaturaDoMandatoNode primeiraLegislaturaDoMandato;

	@XmlElement(name = "SegundaLegislaturaDoMandato")
	private SegundaLegislaturaDoMandatoNode segundaLegislaturaDoMandato;

	@XmlElement(name = "UrlPaginaNoMandato")
	private String urlPaginaNoMandato;

	@XmlElement(name = "DescricaoParticipacao")
	private String descricaoParticipacao;

	@XmlElement(name = "Titular")
	private TitularNode titular;

	@XmlElement(name = "Suplentes")
	private SuplentesNode suplentes;

	@XmlElement(name = "Exercicios")
	private ExerciciosNode exercicios;

}
