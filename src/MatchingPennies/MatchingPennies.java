package MatchingPennies;

import javax.swing.JOptionPane;

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
		char playerType, compType;
		String playerTypeChoice, userChoicePennies, userFlip, computerFlip = "T";
		String pennyCountOutput, playerTypeOutput = null;
		int playerPennies, compPennies, minStart = 1, maxStart = 20;
		
		
		
		//Allow player to choose the starting number of pennies
		userChoicePennies = JOptionPane.showInputDialog("How many pennies would you like to start with? \nChoose a number between "+minStart 
				                                         + " and " + maxStart);
		//Parse userChoicePennies as a starting integer for both the player and the computer
		playerPennies = Integer.parseInt(userChoicePennies);
		compPennies = Integer.parseInt(userChoicePennies);
		
		
		//Allow player to choose how they will play "Odd or even"
		playerTypeChoice = JOptionPane.showInputDialog("Which would you like to play as? \n Odd (O) or Even (E)?");
		//Parse playerTypeChoice as Char
		playerType = playerTypeChoice.charAt(0);
		
		if (playerType == 'O' || playerType == 'o') {
			compType = 'E';
			playerTypeOutput = "You have chosen to be the Odd player. Computer will be the Even player";
		}
		else
			if (playerType == 'E' || playerType == 'e') {
				compType = 'E';
				playerTypeOutput = "You have chosen to be the Even player. Computer will be the Odd player";
			}
			JOptionPane.showMessageDialog(null,playerType );

		
		JOptionPane.showMessageDialog(null,playerTypeOutput );

		
		//Display the user's choice
		pennyCountOutput = "You have " + playerPennies + " pennies. "
						+ "\nComputer has " + compPennies + " pennies.";
		JOptionPane.showMessageDialog(null,pennyCountOutput );
		


		// TODO Auto-generated method stub

	}

}
