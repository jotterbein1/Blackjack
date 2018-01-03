package com.nextcentury.blackjack.objects;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Player class
 * @author Owner
 *
 */
public class PlayerTest {

	Player player;
	
	@Before
	public void setup() {
		player = new Player();
	}
	
	/**
	 * Tests if the player returns the correct hand value
	 */
	@Test
	public void testGetHandVal() {
		Hand hand = new Hand();
		hand.addCard(new Card(Suit.HEARTS, Rank.TEN));
		player.setHand(hand);
		assertEquals(10, player.getHandVal());
	}
	
	/**
	 * Tests if the player adding a card to the hand is correct
	 */
	@Test
	public void testAddCard() {
		Hand hand = new Hand();
		player.setHand(hand);
		player.addCard(new Card(Suit.CLUBS, Rank.ACE));
		assertEquals(player.getHand().getCards().size(), 1);
	}
	
}
