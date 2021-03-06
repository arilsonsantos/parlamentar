package br.com.orion.parlamentar.model.node;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "exercicio" })
@XmlRootElement(name = "Exercicios")
public class ExerciciosNode {

	@XmlElement(name = "Exercicio", required = true)
	private List<ExercicioNode> exercicio;

}
