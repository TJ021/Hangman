package Game;
/*
 * Tejasvi & Purusoth
 * June 17, 2016
 */
public class Hangman {

/*
 * name String - used to store players name
 * tof String - used to determine whether the players guess was right 
 */
private String name;
private String tof;


public Hangman(){
	this.name = "";
}


public Hangman(String name){
	this.name = name;
}


/**
 * getName
 * @return name
 * used to return the users name to the client class
 */
public String getName(){
	return this.name;
}


/**
 * Check
 * @param guessWord
 * @param word
 * @return tof or ""
 * checks if word or letter entered by user is equal to or in the word they're trying to guess
 */
public String Check(String guessWord, String word){
	//if the player guessed the entire word:
	if(word.length() == guessWord.length() && word.equalsIgnoreCase(guessWord)){
		this.tof = "word";
		return tof;
	}
	
	//if the player guesses a letter inside the word:
	else if(word.length() == 1){
		for (int i=0;i<guessWord.length();i++){
			if(word.charAt(0) == guessWord.charAt(i)){
				this.tof = "alpha";
				return tof;
			}
		}
	}
	return "";
}
}
