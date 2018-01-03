package com.nextcentury.blackjack.main;

import java.util.Scanner;

import com.nextcentury.blackjack.game.BlackjackGame;
import com.nextcentury.blackjack.objects.Deck;
import com.nextcentury.blackjack.objects.Player;

/**
 * Main class to run multiple blackjack games
 * @author Owner
 *
 */
public class Main {

	public static void main(String[] args) {
		Player player = new Player();
		Player dealer = new Player();
		Deck deck = new Deck();
		Scanner scanner = new Scanner(System.in);
		boolean play = true;
		BlackjackGame game = new BlackjackGame(player, dealer, deck, scanner);
		while(play) {
			game.playBlackjack();
			System.out.println("Would you like to play again?\n");
			String string = scanner.nextLine().toUpperCase();
			if(string.equals("YES")) {
				play = true;
			}
			else {
				play = false;
			}
		}
	}

}
