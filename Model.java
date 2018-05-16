package Win_SQL;

public class Model {
	private int id;
	private String name;
	private int attack;
	private int defend;
	private String sex;
	private String country;
	
	public Model() {
	}

	public Model(String name, int attack, int defend, String sex, String country) {
		super();
		this.name = name;
		this.attack = attack;
		this.defend = defend;
		this.sex = sex;
		this.country = country;
	}
	
	public int getId() {
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
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefend() {
		return defend;
	}
	public void setDefend(int defend) {
		this.defend = defend;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", attack=" + attack + ", country=" + country + ", defend="
				+ defend + ",sex=" + sex
				;
	}
	
}
