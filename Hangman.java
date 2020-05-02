import java.util.Scanner;

public class Hangman {
	
	public static boolean Weareplaying = true;
	public static boolean GuessedPhrase = false;
	
	
	public static void main(String[] args) {

		int CorrectGuesses = 0;
		int IncorrectGuesses = 0;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the number of people playing the game (Please enter 1 or 2)");
		
		// Asks the user to enter 1 or 2 users 
		int numberofusers = keyboard.nextInt();

		// Arrays that hold the letters in the phrase, the incorrect
		// letters guessed, and the correct spaces of the letters in the phrase and the incorrect spaces 
		
		// Array that calls the Find Team method in our Tester File for the team name  
		String[] phrase=HangmanGameTester.FindTeam(numberofusers); 
		
		//CorrectSpaces array that calls the FindCorrectSpaces method for accessing the phrase in the tester file 
		String[] CorrectSpaces=HangmanGameTester.FindCorrectSpaces(phrase); 
		
		// Array that holds the incorrect spaces for each letter the user guesses 
		String[] IncorrectSpaces = { "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_","_", "_" };
		
		
		//Asks the user to guess a letter or the phrase 
		System.out.println("Guess a letter in the phrase! HINT: Major League Baseball Team");

		while (Weareplaying) {

			String GuessedLetter = keyboard.next().toUpperCase();
			// Changes the users Guessed Letter to Upper Case when it prints
			boolean GuessedCorrectly= false;
			// Loop that sets the Guessed Letter equal to the index of the phrase
			for (int i = 0; i < phrase.length; i++) {
				
				if (GuessedLetter.equals(phrase[i])) {
					CorrectSpaces[i] = GuessedLetter; 
					// Sets the Guessed Letter equal to the index of the Correct Spaces array
					GuessedCorrectly = true;
					}
				}
			
				// Sets the incorrect spaces array equal to the index of the incorrect letter inputed by the user
				if (GuessedCorrectly == false) {
					IncorrectSpaces[IncorrectGuesses] = GuessedLetter;
					// Adds one to incorrect Guesses if the user guesses the incorrect letter 
					//and one to correct Guesses if they guess a correct letter
					IncorrectGuesses += 1;
				
					} else {
						CorrectGuesses += 1;
					}
				
				if (CorrectGuesses == 8) {
					// Since there is 8 different letters in our phrase, if the user guesses 8
					// correct letters they win the game
					System.out.println("You have won the game!!");
					//When the boolean We are playing is false, the user wins the game 
					Weareplaying = false;
					} else {
					
					// If the user guesses 10 incorrect letters they lost the game
					if (IncorrectGuesses == 10) {
						System.out.println("GAME OVER!!");
						
						Weareplaying = false;
		
						} else { 
						
						if (CorrectGuesses!= 4) {
							//Once the user has 4 correct guesses they can keep guessing letters
							System.out.println("Keep Guessing Letters");
						}
						
						// Prints the users correct letters after each guess
						System.out.println("\nYour Correct Guesses Are: ");
						
						//String that holds the correct spaces in the array
						for (String s : CorrectSpaces) {
							System.out.print(s);

						}
						System.out.println();
						
						// Prints the users incorrect letters after each guess
						System.out.println("\nYour Incorrect Guesses Are: ");
						
						//String that holds the incorrect spaces in the array
						for (String s : IncorrectSpaces) {
							System.out.print(s);
						}
						System.out.println("\n**********************************************************************");
						}
						
					// Once the user has a total of 4 correct guesses they have the option of guessing the entire phrase
					if (CorrectGuesses >= 4) {
							
						// Creates a string called keep playing that makes Weareplaying false if they 
						// choose to guess the entire phrase
						System.out.println("Do you want to risk it all and guess the phrase?! Please enter YES OR NO \n");

						String keepPlaying = keyboard.next().toUpperCase();
							
						//Creates a string called keep playing and changes the letter to upper case
								
						if (keepPlaying.equals("YES")) {
							// if the user wants to guess the phrase they won't keep playing
							Weareplaying = false;
							// Asks the user to guess the entire phrase 
							System.out.println("Guess the phrase");
								
							String finalGuess = keyboard.next()+ " " + keyboard.next();
							// Creates a string that holds each letter
							String CorrectPhrase ="";
						
							//Enhanced for loop that goes through the entire phrase and adds each letter to the String
							//Converting an array into a String
							
							// Adds each letter from the Array to the phrase when they guess a letter 
							for(String s:phrase) {
								CorrectPhrase += s;
						}
						if (finalGuess.equals(CorrectPhrase)) {
						
							// If the user correctly guesses they phrase they win the game
							System.out.println("CORRECT,You have won the game!!!"); 
					
						} else {
									
							// If the user guesses incorrectly they lose the game
							System.out.println("INCORRECT,You have lost the game");
							}
								
							} else {
							//Allows the user to keep guessing letters until the game ends
							System.out.println("Keep Guessing Letters");
							}						
						}
					}
				
				}
			}
		}
		
					