package br.com.mythology;

public class Parents {
	
	private String father;
	private String mother;
	
	public Parents(String father, String mother) {
		this.father = father;
		this.mother = mother;
	}
	
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	
	public boolean comparar(Parents parents){
		if(father.equals(parents.father) && mother.equals(parents.mother)) return true;
		return false;
	}
		
}
