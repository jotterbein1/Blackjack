package com.nextcentury.blackjack.objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the deck class
 * @author Owner
 *
 */
public class DeckTests {

	Deck deck;
	
	@Before
	public void setup() {
		deck = new Deck();
	}
	
	/**
	 * Tests if a card is correctly drawn
	 */
	@Test
	public void testDrawCard() {
		Card card = deck.drawCard();
		assertNotNull(card);
	}
	
	/**
	 * Tests if shuffling the deck works
	 */
	@Test
	public void testShuffle() {
		Deck test = new Deck();
		deck.shuffle();
		assertNotEquals(deck.drawCard(), test.drawCard());
	}
	
	/**
	 * Tests drawing a hand of two cards
	 */
	@Test
	public void testDrawHand() {
		deck.shuffle();
		Hand hand = deck.drawHand();
		assertEquals(hand.getCards().size(), 2);
	}
	
	
}
