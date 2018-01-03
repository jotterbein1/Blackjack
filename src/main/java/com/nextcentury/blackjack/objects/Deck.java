package com.nextcentury.blackjack.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck;
	private int index;
	
	public Deck() {
		index = 0;
		deck = new ArrayList<Card>();
		Card card;
		for(Suit suit: Suit.values()) {
			for(Rank rank: Rank.values()) {
				card = new Card(suit, rank);
				deck.add(card);
			}
		}
	}
	
	/**
	 * Draws a single card from the deck
	 * @return A card
	 */
	public Card drawCard() {
		Card card = deck.get(index);
		index++;
		return card;
	}
	
	/**
	 * Shuffles the deck randomly and resets index
	 */
	public void shuffle() {
		index = 0;
		Collections.shuffle(deck);
	}
	
	/**
	 * Draws two cards into a hand
	 * @return The hand
	 */
	public Hand drawHand() {
		Hand hand = new Hand();
		hand.addCard(drawCard());
		hand.addCard(drawCard());
		return hand;
	}
}
