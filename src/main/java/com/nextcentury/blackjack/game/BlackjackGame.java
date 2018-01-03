package com.nextcentury.blackjack.game;

import java.util.Scanner;

import com.nextcentury.blackjack.objects.Deck;
import com.nextcentury.blackjack.objects.Player;

/**
 * Runs the blackjack game
 * @author Jonathan Otterbein
 *
 */
public class BlackjackGame {

	private Deck deck;
	private Player player;
	private Player dealer;
	private Scanner scanner;
	private String result;
	public static final int BLACKJACK = 21;
	
	public BlackjackGame(Player player, Player dealer, Deck deck, Scanner scanner) {
		this.deck = deck;
		this.player = player;
		this.dealer = dealer;
		result = "";
		this.scanner = scanner;
	}

	/**
	 * Runs through the game once for the user to play
	 */
	public void playBlackjack() {
		String choice;
		
		System.out.println("Welcome to Blackjack! \n");
		System.out.println("Dealing hands \n");
		deck.shuffle();
		player.setHand(deck.drawHand());
		dealer.setHand(deck.drawHand());
		
		
		if(checkForBlackjack(player) && checkForBlackjack(dealer)) {
			System.out.println(showHands());
			System.out.println("Both player's have blackjack! \n");
		}
		else if(checkForBlackjack(player)) {
			System.out.println(showHands());
			System.out.println("Player has blackjack! You win! \n");
		}
		else if(checkForBlackjack(dealer)) {
			System.out.println(showHands());
			System.out.println("Dealer has blackjack! Dealer wins! \n");
		}
		else{
			System.out.println(showInitinalHand());
			while(player.getHandVal() < 21) {
				System.out.println("Player's turn. Pick to hit or stand \n");
				choice = scanner.nextLine().toUpperCase();
				if(choice.equals("STAND")) {
					System.out.println("Player stands \n");
					break;
				}
				else if(choice.equals("HIT")) {
					System.out.println("Player hits \n");
					player.addCard(deck.drawCard());
					System.out.println(showInitinalHand());
				}
				else {
					System.out.println("Invalid input \n");
				}
			}
			while(dealer.getHandVal() < 17) {
				System.out.println("Dealer hits \n");
				dealer.addCard(deck.drawCard());
				System.out.println(showHands());
			}
			System.out.println(showHands());
		}
		checkWinner();
		if(result.equals("TIE")) {
			System.out.println("The result is a tie! \n");
		}
		else {
			System.out.println("The winner is the " + result + "!\n");
		}
	}
	
	/**
	 * Creates a string that shows both players hands
	 * @return String of hands
	 */
	public String showHands() {
		String string = "";
		string += "Player's hand: " + player.showHand() + "\n";
		string += "Dealer's hand: " + dealer.showHand();
		return string;
	}
	
	/**
	 * Shows the opening hand with the dealer's second card hidden
	 * @return String of opening hand
	 */
	public String showInitinalHand() {
		String string = "";
		string += "Player's hand: " + player.showHand() + "\n";
		string += "Dealer's hand: " + dealer.showDealerHand() + "\n";
		return string;
	}
	
	/**
	 * Checks the player's hand if they have Blackjack
	 * @param player
	 * @return Boolean if they have blackjack
	 */
	public boolean checkForBlackjack(Player player) {
		if(player.getHandVal() == BLACKJACK) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks to see what the result of the game is
	 */
	private void checkWinner() {
		if(player.getHandVal() == BLACKJACK && dealer.getHandVal() == BLACKJACK) {
			System.out.println("Both players have Blackjack!\n");
			result = "TIE";
		}
		else if (player.getHandVal() == BLACKJACK) {
			System.out.println("The Player has Blackjack!\n");
			result = "PLAYER";
		}
		else if (dealer.getHandVal() == BLACKJACK) {
			System.out.println("The Dealer has Blackjack!\n");
			result = "DEALER";
		}
		else if(player.getHandVal() > BLACKJACK && dealer.getHandVal() > BLACKJACK) {
			System.out.println("Both players bust!\n");
			result = "DEALER";
		}
		else if(player.getHandVal() > BLACKJACK) {
			System.out.println("The Player has busted!\n");
			result = "DEALER";
		}
		else if(dealer.getHandVal() > BLACKJACK) {
			System.out.println("The Dealer has busted!\n");
			result = "PLAYER";
		}
		else if(player.getHandVal() > dealer.getHandVal()) {
			System.out.println("The Player has a higher score!\n");
			result = "PLAYER";
		}
		else if(player.getHandVal() < dealer.getHandVal()){
			System.out.println("The dealer has a higher score!\n");
			result = "DEALER";
		}
		else {
			System.out.println("Both players have the same score!\n");
			result = "TIE";
		}
	}

	/**
	 * Sets player
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Sets the dealer
	 * @param dealer
	 */
	public void setDealer(Player dealer) {
		this.dealer = dealer;
	}

	/**
	 * Returns the result
	 * @return result
	 */
	public String getResult() {
		return result;
	}
	
}
