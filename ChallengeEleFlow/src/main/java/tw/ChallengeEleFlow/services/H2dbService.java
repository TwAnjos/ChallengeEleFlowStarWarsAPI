package tw.ChallengeEleFlow.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import tw.ChallengeEleFlow.domain.Planets;
import tw.ChallengeEleFlow.domain.Planets.ReturnPlanetsAPI;
import tw.ChallengeEleFlow.repositories.PlanetsRepository;

@Service
public class H2dbService {

	@Autowired
	private PlanetsRepository iPlanetsRepository;

	// Populando o servidor de testes
	public void instantiateH2dbTest() {

		try {
			String url = "";
			while (url != null) {
				StringBuilder output = GetJsonAPIpagination(url);
				ReturnPlanetsAPI planetsAPI = GetReturnPlanetsAPIClean(output);
				List<Planets> planets = planetsAPI.results;
				url = planetsAPI.getNext();
				// foreach com lambda
				planets.forEach(planet -> iPlanetsRepository.saveAll(Arrays.asList(planet)));
			}
		} catch (
				JsonSyntaxException | IOException e) {
			e.printStackTrace();
		}
	}

	private ReturnPlanetsAPI GetReturnPlanetsAPIClean(StringBuilder output) {
		Gson gson = new Gson();
		return gson.fromJson(new String(output), ReturnPlanetsAPI.class);
	}

