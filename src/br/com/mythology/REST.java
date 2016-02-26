package br.com.mythology;

import static spark.Spark.get;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.db4o.ObjectSet;

import spark.Request;
import spark.Response;
import spark.Route;

public class REST{
	
	private Model model;	
	
	public REST(Model model){
		this.model = model;
	}
	
	public void makeRoute(){
				
		get(new Route("/mythology/search/id/:id") {
	         @Override
	         public Object handle(Request request, Response response) {
	        	 
	            Integer id = Integer.parseInt(request.params(":id"));	        	
	            
	            try {
	            	Character character = model.searchCharacterById(id);
	            	
	            	JSONArray jsonResult = new JSONArray();
	         	    JSONObject jsonObj = new JSONObject();

	        		jsonObj.put("name", character.getName());
	        		jsonObj.put("origin", character.getOrigin());
	        		jsonObj.put("father", character.getParents().getFather());
	        		jsonObj.put("mother", character.getParents().getMother());
	             	jsonResult.put(jsonObj);
	             	
	             	return jsonResult;
	             	
        		} catch (JSONException e) {	        				
        			e.printStackTrace();
        		}	         	    	
	
	     	    return null;	     	     
	         }	         
	      });
		
		get(new Route("/mythology/search/name/:name") {
	         @Override
	         public Object handle(Request request, Response response) {
	        	 
	            String name = request.params(":name");	        	
	            
	            try {
	            	Character character = model.searchCharacterByName(name);
	            	
	            	JSONArray jsonResult = new JSONArray();
	         	    JSONObject jsonObj = new JSONObject();

	        		jsonObj.put("name", character.getName());
	        		jsonObj.put("origin", character.getOrigin());
	        		jsonObj.put("father", character.getParents().getFather());
	        		jsonObj.put("mother", character.getParents().getMother());
	             	jsonResult.put(jsonObj);
	             	
	             	return jsonResult;
	             	
       		} catch (JSONException e) {	        				
       			e.printStackTrace();
       		}	         	    	
	
	     	    return null;	     	     
	         }	         
	      });
		
		
		get(new Route("/mythology/search/parents/:father/:mother") {
			@Override
			public Object handle(Request request, Response response) {
				 
				String father = request.params(":father");
				String mother = request.params(":mother");	
				
				try {					
					ObjectSet<Character> characters = model.searchCharacterByParents(new Parents(father, mother));
					
					JSONArray jsonResult = new JSONArray();	         	    
					
					for(Character character: characters){
						JSONObject jsonObj = new JSONObject();
						jsonObj.put("name", character.getName());
						jsonObj.put("origin", character.getOrigin());
						jsonObj.put("father", character.getParents().getFather());
						jsonObj.put("mother", character.getParents().getMother());
						jsonResult.put(jsonObj);
					}	         	           		
				     	
					return jsonResult;
				     	
				} catch (JSONException e) {	        				
					e.printStackTrace();
				}	         	    	
				
				return null;
			
			}	         
		});
		
		get(new Route("/mythology/") {
	         @Override
	         public Object handle(Request request, Response response) {       	
	            
	            try {
	            	ObjectSet<Character> characters = model.searchAllCharacters();
	            	
	            	JSONArray jsonResult = new JSONArray();	         	    

	         	    for(Character character: characters){
	         	    	JSONObject jsonObj = new JSONObject();
	         	    	jsonObj.put("name", character.getName());
		        		jsonObj.put("origin", character.getOrigin());
		        		jsonObj.put("father", character.getParents().getFather());
		        		jsonObj.put("mother", character.getParents().getMother());
		             	jsonResult.put(jsonObj);
	         	    }	         	           		
	             	
	             	return jsonResult;
	             	
        		} catch (JSONException e) {	        				
        			e.printStackTrace();
        		}	         	    	

	     	    return null;	     	     
	         }	         
	      });
	
	}		
}
