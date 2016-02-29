package br.com.mythology;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Model{
	
	private String path = "H:/BD/FATEC A sem/Lab 3/work/mythology/db/";
	
	private ObjectContainer characters = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), path+"/db.db4o");	
	
	public void addCharacter(Character character){
		characters.store(character);
	}
	
	public void delCharacterById(int id){
		Character character = searchCharacterById(id);
		
		if(character != null){
			characters.delete(character);			
		}		
	}
	
	public Character searchCharacterById(int id){		
		
		Query query = characters.query();
		query.constrain(Character.class);
	    ObjectSet<Character> allCharacters = query.execute();
		
	    for(Character character: allCharacters){
	    	if(character.getId()==id){
	    		return character;
	    	}	    	
	    }	    
	    return null;	    		
	}
	
	public Character searchCharacterByName(String name){	
		
		Query query = characters.query();
		query.constrain(Character.class);
	    ObjectSet<Character> allCharacters = query.execute();
		
	    for(Character character: allCharacters){
	    	if(character.getName().toLowerCase().equals(name.toLowerCase())){
	    		return character;
	    	}	    	
	    }	    
	    return null;	    		
	}
		
	public ObjectSet<Character> searchCharacterByParents(Parents parents){		
		
		System.out.println(">>>>>>>>> 1");		
		
		Query query = characters.query();
		query.constrain(Character.class);
	    ObjectSet<Character> allCharacters = query.execute();
	    
	    ObjectSet<Character> found = null;
	    
	    System.out.println(">>>>>>>>> 2");
		
	    for(Character character: allCharacters){
	    	if(character.getParents().comparar(parents)){
	    		found.add(character);
	    		System.out.println("AEEE");
	    	}	    	
	    }
	    
	    System.out.println(">>>>>>>>> 3");
	    
	    if(!found.isEmpty()) {
			return found;
		}
	    
	    System.out.println(">>>>>>>>> 4");
	    
	    return null;
	    
	}	
	
	public ObjectSet<Character> searchAllCharacters(){
		Query query = characters.query();
		query.constrain(Character.class);
		ObjectSet<Character> allCharacters = query.execute();
	    
	    return allCharacters;
	}
}