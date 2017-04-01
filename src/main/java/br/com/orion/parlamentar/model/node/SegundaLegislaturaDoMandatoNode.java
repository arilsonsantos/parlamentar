package br.com.orion.parlamentar.model.node;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.orion.parlamentar.adapter.DateAdapter;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "numeroLegislatura", "dataInicio", "dataFim" })
@XmlRootElement(name = "SegundaLegislaturaDoMandato")
public class SegundaLegislaturaDoMandatoNode {

	@XmlElement(name = "NumeroLegislatura")
	private Integer numeroLegislatura;

	@XmlElement(name = "DataInicio")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private LocalDate dataInicio;

	@XmlElement(name = "DataFim")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private LocalDate dataFim;
}
