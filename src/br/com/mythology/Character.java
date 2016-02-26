package br.com.mythology;

public class Character {
	
	private int id;
	private String name;
	private Origin origin;
	private Parents parents;
	
	public Character(int id, String name, Origin origin, Parents parents) {
		this.id = id;
		this.name = name;
		this.origin = origin;
		this.parents = parents;
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

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Parents getParents() {
		return parents;
	}

	public void setParents(Parents parents) {
		this.parents = parents;
	}
	
}