	private StringBuilder GetJsonAPIpagination(String currentURL) throws MalformedURLException, IOException {

		StringBuilder sb = new StringBuilder();
		String urlBase = currentURL;
		String line;

		if (currentURL == null) {
			// sb.append("{\"count\":60,\"next\":\"http://swapi.dev/api/planets/?page=2\",\"previous\":null,\"results\":[{\"name\":\"Tatooine\",\"rotation_period\":\"23\",\"orbital_period\":\"304\",\"diameter\":\"10465\",\"climate\":\"arid\",\"gravity\":\"1
			// standard\",\"terrain\":\"desert\",\"surface_water\":\"1\",\"population\":\"200000\",\"residents\":[\"http://swapi.dev/api/people/1/\",\"http://swapi.dev/api/people/2/\",\"http://swapi.dev/api/people/4/\",\"http://swapi.dev/api/people/6/\",\"http://swapi.dev/api/people/7/\",\"http://swapi.dev/api/people/8/\",\"http://swapi.dev/api/people/9/\",\"http://swapi.dev/api/people/11/\",\"http://swapi.dev/api/people/43/\",\"http://swapi.dev/api/people/62/\"],\"films\":[\"http://swapi.dev/api/films/1/\",\"http://swapi.dev/api/films/3/\",\"http://swapi.dev/api/films/4/\",\"http://swapi.dev/api/films/5/\",\"http://swapi.dev/api/films/6/\"],\"created\":\"2014-12-09T13:50:49.641000Z\",\"edited\":\"2014-12-20T20:58:18.411000Z\",\"url\":\"http://swapi.dev/api/planets/1/\"},{\"name\":\"Alderaan\",\"rotation_period\":\"24\",\"orbital_period\":\"364\",\"diameter\":\"12500\",\"climate\":\"temperate\",\"gravity\":\"1
			// standard\",\"terrain\":\"grasslands,
			// mountains\",\"surface_water\":\"40\",\"population\":\"2000000000\",\"residents\":[\"http://swapi.dev/api/people/5/\",\"http://swapi.dev/api/people/68/\",\"http://swapi.dev/api/people/81/\"],\"films\":[\"http://swapi.dev/api/films/1/\",\"http://swapi.dev/api/films/6/\"],\"created\":\"2014-12-10T11:35:48.479000Z\",\"edited\":\"2014-12-20T20:58:18.420000Z\",\"url\":\"http://swapi.dev/api/planets/2/\"},{\"name\":\"Yavin
			// IV\",\"rotation_period\":\"24\",\"orbital_period\":\"4818\",\"diameter\":\"10200\",\"climate\":\"temperate,
			// tropical\",\"gravity\":\"1 standard\",\"terrain\":\"jungle,
			// rainforests\",\"surface_water\":\"8\",\"population\":\"1000\",\"residents\":[],\"films\":[\"http://swapi.dev/api/films/1/\"],\"created\":\"2014-12-10T11:37:19.144000Z\",\"edited\":\"2014-12-20T20:58:18.421000Z\",\"url\":\"http://swapi.dev/api/planets/3/\"},{\"name\":\"Hoth\",\"rotation_period\":\"23\",\"orbital_period\":\"549\",\"diameter\":\"7200\",\"climate\":\"frozen\",\"gravity\":\"1.1
			// standard\",\"terrain\":\"tundra, ice caves, mountain
			// ranges\",\"surface_water\":\"100\",\"population\":\"unknown\",\"residents\":[],\"films\":[\"http://swapi.dev/api/films/2/\"],\"created\":\"2014-12-10T11:39:13.934000Z\",\"edited\":\"2014-12-20T20:58:18.423000Z\",\"url\":\"http://swapi.dev/api/planets/4/\"},{\"name\":\"Dagobah\",\"rotation_period\":\"23\",\"orbital_period\":\"341\",\"diameter\":\"8900\",\"climate\":\"murky\",\"gravity\":\"N/A\",\"terrain\":\"swamp,
			// jungles\",\"surface_water\":\"8\",\"population\":\"unknown\",\"residents\":[],\"films\":[\"http://swapi.dev/api/films/2/\",\"http://swapi.dev/api/films/3/\",\"http://swapi.dev/api/films/6/\"],\"created\":\"2014-12-10T11:42:22.590000Z\",\"edited\":\"2014-12-20T20:58:18.425000Z\",\"url\":\"http://swapi.dev/api/planets/5/\"},{\"name\":\"Bespin\",\"rotation_period\":\"12\",\"orbital_period\":\"5110\",\"diameter\":\"118000\",\"climate\":\"temperate\",\"gravity\":\"1.5
			// (surface), 1 standard (Cloud City)\",\"terrain\":\"gas
			// giant\",\"surface_water\":\"0\",\"population\":\"6000000\",\"residents\":[\"http://swapi.dev/api/people/26/\"],\"films\":[\"http://swapi.dev/api/films/2/\"],\"created\":\"2014-12-10T11:43:55.240000Z\",\"edited\":\"2014-12-20T20:58:18.427000Z\",\"url\":\"http://swapi.dev/api/planets/6/\"},{\"name\":\"Endor\",\"rotation_period\":\"18\",\"orbital_period\":\"402\",\"diameter\":\"4900\",\"climate\":\"temperate\",\"gravity\":\"0.85
			// standard\",\"terrain\":\"forests, mountains,
			// lakes\",\"surface_water\":\"8\",\"population\":\"30000000\",\"residents\":[\"http://swapi.dev/api/people/30/\"],\"films\":[\"http://swapi.dev/api/films/3/\"],\"created\":\"2014-12-10T11:50:29.349000Z\",\"edited\":\"2014-12-20T20:58:18.429000Z\",\"url\":\"http://swapi.dev/api/planets/7/\"},{\"name\":\"Naboo\",\"rotation_period\":\"26\",\"orbital_period\":\"312\",\"diameter\":\"12120\",\"climate\":\"temperate\",\"gravity\":\"1
			// standard\",\"terrain\":\"grassy hills, swamps, forests,
			// mountains\",\"surface_water\":\"12\",\"population\":\"4500000000\",\"residents\":[\"http://swapi.dev/api/people/3/\",\"http://swapi.dev/api/people/21/\",\"http://swapi.dev/api/people/35/\",\"http://swapi.dev/api/people/36/\",\"http://swapi.dev/api/people/37/\",\"http://swapi.dev/api/people/38/\",\"http://swapi.dev/api/people/39/\",\"http://swapi.dev/api/people/42/\",\"http://swapi.dev/api/people/60/\",\"http://swapi.dev/api/people/61/\",\"http://swapi.dev/api/people/66/\"],\"films\":[\"http://swapi.dev/api/films/3/\",\"http://swapi.dev/api/films/4/\",\"http://swapi.dev/api/films/5/\",\"http://swapi.dev/api/films/6/\"],\"created\":\"2014-12-10T11:52:31.066000Z\",\"edited\":\"2014-12-20T20:58:18.430000Z\",\"url\":\"http://swapi.dev/api/planets/8/\"},{\"name\":\"Coruscant\",\"rotation_period\":\"24\",\"orbital_period\":\"368\",\"diameter\":\"12240\",\"climate\":\"temperate\",\"gravity\":\"1
			// standard\",\"terrain\":\"cityscape,
			// mountains\",\"surface_water\":\"unknown\",\"population\":\"1000000000000\",\"residents\":[\"http://swapi.dev/api/people/34/\",\"http://swapi.dev/api/people/55/\",\"http://swapi.dev/api/people/74/\"],\"films\":[\"http://swapi.dev/api/films/3/\",\"http://swapi.dev/api/films/4/\",\"http://swapi.dev/api/films/5/\",\"http://swapi.dev/api/films/6/\"],\"created\":\"2014-12-10T11:54:13.921000Z\",\"edited\":\"2014-12-20T20:58:18.432000Z\",\"url\":\"http://swapi.dev/api/planets/9/\"},{\"name\":\"Kamino\",\"rotation_period\":\"27\",\"orbital_period\":\"463\",\"diameter\":\"19720\",\"climate\":\"temperate\",\"gravity\":\"1
			// standard\",\"terrain\":\"ocean\",\"surface_water\":\"100\",\"population\":\"1000000000\",\"residents\":[\"http://swapi.dev/api/people/22/\",\"http://swapi.dev/api/people/72/\",\"http://swapi.dev/api/people/73/\"],\"films\":[\"http://swapi.dev/api/films/5/\"],\"created\":\"2014-12-10T12:45:06.577000Z\",\"edited\":\"2014-12-20T20:58:18.434000Z\",\"url\":\"http://swapi.dev/api/planets/10/\"}]}");
			urlBase = "https://swapi.dev/api/planets/";
		}
		HttpURLConnection connection = (HttpURLConnection) new URL(urlBase).openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");

		if (connection.getResponseCode() != 200) {
			System.out.println("Erro " + connection.getResponseCode() + "ao obter dados da URL: " + urlBase);
		}

		BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		while ((line = buffer.readLine()) != null) {
			sb.append(line);
		}

		connection.disconnect();
		return sb;
	}

