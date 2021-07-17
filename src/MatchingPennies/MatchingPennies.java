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
		char playerType, playerFlip, compFlip = 'T', compType;
		String playerTypeChoice, userChoicePennies, playerFlipChoice,playerName = null,compName=null, computerFlip = "T" ;
		char []computerFlips= {'H', 'T'};
		String pennyCountOutput, playerTypeOutput = null, flipChoiceOutput;
		int counter, search = 0, playerPennies =0, compPennies = 0, compFlipChoice, turnCount, minStart = 1, maxStart = 20;
		String winMessage = "You won this round", loseMessage = "You lost this round";
		String wonGame, gameOver, output;
		
		for (counter = 0; counter < maxStart; counter++) {
			startPennies[counter]=minStart;
			minStart ++;
		}
		
		minStart = 1;
		while (search <= 0){
			userChoicePennies = JOptionPane.showInputDialog("How many pennies would you like to start with? \nChoose a number between "
					+minStart + " and " + maxStart);
			//Parse userChoicePennies as a starting integer for both the player and the computer
			
			playerPennies = Integer.parseInt(userChoicePennies);
			search = Arrays.binarySearch(startPennies, playerPennies);
			if(search > 0) {
				output = "key was found " + search;
			} else {
				output = "key was not found " + search;
			}
			JOptionPane.showMessageDialog(null, output);

			compPennies = Integer.parseInt(userChoicePennies);
		}
		
		
		
		
		
		
		//Allows the player to choose how they will play "Odd or even" and sets name variables used in the rest of the program
		playerTypeChoice = JOptionPane.showInputDialog("Which would you like to play as? \n [O]dd or [E]ven?");
		playerType = playerTypeChoice.charAt(0);
		if (playerType == 'O' || playerType == 'o') {
			compType = 'E';
			playerName = "Odd";
			compName = "Even";		}
		else
			if (playerType == 'E' || playerType == 'e') {
				compType = 'O';
				playerName ="Even";
				compName = "Odd";
			}

		//Make the initial turn count equal to PlayerPennies since both player and computer have the same number of pennies
		turnCount = playerPennies;
		
		//Loop through turn counts while these are more than zero and contains general game logic.
		while (turnCount >0 ) {
			pennyCountOutput = "Turn count is " + turnCount+ "\nHi " + playerName +" You have " + playerPennies + " pennies. "
					+ "\nComputer has " + compPennies + " pennies.";
			playerFlipChoice = JOptionPane.showInputDialog(pennyCountOutput+"\n\nLet's flip penny number " +".\n"
					+ "H for Heads or T for Tails?"); 
			playerFlip = playerFlipChoice.charAt(0);
			
			//Randomly chooses the computers flip from an Array containing 'H' and 'T'
			compFlipChoice = (int) (Math.random()*3);
			compFlip = computerFlips[(int) (Math.random()*2)];
			
			
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
			}}
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
		}}
			
	




