package Game;
import java.util.*;
import java.io.*;
import java.util.ArrayList;
public class gameHangman {
/*
 * Tejasvi & Purusoth
 * June 17, 2016
 */
	public static void main(String[] args) throws IOException{

//used to check store word and letters the user has entered
ArrayList<String> usedLetter = new ArrayList<String>();


/*
 * name String - used to get player name
 * category String - used to get which category the user wants to play under
 * guessWord String - used to store the word that the player is trying to guess
 * word String - used to get the players guess
 */
String name ="";
String category = "";
String guessWord = "";
String word = "";
				

//used to store different words that the user can guess under the "Car Brands" and "Body Parts" category
String [] cars = {"BMW", "Buggati", "Aston Martin", "Lamborghini", "Ferrari", "Porsche", "Mercedes-Benz", "Bently", "Rolls Royce"};
String [] body = {"Brain", "Fingers", "Nails", "Arms", "Legs", "Face", "Spine", "Feet", "Eyes"};


Scanner input = new Scanner(System.in);

//user inputs there name. if they don't input anything, the game will continue to ask them to input their name
while(name.length()==0){
System.out.println("What is your name?");
name = input.nextLine();
System.out.println("");
}
name = name.substring(0,1).toUpperCase() + name.substring(1,name.length());


//method call that outputs the instructions of the game
Instructions(name);
System.out.println("");


System.out.println("What Category would you like to choose(Car Brands, Body Parts, or Own Word)?");
category = input.nextLine();
System.out.println("");


//the word the user is trying to guess is randomly picked from 9 different options
int x= (int)(Math.random()*8);
if(category.equalsIgnoreCase("car brands")){		
	guessWord = cars[x].toLowerCase();
}
else if(category.equalsIgnoreCase("body parts")){
	guessWord = body[x].toLowerCase();
}
else if(category.equalsIgnoreCase("own word")){
	//if the player wants to enter their own word, nothing will be picked from the options above
	System.out.println("What word would you or your friends like to guess?");
	guessWord = input.nextLine();
	guessWord = guessWord.toLowerCase();
	space();
}


Hangman man = new Hangman(name);
rightHangman right = new rightHangman();
drawHangman wrong = new drawHangman();
dashesHangman dashes = new dashesHangman();


//used to output dashes to let the player know how long the word is and how many letters they've guessed so far
String [] dash = new String[guessWord.length()];
dashes.first(dash);
//used to check if player has won the game through guessing the letters in the word
boolean done = charWin(dash);


while (man.Check(guessWord,word) != "word" || wrong.getWrong()<6 || done != true){
	
	//game outputs 3 different statements depending on which category the player chose
	if(category.equalsIgnoreCase("car brands")){
	System.out.println("What car brand do you think it is (guess with a letter or guess the word)?");
 	word = input.nextLine();
 	word = word.toLowerCase();
	}
	
	else if(category.equalsIgnoreCase("body parts")){
		System.out.println("What body part do you think it is (guess with a letter or guess the word)?");
	 	word = input.nextLine();
	 	word = word.toLowerCase();
	}
	
	else if(category.equalsIgnoreCase("own word")){
		System.out.println("What word do you think it is (guess with a letter or guess the word)?");
	 	word = input.nextLine();
	 	word = word.toLowerCase();
	}
 	
	
	//if the player enters the same word or letter more than once, they will have to guess again.
	if(usedLetter.contains(word)){
		System.out.println("You have already guessed that, please try another guess.");
		System.out.println("");
	}
		
	else{
		//if it's the players first time using a letter or word, the game store that word in an array list
		usedLetter.add(word);
	
	
	//if the player guesses using a word and it is the same as the word they're trying to guess, they win the game
 	if(man.Check(guessWord, word) == "word"){
 		space();
 		wrong.Draw();
 		right.setRight();
 		System.out.println(man.getName()+", you have made "+right.getRight()+" correct guesses and "+wrong.getWrong()+" incorrect guesses.");
 		System.out.println("");
 		System.out.println("The word is : "+guessWord);
 		break;
 	}
 	
 	//if the player guesses using a letter and that letter is inside the word they're trying to guess, the amount of correct guesses they have increases by 1
 	else if(man.Check(guessWord, word) == "alpha"){
 		space();
	 	wrong.Draw();
	 	right.setRight();
	 	System.out.println(man.getName()+", you have made "+right.getRight()+" correct guesses and "+wrong.getWrong()+" incorrect guesses.");
	 	System.out.println("");
	 	//game outputs the dashes and the letter that thy've guesses correctly
	 	dashes.dash(guessWord, word, dash);
	 	done = charWin(dash);
	 	//they win the game if:
	 	if(done == true){
	 		break;
	 	}
 	}
 	
 	//if the players guess is incorrect, the game outputs the hangman with another body part and the amount of incorrect guesses will increase by 1
 	else{
 		space();
	 	wrong.setWrong();
	 	wrong.Draw();
	 	System.out.println(man.getName()+", you have made "+right.getRight()+" correct guesses and "+wrong.getWrong()+" incorrect guesses.");
	 	System.out.println("");
	 	dashes.dash(guessWord, word, dash);
	 	//they lose if:
	 	if(wrong.getWrong()==6){
	 		break;
	 	}
 	}
	}
}

input.close();
done = charWin(dash);


//if the user wins the game, the game will output a winning statement and will write a receipt to and external file
if (man.Check(guessWord,word) == "word" || done == true){
	win(man.getName());
	Receipt(right.getRight(), wrong.getWrong(), man.getName());
		
}

//if the user loses the game, the game will output a losing statement and will write a receipt to and external file
else if(man.Check(guessWord,word) != "word" && wrong.getWrong()==6 && done != true ){
	System.out.println("The word is : "+guessWord);
	loss(man.getName());
	Receipt(right.getRight(), wrong.getWrong(), man.getName());
}
	}
	

/**
 * space
 * prints blanks spaces to make the game look cleaner
 */
public static void space(){
	for (int i=0;i<55;i++){
		System.out.println("");
	}
}


/**
 * charWin
 * @param dash
 * @return true or false
 * checks if all the letters in the word have been guessed.
 */
public static boolean charWin(String [] dash){
	if(Arrays.asList(dash).contains("_")){
		return false;
	}
	else{
		return true;
	}
}


/**
 * win
 * @param name
 * returns a winning statement if the player was able to guess the word
 */
public static void win (String name){
	System.out.println("Congratulations "+name+", You won!");
}


/**
 * loss
 * @param name
 * returns a losing statement if the player wasn't able to guess the word
 */
public static void loss (String name){
	System.out.println("Sorry "+name+", You lost.");
}


/**
 * Instructions
 * @param name
 * @throws IOException
 * Retrieves instructions from external file.
 */
public static void Instructions (String name)throws IOException{
	String line;
	System.out.println("Hello, "+name+". Welcome to Hangman.");
	System.out.println("");
	
	Scanner in = new Scanner (new File ("Instructions.txt"));
	while (in.hasNextLine()){
		       line=in.nextLine();
		       System.out.println(line);
		   }
		   in.close();  
}

/**
 * Receipt
 * @param right
 * @param wrong
 * @param name
 * @throws IOException
 * Prints end statement to another file for player to refer too.
 */
public static void Receipt (int right, int wrong, String name)throws IOException{
	PrintWriter p = new PrintWriter ("Receipt.txt");
		
	p.println("Thank you for playing Hangman, "+name);
	p.println("You got "+right+" correct guesses, and "+wrong+" inccorect guesses.");
	 
	p.close();
}
}
