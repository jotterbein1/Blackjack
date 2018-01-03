package com.nextcentury.blackjack.objects;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Tests for the Card class
 * @author Owner
 *
 */
public class CardTest {

	Card card;
	
	@Before
	public void setup() {
		card = new Card(Suit.CLUBS, Rank.ACE);
	}
	
	/**
	 * Tests if the toString outputs properly
	 */
	@Test
	public void toStringTest() {
		assertEquals("ACE of CLUBS\n", card.toString());
	}
	
	/**
	 * Tests if the right card value is given
	 */
	@Test
	public void getCardValueTest() {
		assertEquals(11, card.getCardValue());
	}
}
