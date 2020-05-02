import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class HangmanGameTester {

	// Method that finds the team name that will be the phrase in the Hangman Game
	public static String[] FindTeam(int numplayers) {
	
	// Using the map import function to hold the index of each letter in the MasterList	
	Map <Integer,String[]> Masterlist= new HashMap <Integer,String[]>();
	
	// Object that generates a random number for the phrase
	Random RandomNumber=new Random();
	// Generates a random number between 1 and 5 for one of the playoff teams
	int Team=RandomNumber.nextInt(5); 
	
	// Splits up the options for the phrases based on how many users are playing the game 
	if(numplayers>1) Team+=5;                                                 
	
	// String arrays for all the 2017 MLB play off teams
	String [] New_York={"N","E","W","Y", "O", "R", "K", " ", "Y", "A", "N", "K", "E", "E", "S"};
	
	String [] Minnesota={"M", "I", "N", "N", "E", "S", "O", "T", "A", " ", "T", "W", "I", "N", "S"};
	
	String [] Arizona= {"A", "R", "I", "Z", "O", "N", "A"," ", "D", "I", "A","M", "O", "N", "D", "B", "A", "C", "K", "S"};
	
	String [] Colorado= {"C", "O", "L", "O", "R", "A", "D", "O", " ", "R", "O", "C", "K", "I", "E", "S"};
	
	String [] Los_Angeles= {"L", "O", "S","A", "N", "G", "E", "L", "E", "S"," ", "D", "O", "D", "G", "E", "R", "S"};
	
	String [] Boston= {"B", "O", "S", "T", "O", "N"," ","R", "E", "D","S", "O", "X"};
	
	String [] Cleveland= {"C", "L", "E", "V", "E", "L", "A", "N", "D", " ","I", "N", "D", "I", "A", "N", "S"};
	
	String [] Chicago= {"C", "H", "I", "C", "A", "G", "O"," ","C", "U", "B","S"};
	
	String [] Houston = { "H", "O", "U", "S", "T", "O", "N", " ", "A", "S", "T", "R", "O", "S" };
	
	String [] Washington= {"W", "A", "S", "H", "I", "N", "G", "T", "O", "N"," ","N", "A", "T", "I", "O", "N", "A", "L", "S"};
	
	// Adding all the arrays to the master list based on there index and city/name
	Masterlist.put(0,Houston);
	
	Masterlist.put(1,Chicago);
	
	Masterlist.put(2,Minnesota);
	
	Masterlist.put(3,Cleveland);

	Masterlist.put(4,Colorado);
	
	Masterlist.put(5,Los_Angeles);
	
	Masterlist.put(6,Boston);
	
	Masterlist.put(7,Arizona);

	Masterlist.put(8,Washington);
	
	Masterlist.put(9,New_York);

	// The method returns the random team in the Master List (Team 0-9)
	return(Masterlist.get(Team));
	}
	
	// String method that passes through the index of the team and the team name 
	public static String [] FindCorrectSpaces(String[] Team) {
		// Creates a new object called CorrectGuesses that holds the length of the random team
		String[] CorrectGuesses= new String[Team.length];
			
			for (int i =0; i<Team.length; i++) {
				// Sets all the strings in each array 
				if(Team[i].equals(" ")) {
				//Sets the correct guesses equal to the String array with a space between the two words 
					CorrectGuesses[i]=" ";
				
					} else {
					// Sets Correct Guesses equal to the string array with a underscore between each letter
					CorrectGuesses[i]="_";
				}
				
			}
		//Returns the correct guesses object outside of the for loop
			return(CorrectGuesses);
	}
}
	
	
	

