package MatchingPennies;

import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 * 
 */

/**
 * @author Dave.Lake
 *
 */
public class MatchingPennies {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Declare Variables
		int [] startPennies = new int [20];
		char playerType = 'a', playerFlip = 0 , compFlip = 'T';
		String playerTypeChoice, userChoicePennies, playerFlipChoice,playerName = null,compName=null;
		char []flipOptions= {'H', 'T'}, playerTypes = {'E','O'};
		String pennyCountOutput, flipChoiceOutput;
		int counter, arrayStart, search = 0, playerPennies =0, compPennies = 0, turnCount, minStart = 1, maxStart = 20;
		String winMessage = "You won this round", loseMessage = "You lost this round";
		String wonGame, gameOver, invalidMessage;
		
		Arrays.sort(flipOptions);
		Arrays.sort(playerTypes);
		
		// Populating an array for numbers which can chosen as the starting coin count
		arrayStart = minStart-1;
		for (counter = 0; counter < maxStart; counter++) {
			startPennies[counter]=arrayStart;
			arrayStart ++;
		}
		// Loop for input validation that entry is both an integer and between the minimum and maximum value for Starting Pennies
		while (search <= 0){
			userChoicePennies = JOptionPane.showInputDialog("How many pennies would you like to start with? \nChoose a number between "
					+minStart + " and " + maxStart +".");
			//Parse userChoicePennies as a starting integer for both the player and the computer and throws exception if not integer
			try {
				playerPennies = Integer.parseInt(userChoicePennies);
				search = Arrays.binarySearch(startPennies, playerPennies);
				compPennies = Integer.parseInt(userChoicePennies);
				if(search <= 0) {
					invalidMessage = "Invalid Entry!!! \n"+ userChoicePennies +" is not a number between "+minStart +" and " + maxStart +".";
					JOptionPane.showMessageDialog(null, invalidMessage,"Invalid Entry !!!", JOptionPane.ERROR_MESSAGE);
					}
				}
			catch (NumberFormatException e) { 
				invalidMessage = "Invalid Entry!!! \n"+ userChoicePennies +" is not a number between "+minStart +" and " + maxStart +".";
				JOptionPane.showMessageDialog(null, invalidMessage,"Invalid Entry !!!", JOptionPane.ERROR_MESSAGE);
				search = 0;
			}
		}
		//Initialize search for loop to work
		search = 3;
		//Allows the player to choose how they will play "Odd or even" and sets name variables used in the rest of the program
		while (search != 0 && search != 1) {
			try {
			playerTypeChoice = JOptionPane.showInputDialog("Which would you like to play as? \n [O]dd or [E]ven?");
				playerType = Character.toUpperCase(playerTypeChoice.charAt(0));
				search = Arrays.binarySearch(playerTypes, playerType);
				if (playerType == 'O' || playerType == 'o') {
					playerType = 'O';
					playerName = "Odd";
					compName = "Even";		}
				else
					if (playerType == 'E' || playerType == 'e') {
						playerType= 'E';
						playerName ="Even";
						compName = "Odd";
					}
					else 
						if(search <= 0) {
							invalidMessage = "Invalid Entry!!! \n" +playerType + " is an invaild option. "
									+ "\nPlease try again.";
							JOptionPane.showMessageDialog(null, invalidMessage,"Invalid Entry !!!", JOptionPane.ERROR_MESSAGE);
						}
			
				}
			catch (StringIndexOutOfBoundsException e) { 
				invalidMessage = "Invalid Entry!!! \nSelect O for Odd or E for Even";
				JOptionPane.showMessageDialog(null, invalidMessage,"Invalid Entry !!!", JOptionPane.ERROR_MESSAGE);
				search = 3;
					}
				}
		//Make the initial turn count equal to PlayerPennies since both player and computer have the same number of pennies
		turnCount = playerPennies;
		
		//Loop through turn counts while these are more than zero and contains general game logic.
		search = -1;
		while (turnCount >0 ) {
			//Loop providing input validation for flips using search of an array.
			while (search < 0) {
				pennyCountOutput = "Hi " + playerName +" You have " + playerPennies + " pennies. "
						+ "\nComputer has " + compPennies + " pennies.";
				playerFlipChoice = JOptionPane.showInputDialog(pennyCountOutput+"\n\nLet's flip penny number " +".\n"
						+ "[H]eads or [T]ails?"); 
				playerFlip = Character.toUpperCase(playerFlipChoice.charAt(0));
				search = Arrays.binarySearch(flipOptions, playerFlip);
				if(search < 0) {
					invalidMessage = "Invalid Entry!!! \n" +playerFlipChoice + " is an invaild option. "
							+ "\nPlease try again.";
					JOptionPane.showMessageDialog(null, invalidMessage,"Invalid Entry !!!", JOptionPane.ERROR_MESSAGE);
					}
			}
			compFlip = flipOptions[(int) (Math.random()*2)];
			
			flipChoiceOutput = "You chose " +playerFlip + ".\nComputer chose " + compFlip + ".";
			JOptionPane.showMessageDialog(null,flipChoiceOutput );
			
			//Logic for determining the winner of the round
			if (playerFlip == compFlip && playerType == 'E') {
				playerPennies++;
				compPennies--;
				JOptionPane.showMessageDialog(null,winMessage );	
				}
			else {
				if (playerFlip != compFlip && playerType == 'O') {
					playerPennies++;
					compPennies--;
					JOptionPane.showMessageDialog(null,winMessage );
					}
			else {
				playerPennies --;
				compPennies++;
				JOptionPane.showMessageDialog(null,loseMessage );
					}
				}
			//Return search to condition so loop can be entered
			search = -1;
				// Logic for setting the remaining turns in the loop by determining the player with the least pennies
				if (playerPennies>compPennies) {
					turnCount= compPennies;
				}
				else {
					turnCount = playerPennies;
				}
				
				}	
		//Logic for determining the winner of the game.
		if (playerPennies == 0) {
			gameOver = "Sorry " + playerName + ". You have no more pennies to play.\n"
					+ compName +" has won the game \nGame Over!!!";
			JOptionPane.showMessageDialog(null, gameOver);
			}
		else {
			wonGame = "WOW " + playerName +"!\n You are really good at this!\n You have won the game!!!";
			JOptionPane.showMessageDialog(null, wonGame);

			}
	}
}