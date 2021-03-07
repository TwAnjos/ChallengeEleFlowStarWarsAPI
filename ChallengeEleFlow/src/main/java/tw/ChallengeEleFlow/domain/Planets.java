package tw.ChallengeEleFlow.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import tw.ChallengeEleFlow.resources.GetApiPraVerOQueVem.PlanetaDTO;

@Entity
public class Planets implements Serializable {

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String name;
	private String rotation_period;
	private String orbital_period;
	private String diameter;
	private String climate;
	private String gravity;
	private String terrain;
	private String surface_water;
	private String population;

	@ElementCollection
	@CollectionTable(name = "Planets_Residents")
	public List<String> residents = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "Planets_Filmes")
	public List<String> films = new ArrayList<>();
	private String created;
	private String edited;
	private String url;

	public Planets() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planets other = (Planets) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRotation_period() {
		return rotation_period;
	}

	public void setRotation_period(String rotation_period) {
		this.rotation_period = rotation_period;
	}

	public String getOrbital_period() {
		return orbital_period;
	}

	public void setOrbital_period(String orbital_period) {
		this.orbital_period = orbital_period;
	}

	public String getDiameter() {
		return diameter;
	}

	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	public String getSurface_water() {
		return surface_water;
	}

	public void setSurface_water(String surface_water) {
		this.surface_water = surface_water;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getEdited() {
		return edited;
	}

	public void setEdited(String edited) {
		this.edited = edited;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Planets(Integer id, String name, String rotation_period, String orbital_period, String diameter,
			String climate, String gravity, String terrain, String surface_water, String population,
			List<String> residents, List<String> films, String created, String edited, String url) {
		super();
		this.id = id;
		this.name = name;
		this.rotation_period = rotation_period;
		this.orbital_period = orbital_period;
		this.diameter = diameter;
		this.climate = climate;
		this.gravity = gravity;
		this.terrain = terrain;
		this.surface_water = surface_water;
		this.population = population;
		this.residents = residents;
		this.films = films;
		this.created = created;
		this.edited = edited;
		this.url = url;
	}

	public class ReturnPlanetsAPI {
		private float count;
		private String next;
		private String previous = null;
		public List<Planets> results = new ArrayList<>();
		
		public ReturnPlanetsAPI() {
		}

		public ReturnPlanetsAPI(float count, String next, String previous, List<Planets> results) {
			super();
			this.count = count;
			this.next = next;
			this.previous = previous;
			this.results = results;
		}

		public float getCount() {
			return count;
		}

		public void setCount(float count) {
			this.count = count;
		}

		public String getNext() {
			return next;
		}

		public void setNext(String next) {
			this.next = next;
		}

		public String getPrevious() {
			return previous;
		}

		public void setPrevious(String previous) {
			this.previous = previous;
		}
		
		
		
		
	}

}
