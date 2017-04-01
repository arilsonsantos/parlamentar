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
@XmlType(name = "", propOrder = { "codigoExercicio", "dataInicio", "dataFim", "siglaCausaAfastamento",
		"descricaoCausaAfastamento", "dataLeitura" })
@XmlRootElement(name = "Exercicio")
public class ExercicioNode {

	@XmlElement(name = "CodigoExercicio")
	private Integer codigoExercicio;

	@XmlElement(name = "DataInicio")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private LocalDate dataInicio;

	@XmlElement(name = "DataFim")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private LocalDate dataFim;

	@XmlElement(name = "SiglaCausaAfastamento")
	private String siglaCausaAfastamento;

	@XmlElement(name = "DescricaoCausaAfastamento")
	private String descricaoCausaAfastamento;

	@XmlElement(name = "DataLeitura")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private LocalDate dataLeitura;

}
