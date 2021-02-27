package tw.ChallengeEleFlow.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planets implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	//private String rotation_period;
	//private String orbital_period;
	//private String diameter;
	private String climate;
	//private String gravity;
	private String terrain;
	//private String surface_water;
	//private String population;
	//List<String> residents = new ArrayList<>();
	
	//List<String> films = new ArrayList<>();
	
	//private String created;
	//private String edited;
	//private String url;

	public Planets() {
	}

//	public Planets(int id, String name, String rotation_period, String orbital_period, String diameter, String climate,
//			String gravity, String terrain, String surface_water, String population, String created, String edited,
//			String url) {
	public Planets(Integer id, String name,  String climate, String terrain) {
		super();
		this.id = id;
		this.name = name;
		//this.rotation_period = rotation_period;
		//this.orbital_period = orbital_period;
		//this.diameter = diameter;
		this.climate = climate;
		//this.gravity = gravity;
		this.terrain = terrain;
		//this.surface_water = surface_water;
		//this.population = population;
		//this.created = created;
		//this.edited = edited;
		//this.url = url;
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

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getRotation_period() {
//		return rotation_period;
//	}

//	public void setRotation_period(String rotation_period) {
//		this.rotation_period = rotation_period;
//	}

//	public String getOrbital_period() {
//		return orbital_period;
//	}

//	public void setOrbital_period(String orbital_period) {
//		this.orbital_period = orbital_period;
//	}

//	public String getDiameter() {
//		return diameter;
//	}

//	public void setDiameter(String diameter) {
//		this.diameter = diameter;
//	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

//	public String getGravity() {
//		return gravity;
//	}

//	public void setGravity(String gravity) {
//		this.gravity = gravity;
//	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

//	public String getSurface_water() {
//		return surface_water;
//	}

//	public void setSurface_water(String surface_water) {
//		this.surface_water = surface_water;
//	}

//	public String getPopulation() {
//		return population;
//	}

//	public void setPopulation(String population) {
//		this.population = population;
//	}

//	public List<String> getResidents() {
//		return residents;
//	}

//	public void setResidents(List<String> residents) {
//		this.residents = residents;
//	}

//	public List<String> getFilms() {
//		return films;
//	}
//
//	public void setFilms(List<String> films) {
//		this.films = films;
//	}

//	public String getCreated() {
//		return created;
//	}

//	public void setCreated(String created) {
//		this.created = created;
//	}

//	public String getEdited() {
//		return edited;
//	}

//	public void setEdited(String edited) {
//		this.edited = edited;
//	}

//	public String getUrl() {
//		return url;
//	}

//	public void setUrl(String url) {
//		this.url = url;
//	}
}
