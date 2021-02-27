package tw.ChallengeEleFlow.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.ChallengeEleFlow.domain.Planets;
import tw.ChallengeEleFlow.repositories.PlanetsRepository;

@Service
public class H2dbService {

	@Autowired
	private PlanetsRepository iPlanetsRepository;

	// Populando o servidor de testes
	public void instantiateH2dbTest() {

		PopulandoPlanetasManual();

	}

	private void PopulandoPlanetasManual() {
		Planets planets1 = new Planets(null, "Terra", "bom", "90% agua");
		Planets planets2 = new Planets(null, "Marte", "quente", "90% Terra");
		Planets planets3 = new Planets(null, "Jupter", "Desconhecido", "100% Gas");
		Planets planets4 = new Planets(null, "Palióça", "Inópito", "75% Tainha");

		iPlanetsRepository.saveAll(Arrays.asList(planets1, planets2, planets3, planets4));

	}
}
