package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO  anaDAO;

	public Model() {
	
		anaDAO = new AnagrammaDAO();
	
	}
	
	public boolean isCorrect(String anagramma){
		
		return anaDAO.isCorrect(anagramma);
	}
		
	public Set<String> calcolaAnagrammi(String parola) { //uso il set perchè non voglio che gli anagrammi si ripetano
				
		Set <String> anagrammi = new HashSet <String>();
		
		String parziale="";
		
		recursive(parziale,0, parola,anagrammi);
		
		return anagrammi;				 
	}
 
	private void recursive(String parziale, int step, String parola, Set <String> anagrammi) {
		
		if( step == parola.length() ) {			
			
			anagrammi.add(parziale);
			
			return;
		}
			
		for(int i = 0; i< parola.length(); i++) {	
			
			//se non sono state inserite tutte le occorrenze di quel carattere nella parola, tale carattere va aggiunto al parziale
		
			if( numeroCaratteri(parziale, parola.charAt(i)) < numeroCaratteri(parola, parola.charAt(i)) ) {
				
				parziale += parola.charAt(i);
							
				recursive(parziale,step+1,parola,anagrammi);
				
				parziale = parziale.substring( 0, parziale.length()-1 );
			}
		}			
	}
	
	private int numeroCaratteri(String word, char c) {
		
		int cont=0;
		
		for(int i=0; i < word.length(); i++) {
		
		
			if(word.charAt(i) == c)
				
				cont ++;
		}
				
		return cont;		
	}  	
}
