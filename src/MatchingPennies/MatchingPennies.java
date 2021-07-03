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
		String playerType, userChoicePennies, userChoiceOutput;
		int startingPennies;
		
		
		//Allow player to choose the starting number of pennies
		userChoicePennies = JOptionPane.showInputDialog("How many pennies would you like to start with? \n Choose a number between 1 and 20");
		//Parse userChoicePennies as an integer
		startingPennies = Integer.parseInt(userChoicePennies);
		
		
		playerType = JOptionPane.showInputDialog("Which would you like to play as? \n Odd (O) or Even (E)?");
		
		//Display the user's choice
		userChoiceOutput = "You have chosen to start with " + startingPennies + " pennies. \n Each player will be given " + startingPennies + " pennies.";
		JOptionPane.showMessageDialog(null,userChoiceOutput );


		// TODO Auto-generated method stub

	}

}
