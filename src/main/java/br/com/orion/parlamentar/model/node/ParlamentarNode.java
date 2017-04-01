package br.com.orion.parlamentar.model.node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "identificacaoParlamentar", "mandato", "urlGlossario" })
@XmlRootElement(name = "Parlamentar")
public class ParlamentarNode {

	@XmlElement(name = "IdentificacaoParlamentar")
	private IdentificacaoParlamentarNode identificacaoParlamentar;

	@XmlElement(name = "Mandato")
	private MandatoNode mandato;

	@XmlElement(name = "UrlGlossario")
	private String urlGlossario;

}
