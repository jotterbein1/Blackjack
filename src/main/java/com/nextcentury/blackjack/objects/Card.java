package com.nextcentury.blackjack.objects;

/**
 * Card class
 * @author Owner
 *
 */
public class Card {

	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	/**
	 * Gets the card rank
	 * @return rank
	 */
	public Rank getRank() {
		return rank;
	}
	
	/**
	 * Gets the value of card from rank
	 * @return card value
	 */
	public int getCardValue() {
		return rank.getVal();
	}
	
	/**
	 * Returns a string for the card
	 */
	public String toString() {
		return rank + " of " + suit + "\n";
	}
	
}
