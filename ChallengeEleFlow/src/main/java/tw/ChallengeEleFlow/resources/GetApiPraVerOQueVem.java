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

		try {

			
			/*
			HttpURLConnection connection = (HttpURLConnection) new URL(urlBase+"planets/").openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");

			if (connection.getResponseCode() != 200) {
				System.out.println("Erro " + connection.getResponseCode() + "ao obter dados da URL: " + urlBase);
			}

			BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			*/


			//String output = ""; //request simulado pra não ser bloqueado no swapi.io
			String output = "{\"count\":60,\"next\":\"http://swapi.dev/api/planets/?page=2\",\"previous\":null,\"results\":[{\"name\":\"Tatooine\",\"rotation_period\":\"23\",\"orbital_period\":\"304\",\"diameter\":\"10465\",\"climate\":\"arid\",\"gravity\":\"1 standard\",\"terrain\":\"desert\",\"surface_water\":\"1\",\"population\":\"200000\",\"residents\":[\"http://swapi.dev/api/people/1/\",\"http://swapi.dev/api/people/2/\",\"http://swapi.dev/api/people/4/\",\"http://swapi.dev/api/people/6/\",\"http://swapi.dev/api/people/7/\",\"http://swapi.dev/api/people/8/\",\"http://swapi.dev/api/people/9/\",\"http://swapi.dev/api/people/11/\",\"http://swapi.dev/api/people/43/\",\"http://swapi.dev/api/people/62/\"],\"films\":[\"http://swapi.dev/api/films/1/\",\"http://swapi.dev/api/films/3/\",\"http://swapi.dev/api/films/4/\",\"http://swapi.dev/api/films/5/\",\"http://swapi.dev/api/films/6/\"],\"created\":\"2014-12-09T13:50:49.641000Z\",\"edited\":\"2014-12-20T20:58:18.411000Z\",\"url\":\"http://swapi.dev/api/planets/1/\"},{\"name\":\"Alderaan\",\"rotation_period\":\"24\",\"orbital_period\":\"364\",\"diameter\":\"12500\",\"climate\":\"temperate\",\"gravity\":\"1 standard\",\"terrain\":\"grasslands, mountains\",\"surface_water\":\"40\",\"population\":\"2000000000\",\"residents\":[\"http://swapi.dev/api/people/5/\",\"http://swapi.dev/api/people/68/\",\"http://swapi.dev/api/people/81/\"],\"films\":[\"http://swapi.dev/api/films/1/\",\"http://swapi.dev/api/films/6/\"],\"created\":\"2014-12-10T11:35:48.479000Z\",\"edited\":\"2014-12-20T20:58:18.420000Z\",\"url\":\"http://swapi.dev/api/planets/2/\"},{\"name\":\"Yavin IV\",\"rotation_period\":\"24\",\"orbital_period\":\"4818\",\"diameter\":\"10200\",\"climate\":\"temperate, tropical\",\"gravity\":\"1 standard\",\"terrain\":\"jungle, rainforests\",\"surface_water\":\"8\",\"population\":\"1000\",\"residents\":[],\"films\":[\"http://swapi.dev/api/films/1/\"],\"created\":\"2014-12-10T11:37:19.144000Z\",\"edited\":\"2014-12-20T20:58:18.421000Z\",\"url\":\"http://swapi.dev/api/planets/3/\"},{\"name\":\"Hoth\",\"rotation_period\":\"23\",\"orbital_period\":\"549\",\"diameter\":\"7200\",\"climate\":\"frozen\",\"gravity\":\"1.1 standard\",\"terrain\":\"tundra, ice caves, mountain ranges\",\"surface_water\":\"100\",\"population\":\"unknown\",\"residents\":[],\"films\":[\"http://swapi.dev/api/films/2/\"],\"created\":\"2014-12-10T11:39:13.934000Z\",\"edited\":\"2014-12-20T20:58:18.423000Z\",\"url\":\"http://swapi.dev/api/planets/4/\"},{\"name\":\"Dagobah\",\"rotation_period\":\"23\",\"orbital_period\":\"341\",\"diameter\":\"8900\",\"climate\":\"murky\",\"gravity\":\"N/A\",\"terrain\":\"swamp, jungles\",\"surface_water\":\"8\",\"population\":\"unknown\",\"residents\":[],\"films\":[\"http://swapi.dev/api/films/2/\",\"http://swapi.dev/api/films/3/\",\"http://swapi.dev/api/films/6/\"],\"created\":\"2014-12-10T11:42:22.590000Z\",\"edited\":\"2014-12-20T20:58:18.425000Z\",\"url\":\"http://swapi.dev/api/planets/5/\"},{\"name\":\"Bespin\",\"rotation_period\":\"12\",\"orbital_period\":\"5110\",\"diameter\":\"118000\",\"climate\":\"temperate\",\"gravity\":\"1.5 (surface), 1 standard (Cloud City)\",\"terrain\":\"gas giant\",\"surface_water\":\"0\",\"population\":\"6000000\",\"residents\":[\"http://swapi.dev/api/people/26/\"],\"films\":[\"http://swapi.dev/api/films/2/\"],\"created\":\"2014-12-10T11:43:55.240000Z\",\"edited\":\"2014-12-20T20:58:18.427000Z\",\"url\":\"http://swapi.dev/api/planets/6/\"},{\"name\":\"Endor\",\"rotation_period\":\"18\",\"orbital_period\":\"402\",\"diameter\":\"4900\",\"climate\":\"temperate\",\"gravity\":\"0.85 standard\",\"terrain\":\"forests, mountains, lakes\",\"surface_water\":\"8\",\"population\":\"30000000\",\"residents\":[\"http://swapi.dev/api/people/30/\"],\"films\":[\"http://swapi.dev/api/films/3/\"],\"created\":\"2014-12-10T11:50:29.349000Z\",\"edited\":\"2014-12-20T20:58:18.429000Z\",\"url\":\"http://swapi.dev/api/planets/7/\"},{\"name\":\"Naboo\",\"rotation_period\":\"26\",\"orbital_period\":\"312\",\"diameter\":\"12120\",\"climate\":\"temperate\",\"gravity\":\"1 standard\",\"terrain\":\"grassy hills, swamps, forests, mountains\",\"surface_water\":\"12\",\"population\":\"4500000000\",\"residents\":[\"http://swapi.dev/api/people/3/\",\"http://swapi.dev/api/people/21/\",\"http://swapi.dev/api/people/35/\",\"http://swapi.dev/api/people/36/\",\"http://swapi.dev/api/people/37/\",\"http://swapi.dev/api/people/38/\",\"http://swapi.dev/api/people/39/\",\"http://swapi.dev/api/people/42/\",\"http://swapi.dev/api/people/60/\",\"http://swapi.dev/api/people/61/\",\"http://swapi.dev/api/people/66/\"],\"films\":[\"http://swapi.dev/api/films/3/\",\"http://swapi.dev/api/films/4/\",\"http://swapi.dev/api/films/5/\",\"http://swapi.dev/api/films/6/\"],\"created\":\"2014-12-10T11:52:31.066000Z\",\"edited\":\"2014-12-20T20:58:18.430000Z\",\"url\":\"http://swapi.dev/api/planets/8/\"},{\"name\":\"Coruscant\",\"rotation_period\":\"24\",\"orbital_period\":\"368\",\"diameter\":\"12240\",\"climate\":\"temperate\",\"gravity\":\"1 standard\",\"terrain\":\"cityscape, mountains\",\"surface_water\":\"unknown\",\"population\":\"1000000000000\",\"residents\":[\"http://swapi.dev/api/people/34/\",\"http://swapi.dev/api/people/55/\",\"http://swapi.dev/api/people/74/\"],\"films\":[\"http://swapi.dev/api/films/3/\",\"http://swapi.dev/api/films/4/\",\"http://swapi.dev/api/films/5/\",\"http://swapi.dev/api/films/6/\"],\"created\":\"2014-12-10T11:54:13.921000Z\",\"edited\":\"2014-12-20T20:58:18.432000Z\",\"url\":\"http://swapi.dev/api/planets/9/\"},{\"name\":\"Kamino\",\"rotation_period\":\"27\",\"orbital_period\":\"463\",\"diameter\":\"19720\",\"climate\":\"temperate\",\"gravity\":\"1 standard\",\"terrain\":\"ocean\",\"surface_water\":\"100\",\"population\":\"1000000000\",\"residents\":[\"http://swapi.dev/api/people/22/\",\"http://swapi.dev/api/people/72/\",\"http://swapi.dev/api/people/73/\"],\"films\":[\"http://swapi.dev/api/films/5/\"],\"created\":\"2014-12-10T12:45:06.577000Z\",\"edited\":\"2014-12-20T20:58:18.434000Z\",\"url\":\"http://swapi.dev/api/planets/10/\"}]}";
			
			/*
			String line;
			
			while ((line = buffer.readLine()) != null) {
				output += line;
			}

			connection.disconnect();
			*/
			
			Gson gson = new Gson();
			PlanetaList planetaList = gson.fromJson(new String(output.getBytes()), PlanetaList.class);
			
			
			var teste = planetaList.results;
			

			System.out.println("Time: " + planetaList.results);
			
			
			

		} catch (Exception e) {
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
		ArrayList<PlanetaDTO> results = new ArrayList<>();

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
