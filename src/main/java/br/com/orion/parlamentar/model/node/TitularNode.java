package br.com.orion.parlamentar.model.node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "descricaoParticipacao", "codigoParlamentar", "nomeParlamentar" })
@XmlRootElement(name = "Titular")
public class TitularNode {

	@XmlElement(name = "DescricaoParticipacao")
	private String descricaoParticipacao;

	@XmlElement(name = "CodigoParlamentar")
	private Integer codigoParlamentar;

	@XmlElement(name = "NomeParlamentar")
	private String nomeParlamentar;
}
