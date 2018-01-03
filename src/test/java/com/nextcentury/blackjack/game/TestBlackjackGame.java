package com.nextcentury.blackjack.game;

/**
 * Tests for the BlackjackGame file
 */
import org.junit.Before;
import org.junit.Test;

import com.nextcentury.blackjack.objects.Card;
import com.nextcentury.blackjack.objects.Deck;
import com.nextcentury.blackjack.objects.Hand;
import com.nextcentury.blackjack.objects.Player;
import com.nextcentury.blackjack.objects.Rank;
import com.nextcentury.blackjack.objects.Suit;
import com.nextcentury.blackjack.game.BlackjackGame;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class TestBlackjackGame {

	BlackjackGame game;
	Deck deck;
	Player player;
	Player dealer;
	Scanner scanner;
	Hand hand;
	Hand hand2;

	@Before
	public void setup() {
		deck = mock(Deck.class);
		player = new Player();
		dealer = new Player();
		game = new BlackjackGame(dealer, player, deck, scanner);
		hand = new Hand();
		hand.addCard(new Card(Suit.CLUBS, Rank.ACE));
		hand.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand2 = new Hand();
		hand2.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand2.addCard(new Card(Suit.CLUBS, Rank.TEN));
	}

	/**
	 * Checks if a proper blackjack will be given
	 */
	@Test
	public void checkForBlackjackTest() {
		
		player.setHand(hand);
		assertTrue(game.checkForBlackjack(player));
		player.setHand(hand2);
		assertFalse(game.checkForBlackjack(player));
	}
	
	/**
	 * Tests printing out both hands
	 */
	@Test
	public void TestShowHands() {
		player.setHand(hand);		
		dealer.setHand(hand2);
		game.setDealer(dealer);
		game.setPlayer(player);
		String actual = game.showHands();
		String expected = "Player's hand: ACE of CLUBS\nTEN of CLUBS\n\nDealer's hand: TEN of CLUBS\n" +
		"TEN of CLUBS\n";
		assertEquals(actual, expected);
	}
	
	/**
	 * Tests to see if the right result if both players get blackjack
	 */
	@Test
	public void TestBothBlackjack() {
		when(deck.drawHand()).thenReturn(hand);
		game.playBlackjack();
		assertEquals("TIE", game.getResult());
	}
	
	/**
	 * Tests if only the player gets blackjack
	 */
	@Test
	public void testPlayerBlackjack() {
		hand2 = new Hand();
		hand2.addCard(new Card(Suit.CLUBS, Rank.ACE));
		hand2.addCard(new Card(Suit.CLUBS, Rank.TWO));
		when(deck.drawHand()).thenReturn(hand, hand2);
		game.playBlackjack();
		assertEquals("PLAYER", game.getResult());
	}
	
	/**
	 * Tests if only the dealer gets blackjack
	 */
	@Test
	public void testDealerBlackjack() {
		hand = new Hand();
		hand.addCard(new Card(Suit.CLUBS, Rank.ACE));
		hand.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand2 = new Hand();
		hand2.addCard(new Card(Suit.CLUBS, Rank.ACE));
		hand2.addCard(new Card(Suit.CLUBS, Rank.TWO));
		when(deck.drawHand()).thenReturn(hand2, hand);
		game.playBlackjack();
		assertEquals("DEALER", game.getResult());
	}
	
	/**
	 * Tests if the player wins and both players stand
	 */
	@Test
	public void testPlayerWins() {
		String choice = "STAND";
		InputStream in = new ByteArrayInputStream(choice.getBytes());
		System.setIn(in);
		scanner = new Scanner(System.in);
		game = new BlackjackGame(dealer, player, deck, scanner);
		hand = new Hand();
		hand.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand2 = new Hand();
		hand2.addCard(new Card(Suit.CLUBS, Rank.ACE));
		hand2.addCard(new Card(Suit.CLUBS, Rank.SEVEN));
		when(deck.drawHand()).thenReturn(hand, hand2);		
		game.playBlackjack();
		assertEquals("PLAYER", game.getResult());
	}
	
	/**
	 * Tests if the dealer wins and both players stand
	 */
	@Test
	public void testDealerWins() {
		String choice = "STAND";
		InputStream in = new ByteArrayInputStream(choice.getBytes());
		System.setIn(in);
		scanner = new Scanner(System.in);
		game = new BlackjackGame(dealer, player, deck, scanner);
		hand = new Hand();
		hand.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand2 = new Hand();
		hand2.addCard(new Card(Suit.CLUBS, Rank.ACE));
		hand2.addCard(new Card(Suit.CLUBS, Rank.SEVEN));
		when(deck.drawHand()).thenReturn(hand2, hand);		
		game.playBlackjack();
		assertEquals("DEALER", game.getResult());
	}
	
	/**
	 * Tests if both players will tie as well as inputing the invalid option
	 */
	@Test
	public void testTie() {
		String choice = "Hello\nSTAND";
		InputStream in = new ByteArrayInputStream(choice.getBytes());
		System.setIn(in);
		scanner = new Scanner(System.in);
		game = new BlackjackGame(dealer, player, deck, scanner);
		hand = new Hand();
		hand.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand.addCard(new Card(Suit.DIAMONDS, Rank.TEN));
		hand2 = new Hand();
		hand2.addCard(new Card(Suit.HEARTS, Rank.TEN));
		hand2.addCard(new Card(Suit.SPADES, Rank.TEN));
		when(deck.drawHand()).thenReturn(hand, hand2);		
		game.playBlackjack();
		assertEquals("TIE", game.getResult());
	}
	
	/**
	 * Tests when the player and dealer hit and both bust
	 */
	@Test
	public void testHitBust() {
		String choice = "HIT\nSTAND";
		InputStream in = new ByteArrayInputStream(choice.getBytes());
		System.setIn(in);
		scanner = new Scanner(System.in);
		game = new BlackjackGame(dealer, player, deck, scanner);
		hand = new Hand();
		hand.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand.addCard(new Card(Suit.DIAMONDS, Rank.SEVEN));
		hand2 = new Hand();
		hand2.addCard(new Card(Suit.HEARTS, Rank.TEN));
		hand2.addCard(new Card(Suit.SPADES, Rank.SIX));
		when(deck.drawHand()).thenReturn(hand, hand2);	
		when(deck.drawCard()).thenReturn(new Card(Suit.CLUBS, Rank.TEN));
		game.playBlackjack();
		assertEquals("DEALER", game.getResult());
	}
	
	/**
	 * Tests if both players hit and only the player busts
	 */
	@Test
	public void testPlayerBust() {
		String choice = "HIT\nSTAND";
		InputStream in = new ByteArrayInputStream(choice.getBytes());
		System.setIn(in);
		scanner = new Scanner(System.in);
		game = new BlackjackGame(dealer, player, deck, scanner);
		hand = new Hand();
		hand.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand.addCard(new Card(Suit.DIAMONDS, Rank.SEVEN));
		hand2 = new Hand();
		hand2.addCard(new Card(Suit.HEARTS, Rank.TEN));
		hand2.addCard(new Card(Suit.SPADES, Rank.SIX));
		when(deck.drawHand()).thenReturn(hand, hand2);	
		when(deck.drawCard()).thenReturn(new Card(Suit.CLUBS, Rank.TEN), new Card(Suit.DIAMONDS, Rank.FOUR));
		game.playBlackjack();
		assertEquals("DEALER", game.getResult());
	}
	
	/**
	 * Tests if both players hit and only the dealer busts
	 */
	@Test
	public void testDealerBust() {
		String choice = "HIT\nSTAND";
		InputStream in = new ByteArrayInputStream(choice.getBytes());
		System.setIn(in);
		scanner = new Scanner(System.in);
		game = new BlackjackGame(dealer, player, deck, scanner);
		hand = new Hand();
		hand.addCard(new Card(Suit.CLUBS, Rank.TEN));
		hand.addCard(new Card(Suit.DIAMONDS, Rank.SEVEN));
		hand2 = new Hand();
		hand2.addCard(new Card(Suit.HEARTS, Rank.TEN));
		hand2.addCard(new Card(Suit.SPADES, Rank.SIX));
		when(deck.drawHand()).thenReturn(hand, hand2);	
		when(deck.drawCard()).thenReturn(new Card(Suit.CLUBS, Rank.TWO), new Card(Suit.DIAMONDS, Rank.TEN));
		game.playBlackjack();
		assertEquals("PLAYER", game.getResult());
	}

}
