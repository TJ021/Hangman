package Game;

public class dashesHangman {
/*
 * Tejasvi & Purusoth
 * June 17, 2016
 */
public dashesHangman(){

}


/**
 * first
 * @param dash
 * prints a certain amount of dashes that correspond to the length of the word the user is trying to guess
 */
public void first(String [] dash){
	for(int i=0;i<dash.length;i++){
		dash[i] = "_";
		System.out.print(dash[i]+" ");
	}
	System.out.println("");
}


/**
 * dash
 * @param guessWord
 * @param word
 * @param dash
 * replaces the dashes with letters entered by the player
 */
public void dash(String guessWord, String word, String [] dash){
	//the word the user entered must be 1 letter long
	if(word.length() == 1){
	for (int i=0;i<dash.length;i++){
		//if the letter entered by the user is contained within the word they're trying to guess, dash gets replaced with the letter
		if(word.charAt(0) == guessWord.charAt(i)){
			dash[i] = word;
			System.out.print(dash[i]+" ");
		}
		else{
			System.out.print(dash[i]+" ");
		}
		}
	}
	//if the word the user entered isn't 1 letter long the program outputs the dashes without any change
	else {
		for (int i=0;i<dash.length;i++){
			System.out.print(dash[i]+" ");
		}
	}
	System.out.println(" ");
}
}
