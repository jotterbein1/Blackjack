package com.nextcentury.blackjack.objects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Hand Class
 * @author Owner
 *
 */
public class HandTest {
	
	Hand hand;
	Deck deck;
	
	@Before
	public void setup() {
		hand = new Hand();
		deck = new Deck();
	}
	
	/**
	 * Tests adding cards to the hand and the proper values are added
	 */
	@Test
	public void testAddCard() {
		Card card = deck.drawCard();
		hand.addCard(card);
		assertEquals(hand.getTotalVal(),11);
		assertEquals(hand.getCards().size(), 1);
		card = new Card(Suit.SPADES, Rank.ACE);
		hand.addCard(card);
		assertEquals(hand.getTotalVal(), 12);
		assertEquals(hand.getCards().size(), 2);
		hand.addCard(card);
		assertEquals(hand.getTotalVal(), 13);
		assertEquals(hand.getCards().size(), 3);
		card = new Card(Suit.SPADES, Rank.TEN);
		hand.addCard(card);
		assertEquals(hand.getTotalVal(), 23);	
		assertEquals(hand.getCards().size(), 4);
	}
	
	/**
	 * Tests to see if the string of the hand is correct
	 */
	@Test
	public void testShowHand() {
		String expected = "ACE of SPADES\n";
		hand = new Hand();
		deck = new Deck();
		assertEquals("", hand.showHand());
		hand.addCard(deck.drawCard());
		assertEquals(expected, hand.showHand());
	}
	
}
