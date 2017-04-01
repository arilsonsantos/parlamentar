package br.com.orion.parlamentar.model.node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "codigoParlamentar", "nomeParlamentar", "nomeCompletoParlamentar", "sexoParlamentar",
		"formaTratamento", "urlFotoParlamentar", "urlPaginaParlamentar", "emailParlamentar", "siglaPartidoParlamentar",
		"ufParlamentar" })
@XmlRootElement(name = "IdentificacaoParlamentar")
public class IdentificacaoParlamentarNode {

	@XmlElement(name = "CodigoParlamentar")
	private Integer codigoParlamentar;

	@XmlElement(name = "NomeParlamentar")
	private String nomeParlamentar;

	@XmlElement(name = "NomeCompletoParlamentar")
	private String nomeCompletoParlamentar;

	@XmlElement(name = "SexoParlamentar")
	private String sexoParlamentar;

	@XmlElement(name = "FormaTratamento")
	private String formaTratamento;

	@XmlElement(name = "UrlFotoParlamentar")
	private String urlFotoParlamentar;

	@XmlElement(name = "UrlPaginaParlamentar")
	private String urlPaginaParlamentar;

	@XmlElement(name = "EmailParlamentar")
	private String emailParlamentar;

	@XmlElement(name = "SiglaPartidoParlamentar")
	private String siglaPartidoParlamentar;

	@XmlElement(name = "UfParlamentar")
	private String ufParlamentar;

}
