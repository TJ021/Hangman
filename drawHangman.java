package Game;
/*
 * Tejasvi & Purusoth
 * June 17, 2016
 */
public class drawHangman {

private int wrongGuess=0;


public drawHangman(){
	
}


/**
 * setWrong
 * used to increase the amount of wrong guesses the user got
 */
public void setWrong(){
	this.wrongGuess++;
}


/**
 * getWrong
 * @return wrongGuess
 * used to return the amount of wrong guesses to the client class
 */
public int getWrong(){
	return this.wrongGuess;
}


/**
 * Draw
 * draws "hangman" based on how many wrong guesses the user enetered
 */
public void Draw(){

	if(this.wrongGuess==1){
		System.out.println("     *****");
		System.out.println("   **     **");
		System.out.println("  *  *   *  *");
		System.out.println(" *           *");
		System.out.println("  *   ***   *");
		System.out.println("   **     **");
		System.out.println("     *****");
	}
	else if(this.wrongGuess==2){
		System.out.println("     *****");
		System.out.println("   **     **");
		System.out.println("  *  *   *  *");
		System.out.println(" *           *");
		System.out.println("  *   ***   *");
		System.out.println("   **     **");
		System.out.println("     *****");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");

	}
	else if(this.wrongGuess==3){
		System.out.println("     *****");
		System.out.println("   **     **");
		System.out.println("  *  *   *  *");
		System.out.println(" *           *");
		System.out.println("  *   ***   *");
		System.out.println("   **     **");
		System.out.println("     *****");
		System.out.println("       *");
		System.out.println("********");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
	
	}
	else if(this.wrongGuess==4){
		System.out.println("     *****");
		System.out.println("   **     **");
		System.out.println("  *  *   *  *");
		System.out.println(" *           *");
		System.out.println("  *   ***   *");
		System.out.println("   **     **");
		System.out.println("     *****");
		System.out.println("       *");
		System.out.println("***************");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
	}
	else if(this.wrongGuess==5){
		System.out.println("     *****");
		System.out.println("   **     **");
		System.out.println("  *  *   *  *");
		System.out.println(" *           *");
		System.out.println("  *   ***   *");
		System.out.println("   **     **");
		System.out.println("     *****");
		System.out.println("       *");
		System.out.println("***************");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("      *");
		System.out.println("     *");
		System.out.println("    *");
		System.out.println("   *");
	}
	else if (this.wrongGuess==6){
		System.out.println("     *****");
		System.out.println("   **     **");
		System.out.println("  *  *   *  *");
		System.out.println(" *           *");
		System.out.println("  *   ***   *");
		System.out.println("   **     **");
		System.out.println("     *****");
		System.out.println("       *");
		System.out.println("***************");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("       *");
		System.out.println("      * *");
		System.out.println("     *   *");
		System.out.println("    *     *");
		System.out.println("   *       *");
	}
}
}
