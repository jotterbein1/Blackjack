package com.nextcentury.blackjack.objects;

/**
 * Player class for the player and dealer
 * @author Owner
 *
 */
public class Player {

	private Hand hand;
	
	public Player() {
		hand = new Hand();
	}
	
	/**
	 * Sets hand
	 * @param hand
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	/**
	 * Gets value of hand
	 * @return hand value
	 */
	public int getHandVal() {
		return hand.getTotalVal();
	}
	
	/**
	 * Adds a card to the hand
	 * @param card
	 */
	public void addCard(Card card) {
		hand.addCard(card);
	}
	
	/**
	 * Gets the player's hand
	 * @return the hand
	 */
	public Hand getHand() {
		return hand;
	}
	
	/**
	 * Creates a string of the player's hand
	 * @return string of the hand
	 */
	public String showHand() {
		return hand.showHand();
	}
	
	/**
	 * Shows the dealer's hand upon start of the game
	 * @return String of the hand
	 */
	public String showDealerHand() {
		return hand.showDealerHand();
	}
	
}
