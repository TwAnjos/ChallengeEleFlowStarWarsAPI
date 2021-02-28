package tw.ChallengeEleFlow.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/TestandoChamadaDeAPI")
public class GetApiPraVerOQueVem {

	@RequestMapping(value = "/GetOpensky", method = RequestMethod.GET)
	public String GetOpensky() {
		String resultJson = "Estados = ";
		try {
			String url = "https://opensky-network.org/api/states/all?lamin=45.8389&lomin=5.9962&lamax=47.8229&lomax=10.5226";

			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");

			if (connection.getResponseCode() != 200) {
				System.out.println("Erro " + connection.getResponseCode() + "ao obter dados da URL: " + url);
			}

			BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String output = "";
			String line;
			
			while ((line = buffer.readLine()) != null) {
				output += line;
			}

			connection.disconnect();

			Gson gson = new Gson();

			Dados dados = gson.fromJson(new String(output.getBytes()), Dados.class);

			System.out.println("Time: " + dados.getTime());

			for (List<String> liststates : dados.states) {
				resultJson += liststates.get(2) + ", ";
			}

			System.out.println("STATES: " + resultJson);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultJson;
	}

	@RequestMapping(value = "/goSWAPI", method = RequestMethod.GET)
	public String goSWAPI() {

		// preciso do link da base
		String urlBase = "https://swapi.dev/api/"; // "https://swapi.dev/api/planets/";

//		RestTemplate restTemplate = new RestTemplate();
//		
//		RestTemplate newResponseEntity = restTemplate.exchange(
//				urlBase+ "planets/",
//				getMyHeader(),
//				deserializa);

		try {

			// Construindo url
			URL url = new URL(urlBase + "planets/");

			// abrindo conexão
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

			// recebendo o Json de resposta
			InputStream stream = connection.getInputStream();
			String response = new Scanner(stream).useDelimiter("\\A").next();

			Object oteste = response;

			stream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public class Dados {
		private float time;
		List<List<String>> states = new ArrayList<List<String>>();

		// Getter Methods

		public float getTime() {
			return time;
		}

		public void setTime(float time) {
			this.time = time;
		}
	}

	public class PlanetaList {
		private float count;
		private String next;
		private String previous = null;
		ArrayList<PlanetaDTO> resultsPlanetas = new ArrayList<>();

		// Getter Methods

		public float getCount() {
			return count;
		}

		public String getNext() {
			return next;
		}

		public String getPrevious() {
			return previous;
		}

		// Setter Methods

		public void setCount(float count) {
			this.count = count;
		}

		public void setNext(String next) {
			this.next = next;
		}

		public void setPrevious(String previous) {
			this.previous = previous;
		}
	}

	public class PlanetaDTO {

		private String name;
		private String rotation_period;
		private String orbital_period;
		private String diameter;
		private String climate;
		private String gravity;
		private String terrain;
		private String surface_water;
		private String population;
		ArrayList<String> residents = new ArrayList<>();
		ArrayList<String> films = new ArrayList<>();
		private String created;
		private String edited;
		private String url;

		// Getter Methods

		public String getName() {
			return name;
		}

		public String getRotation_period() {
			return rotation_period;
		}

		public String getOrbital_period() {
			return orbital_period;
		}

		public String getDiameter() {
			return diameter;
		}

		public String getClimate() {
			return climate;
		}

		public String getGravity() {
			return gravity;
		}

		public String getTerrain() {
			return terrain;
		}

		public String getSurface_water() {
			return surface_water;
		}

		public String getPopulation() {
			return population;
		}

		public String getCreated() {
			return created;
		}

		public String getEdited() {
			return edited;
		}

		public String getUrl() {
			return url;
		}

		// Setter Methods

		public void setName(String name) {
			this.name = name;
		}

		public void setRotation_period(String rotation_period) {
			this.rotation_period = rotation_period;
		}

		public void setOrbital_period(String orbital_period) {
			this.orbital_period = orbital_period;
		}

		public void setDiameter(String diameter) {
			this.diameter = diameter;
		}

		public void setClimate(String climate) {
			this.climate = climate;
		}

		public void setGravity(String gravity) {
			this.gravity = gravity;
		}

		public void setTerrain(String terrain) {
			this.terrain = terrain;
		}

		public void setSurface_water(String surface_water) {
			this.surface_water = surface_water;
		}

		public void setPopulation(String population) {
			this.population = population;
		}

		public void setCreated(String created) {
			this.created = created;
		}

		public void setEdited(String edited) {
			this.edited = edited;
		}

		public void setUrl(String url) {
			this.url = url;
		}

	}

}
