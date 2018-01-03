package com.nextcentury.blackjack.objects;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private List<Card> hand;
	private int totalVal;
	
	public Hand() {
		hand = new ArrayList<Card>();
		totalVal = 0;
	}
	
	/**
	 * Adds a card to the hand and adds its value to the total
	 * @param card
	 */
	public void addCard(Card card) {
		hand.add(card);
		if(card.getRank() == Rank.ACE && (totalVal + 11) > 21) {
			totalVal++;
		}
		else {
			totalVal += card.getCardValue();
		}
	}
	
	/**
	 * Returns the total value of the hand
	 * @return totalVal
	 */
	public int getTotalVal() {
		return totalVal;
	}
	
	/**
	 * Creates a string that shows all cards in the hand
	 * @return string of the hand
	 */
	public String showHand() {
		String string = "";
		for(int i = 0; i < hand.size(); i++) {
			string += hand.get(i).toString();
		}
		return string;
	}
	
	/**
	 * Shows the dealer's hand where one card is hidden
	 * @return String of the dealer's hand
	 */
	public String showDealerHand() {
		return hand.get(0).toString() + "Hidden Card";
	}
	
	/**
	 * Returns the cards in the hand
	 * @return list of cards
	 */
	public List<Card> getCards() {
		return hand;
	}
}
