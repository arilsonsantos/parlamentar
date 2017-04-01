package br.com.orion.parlamentar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.orion.parlamentar.model.Exercicio;
import br.com.orion.parlamentar.model.Mandato;
import br.com.orion.parlamentar.model.MandatoLegislatura;
import br.com.orion.parlamentar.model.Parlamentar;
import br.com.orion.parlamentar.model.Suplente;
import br.com.orion.parlamentar.model.node.IdentificacaoParlamentarNode;
import br.com.orion.parlamentar.model.node.ListaParlamentarEmExercicioNode;
import br.com.orion.parlamentar.model.node.MandatoNode;
import br.com.orion.parlamentar.model.node.ParlamentarNode;
import br.com.orion.parlamentar.model.node.PrimeiraLegislaturaDoMandatoNode;
import br.com.orion.parlamentar.model.node.SegundaLegislaturaDoMandatoNode;
import br.com.orion.parlamentar.repository.ParlamentarRepository;

@Service
public class ParlamentarService {

	@Autowired
	private ParlamentarRepository parlamentarRepository;

	public void findAllToPersisteInDataBase() {
		RestTemplate restTemplate = new RestTemplate();

		ListaParlamentarEmExercicioNode listaParlamentar = restTemplate.getForObject(
				"http://legis.senado.gov.br/dadosabertos/senador/lista/atual", ListaParlamentarEmExercicioNode.class);

		listaParlamentar.getParlamentares().getParlamentar().forEach(p -> {
			Parlamentar parlamentar = new Parlamentar();
			IdentificacaoParlamentarNode idpNode = p.getIdentificacaoParlamentar();

			parlamentar.setId(idpNode.getCodigoParlamentar());
			parlamentar.setNome(idpNode.getNomeParlamentar());
			parlamentar.setNomeCompleto(idpNode.getNomeCompletoParlamentar());
			parlamentar.setFormaTratamento(idpNode.getFormaTratamento());
			parlamentar.setEmail(idpNode.getEmailParlamentar());
			parlamentar.setSexo(idpNode.getSexoParlamentar());
			parlamentar.setSiglaPartido(idpNode.getSiglaPartidoParlamentar());
			parlamentar.setUf(idpNode.getUfParlamentar());
			parlamentar.setUrlFoto(idpNode.getUrlFotoParlamentar());
			parlamentar.setUrlSite(idpNode.getUrlPaginaParlamentar());
			parlamentar.setUrlGlossario(p.getUrlGlossario());

			// Mandato
			Mandato mandato = fillMandato(p, parlamentar);

			// Legislaturas
			List<MandatoLegislatura> legislaturas = fillLegislaturas(p, mandato);
			mandato.setLegislaturas(legislaturas);

			// Suplente
			List<Suplente> suplentes = fillSuplente(p, mandato);
			mandato.setSuplentes(suplentes);

			// Exercicios
			List<Exercicio> exercicios = fillExercicio(p, mandato);
			mandato.setExercicios(exercicios);

			parlamentarRepository.save(parlamentar);

		});
	}

	private Mandato fillMandato(ParlamentarNode parlamentarNode, Parlamentar parlamentar) {
		Mandato mandato = new Mandato();
		MandatoNode mandatoNode = parlamentarNode.getMandato();
		mandato.setId(mandatoNode.getCodigoMandato());
		mandato.setDescricaoParticipacao(mandatoNode.getDescricaoParticipacao());
		mandato.setParlamentar(parlamentar);
		parlamentar.setMandato(mandato);

		return mandato;
	}

	private List<MandatoLegislatura> fillLegislaturas(ParlamentarNode parlamentarNode, Mandato mandato) {
		// Mandato Primeira Legislatura
		MandatoLegislatura mandatoPrimeiraLegislatura = new MandatoLegislatura();
		PrimeiraLegislaturaDoMandatoNode primeiraLegistaturaNode = parlamentarNode.getMandato()
				.getPrimeiraLegislaturaDoMandato();
		mandatoPrimeiraLegislatura.setCodigoLegislatura(primeiraLegistaturaNode.getNumeroLegislatura());
		mandatoPrimeiraLegislatura.setDataIinicio(primeiraLegistaturaNode.getDataInicio());
		mandatoPrimeiraLegislatura.setDataFim(primeiraLegistaturaNode.getDataFim());
		mandatoPrimeiraLegislatura.setMandato(mandato);
		mandatoPrimeiraLegislatura.setLegislatura(1);

		// Mandato Segunda Legislatura
		MandatoLegislatura mandatoSegundaLegislatura = new MandatoLegislatura();
		SegundaLegislaturaDoMandatoNode segundaLegistaturaNode = parlamentarNode.getMandato()
				.getSegundaLegislaturaDoMandato();
		mandatoSegundaLegislatura.setCodigoLegislatura(segundaLegistaturaNode.getNumeroLegislatura());
		mandatoSegundaLegislatura.setDataIinicio(segundaLegistaturaNode.getDataInicio());
		mandatoSegundaLegislatura.setDataFim(segundaLegistaturaNode.getDataFim());
		mandatoSegundaLegislatura.setMandato(mandato);
		mandatoSegundaLegislatura.setLegislatura(2);

		List<MandatoLegislatura> legislaturas = new ArrayList<>();
		legislaturas.add(mandatoPrimeiraLegislatura);
		legislaturas.add(mandatoSegundaLegislatura);

		return legislaturas;
	}

	private List<Suplente> fillSuplente(ParlamentarNode parlamentarNode, Mandato mandato) {
		List<Suplente> suplentes = new ArrayList<>();
		parlamentarNode.getMandato().getSuplentes().getSuplente().forEach(s -> {
			Suplente suplente = new Suplente();
			suplente.setMandato(mandato);
			suplente.setDescricaoParticipacao(s.getDescricaoParticipacao());

			suplentes.add(suplente);

		});

		return suplentes;
	}

	private List<Exercicio> fillExercicio(ParlamentarNode parlamentarNode, Mandato mandato) {
		List<Exercicio> exercicios = new ArrayList<>();
		parlamentarNode.getMandato().getExercicios().getExercicio().forEach(e -> {
			Exercicio exercicio = new Exercicio();
			exercicio.setId(e.getCodigoExercicio());
			exercicio.setDataInicio(e.getDataInicio());
			exercicio.setDataFim(e.getDataFim());
			exercicio.setDataLeitura(e.getDataLeitura());
			exercicio.setSiglaCausaAfastamento(e.getSiglaCausaAfastamento());
			exercicio.setMandato(mandato);

			exercicios.add(exercicio);
		});

		return exercicios;
	}
}
