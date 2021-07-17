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
		String playerTypeChoice, userChoicePennies, playerFlipChoice,playerName = null, computerFlip = "T" ;
		char []computerFlips= {'H', 'T'};
		String pennyCountOutput, playerTypeOutput = null, flipChoiceOutput;
		int playerPennies, compPennies, compFlipChoice, turnCount, minStart = 1, maxStart = 20;
		String winMessage = "You won this round", loseMessage = "You lost this round";
		String wonGame = "You have won the game!!!", gameOver = "You have no more pennies to play. \n Game Over!!!";
		
		
		userChoicePennies = JOptionPane.showInputDialog("How many pennies would you like to start with? \nChoose a number between "
														+minStart + " and " + maxStart);
		
		
		//Parse userChoicePennies as a starting integer for both the player and the computer
		playerPennies = Integer.parseInt(userChoicePennies);
		compPennies = Integer.parseInt(userChoicePennies);
		
		
		//Allow player to choose how they will play "Odd or even"
		playerTypeChoice = JOptionPane.showInputDialog("Which would you like to play as? \n [O]dd or [E]ven?");
		
		playerType = playerTypeChoice.charAt(0);//Parse playerTypeChoice as Char
		
		if (playerType == 'O' || playerType == 'o') {
			compType = 'E';
			playerName = "Odd";
			//playerTypeOutput = "You have chosen to be the Odd player. Computer will be the Even player";
		}
		else
			if (playerType == 'E' || playerType == 'e') {
				compType = 'O';
				playerName ="Even";
				//playerTypeOutput = "You have chosen to be the Even player. Computer will be the Odd player";
			}

		//Make the initial turn count equal to PlayerPennies since both player and computer have the same number of pennies
		turnCount = playerPennies;
		
		
		
		while (turnCount >0 ) {
			pennyCountOutput = "Turn count is " + turnCount+ "\nHi " + playerName +" You have " + playerPennies + " pennies. "
					+ "\nComputer has " + compPennies + " pennies.";
			playerFlipChoice = JOptionPane.showInputDialog(pennyCountOutput+"\n\nLet's flip penny number " +".\n"
					+ "H for Heads or T for Tails?"); 
			playerFlip = playerFlipChoice.charAt(0); //Parse playerFlipChoice as Char
			compFlipChoice = (int) (Math.random()*3);
			compFlip = computerFlips[(int) (Math.random()*2)];
			flipChoiceOutput = "You chose " +playerFlip + ".\nComputer chose " + compFlip + ".";
			JOptionPane.showMessageDialog(null,flipChoiceOutput );
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
			}}
				if (playerPennies>compPennies) {
					turnCount= compPennies;
				}
				else {
					turnCount = playerPennies;
				}
				
				}
		
		if (playerPennies == 0) {
			JOptionPane.showMessageDialog(null, gameOver);
		}
		else {
			JOptionPane.showMessageDialog(null, wonGame);

		}
		}}
			
	




