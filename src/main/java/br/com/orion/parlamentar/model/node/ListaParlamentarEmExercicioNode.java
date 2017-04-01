package br.com.orion.parlamentar.model.node;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "metadados", "parlamentares" })
@XmlRootElement(name = "ListaParlamentarEmExercicio")
public class ListaParlamentarEmExercicioNode {

	@XmlElement(name = "Metadados")
	private MetadadosNode metadados;

	@XmlElement(name = "Parlamentares")
	private Parlamentares parlamentares;

}
