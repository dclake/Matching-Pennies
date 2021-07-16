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
		char playerType, playerFlip, compFlip = 'T', compType;
		String playerTypeChoice, userChoicePennies, playerFlipChoice, computerFlip = "T";
		char []computerFlips= {'H', 'T'};
		String pennyCountOutput, playerTypeOutput = null, flipChoiceOutput;
		int playerPennies, compPennies, compFlipChoice, turnCount, minStart = 1, maxStart = 20;
		
		
		userChoicePennies = JOptionPane.showInputDialog("How many pennies would you like to start with? \nChoose a number between "
														+minStart + " and " + maxStart);
		//Parse userChoicePennies as a starting integer for both the player and the computer
		playerPennies = Integer.parseInt(userChoicePennies);
		compPennies = Integer.parseInt(userChoicePennies);
		
		JOptionPane.showMessageDialog(null, computerFlips[0]);
		
		//Allow player to choose how they will play "Odd or even"
		playerTypeChoice = JOptionPane.showInputDialog("Which would you like to play as? \n Odd (O) or Even (E)?");
		
		playerType = playerTypeChoice.charAt(0);//Parse playerTypeChoice as Char
		
		if (playerType == 'O' || playerType == 'o') {
			compType = 'E';
			playerTypeOutput = "You have chosen to be the Odd player. Computer will be the Even player";
		}
		else
			if (playerType == 'E' || playerType == 'e') {
				compType = 'E';
				playerTypeOutput = "You have chosen to be the Even player. Computer will be the Odd player";
			}
			//JOptionPane.showMessageDialog(null,playerType );

		//Make the initial turn count equal to PlayerPennies since both player and computer have the same number of pennies
		turnCount = playerPennies;
		
		pennyCountOutput = "You have " + playerPennies + " pennies. \nComputer has " + compPennies + " pennies.";
		
		while (turnCount >0) {
			JOptionPane.showMessageDialog(null,pennyCountOutput );
			playerFlipChoice = JOptionPane.showInputDialog("Turn count ="+turnCount+"Let's flip penny number " + turnCount +".\n"
					+ "H for Heads or T for Tails?"); 
			playerFlip = playerFlipChoice.charAt(0); //Parse playerFlipChoice as Char
			compFlipChoice = (int) (Math.random()*3);
			if (compFlipChoice == 1) {
				compFlip = 'H';
			}
			else if (compFlipChoice ==2){
				compFlip = 'T';
			}
			flipChoiceOutput = "You chose " +playerFlip + ".\nComputer chose " + compFlip + ".";
			JOptionPane.showMessageDialog(null,flipChoiceOutput );
			if (playerFlip == compFlip) {
				if (playerType == 'E') {
					playerPennies++;
					compPennies--;
				}
				else {
					playerPennies --;
					compPennies++;
				}
			}
			else {
				if (playerType == 'O') {
					playerPennies++;
					compPennies--;
				}
			else {
				playerPennies --;
				compPennies++;
			}
		}

			if (compPennies < playerPennies) {
				turnCount = compPennies;
			}
			else {
				turnCount = playerPennies;
			}
		
		//Display the user's choice
		
		JOptionPane.showMessageDialog(null,playerTypeOutput );



		// TODO Auto-generated method stub

	}

}}
