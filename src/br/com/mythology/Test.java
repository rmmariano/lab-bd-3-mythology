package br.com.mythology;

import org.json.JSONException;

public class Test {		
	
	static Model model = new Model();
	
	public static void main(String[] args) throws JSONException{			
//		initialize();						
		REST controller = new REST(model); 			
		controller.makeRoute();						
	}

	public static void initialize(){
		model.addCharacter(new Character(1, "Hades", Origin.Greek, new Parents("Cronos","Reia")));
		model.addCharacter(new Character(2, "Zeus", Origin.Greek, new Parents("Cronos","Reia")));				
		model.addCharacter(new Character(3, "Héracles", Origin.Greek, new Parents("Zeus","Alcmena")));
		model.addCharacter(new Character(4, "Perseu", Origin.Greek, new Parents("Zeus","Dânae")));		
		model.addCharacter(new Character(5, "Netuno", Origin.Roman, new Parents("Saturno","Ops")));
		model.addCharacter(new Character(6, "Plutão ", Origin.Roman, new Parents("Saturno","Ops")));
	}
	
//	http://127.0.0.1:4567/mythology/search/id/1
//	http://127.0.0.1:4567/mythology/
	
}