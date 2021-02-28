package tw.ChallengeEleFlow.services;

import java.util.ArrayList;
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
		planets1.getFilms().addAll(Arrays.asList(
				"http://swapi.dev/api/films/6/"));

		Planets planets2 = new Planets(null, "Marte", "quente", "90% Terra");
		planets2.getFilms().addAll(Arrays.asList(
				"http://swapi.dev/api/films/5/", 
				"http://swapi.dev/api/films/6/"));
		
		Planets planets3 = new Planets(null, "Jupter", "Desconhecido", "100% Gas");
		planets3.getFilms().addAll(Arrays.asList(
				"http://swapi.dev/api/films/4/", 
				"http://swapi.dev/api/films/5/", 
				"http://swapi.dev/api/films/6/"));
		
		
		Planets planets4 = new Planets(null, "Palióça", "Inópito", "75% Tainha");
		planets4.getFilms().addAll(Arrays.asList(
				"http://swapi.dev/api/films/3/",
				"http://swapi.dev/api/films/4/", 
				"http://swapi.dev/api/films/5/", 
				"http://swapi.dev/api/films/6/"));
		
		
		iPlanetsRepository.saveAll(Arrays.asList(planets1, planets2, planets3, planets4));

	}
}
