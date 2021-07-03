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
		String playerType, userChoicePennies, pennyCountOutput, userFlip, computerFlip = "T";
		int playerPennies, compPennies, minStart = 1, maxStart = 20;
		
		
		//Allow player to choose the starting number of pennies
		userChoicePennies = JOptionPane.showInputDialog("How many pennies would you like to start with? \nChoose a number between "+minStart 
				                                         + " and " + maxStart);
		//Parse userChoicePennies as a starting integer for both the player and the computer
		playerPennies = Integer.parseInt(userChoicePennies);
		compPennies = Integer.parseInt(userChoicePennies);
		
		
		//Allow player to choose how they will play "Odd or even"
		playerType = JOptionPane.showInputDialog("Which would you like to play as? \n Odd (O) or Even (E)?");
		
		//Display the user's choice
		pennyCountOutput = "You have " + playerPennies + " pennies. "
						+ "\nCompueter has " + compPennies + " pennies.";
		JOptionPane.showMessageDialog(null,pennyCountOutput );
		


		// TODO Auto-generated method stub

	}

}
