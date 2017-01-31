package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "statistics")
@NamedQueries({
		@NamedQuery(name = "statistics.all", query = "SELECT s FROM Statistics s"),
		@NamedQuery(name = "statistics.id", query = "SELECT s FROM Statistics s WHERE s.id=:id") })
public class Statistics implements IHaveId {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int kills;
	private int deaths;
	private double kdRatio;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public double getKdRatio() {
		kdRatio = (double)kills/(double)deaths;
		return kdRatio;
	}
	public void setKdRatio(double kdRatio) {
		this.kdRatio = kdRatio;
	}
}
