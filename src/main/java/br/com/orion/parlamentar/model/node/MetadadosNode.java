package br.com.orion.parlamentar.model.node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "versao", "versaoServico", "descricaoDataSet" })
@XmlRootElement(name = "Metadados")
public class MetadadosNode {

	@XmlElement(name = "Versao")
	private String versao;

	@XmlElement(name = "VersaoServico")
	private Integer versaoServico;

	@XmlElement(name = "DescricaoDataSet")
	private String descricaoDataSet;

}