	private void PopulandoPlanetasManual() {
		/*
		 * Planets planets1 = new Planets(null, "Terra", "bom", "90% agua");
		 * planets1.getFilms().addAll(Arrays.asList( "http://swapi.dev/api/films/6/"));
		 * 
		 * Planets planets2 = new Planets(null, "Marte", "quente", "90% Terra");
		 * planets2.getFilms().addAll(Arrays.asList( "http://swapi.dev/api/films/5/",
		 * "http://swapi.dev/api/films/6/"));
		 * 
		 * Planets planets3 = new Planets(null, "Jupter", "Desconhecido", "100% Gas");
		 * planets3.getFilms().addAll(Arrays.asList( "http://swapi.dev/api/films/4/",
		 * "http://swapi.dev/api/films/5/", "http://swapi.dev/api/films/6/"));
		 * 
		 * 
		 * Planets planets4 = new Planets(null, "Palióça", "Inópito", "75% Tainha");
		 * planets4.getFilms().addAll(Arrays.asList( "http://swapi.dev/api/films/3/",
		 * "http://swapi.dev/api/films/4/", "http://swapi.dev/api/films/5/",
		 * "http://swapi.dev/api/films/6/"));
		 * 
		 * iPlanetsRepository.saveAll(Arrays.asList(planets1, planets2, planets3,
		 * planets4));
		 */
	}
}
