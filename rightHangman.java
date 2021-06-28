package Game;
/*
 * Tejasvi & Purusoth
 * June 17, 2016
 */
public class rightHangman{

private int rightGuess=0;


public rightHangman(){

}


/**
 * setRight
 * used to increase the amount of right guesses the user got
 */
public void setRight(){
		this.rightGuess++;
}


/**
 * getRight
 * @return rightGuess
 * used to return the amount of right guesses to the client class
 */
public int getRight(){
	return this.rightGuess;
}
}
