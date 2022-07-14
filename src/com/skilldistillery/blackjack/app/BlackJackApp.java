package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {

	private Player playerHand;
	private Dealer dealerHand;
	private Deck deck;

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.launch();
	}

	private void displayMenu() {
		System.out.println(" _____________________________________");
		System.out.println("|                                     |");
		System.out.println("|              BLACK JACK             |");
		System.out.println("|  .-------.-------.------.------.    |");
		System.out.println("|  |A_  _  |A /\\   |A _   |A .   |    |");
		System.out.println("|  |( \\/ ) | /  \\  | ( )  | / \\  |    |");
		System.out.println("|  | \\  /  | \\  /  |(_x_) |(_,_) |    |");
		System.out.println("|  |  \\/ A |  \\/  A|  Y  A|  I  A|    |");
		System.out.println("|  .-------^-------^------^------.    |");
		System.out.println("|                                     |");
		System.out.println("|                                     |");
		System.out.println("| 1. Play Game                        |");
		System.out.println("| 2. Opt Out                          |");
		System.out.println("|                                     |");
		System.out.println("| May the odds ever be in your favor! |");
		System.out.println("|_____________________________________|");
	}

	private void launch() {
		Scanner userInput = new Scanner(System.in);
		menuSelection(userInput);
		userInput.close();
	}

	private boolean menuSelection(Scanner userInput) {
		boolean keepRunning = true;
		while (keepRunning) {
			displayMenu();
			int selection = userInput.nextInt();
			switch (selection) {
			case 1:
				playBlackJackGame(userInput);
				break;
			case 2:
				System.out.println("Thank you for playing!");
				return false;
			default:
				System.out.println("Not a valid entry. Please select 1 or 2.");
				break;
			}
		}
		return keepRunning;
	}

	private void playBlackJackGame(Scanner userInput) {
		this.playerHand = new Player();
		this.dealerHand = new Dealer();
		deck = new Deck();
		deck.shuffle();
		drawFirstTwoCards();
		printHands("Hidden");

		boolean playingGame = true;

		while (playingGame) {
			boolean playerIsStaying = false;
			if (!this.playerHand.isBust() && this.playerHand.getHandValue() != 21) {
				playerIsStaying = playerHit(userInput);
				if (playerIsStaying) {
					dealerHit();
					if (this.playerHand.getHandValue() > this.dealerHand.getHandValue() && !this.dealerHand.isBust()) {
						System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
						printHands("Unhidden");
						System.out.println("PLAYER WINS!!!!!");
					} else if (this.dealerHand.isBust()) {
						System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
						printHands("Unhidden");
						System.out.println("PLAYER WINS!!!!!");
					} else if (this.playerHand.getHandValue() == this.dealerHand.getHandValue()) {
						System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
						printHands("Unhidden");
						System.out.println("Push!");
					} else {
						System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
						printHands("Unhidden");
						System.out.println("Dealer WINS!!!!!");
					}
					break;
				}
				if (!this.playerHand.isBust()) {
					printHands("Hidden");
				}
			}
			if (this.playerHand.isBust()) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
				printHands("Unhidden");
				System.out.println("Player bust! Dealer WINS!");
				playingGame = false;
				break;
			} else if (this.playerHand.isBlackJack()) {
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
				if (this.dealerHand.isBlackJack()) {
					printHands("Unhidden");
					System.out.println("Push!");
					break;
				} else {
					printHands("Unhidden");
					System.out.println("Player WINS BLACKJACK!");
					break;
				}

			}
			if (playerIsStaying) {
				dealerHit();
				if (this.dealerHand.isBust()) {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
					printHands("Unhidden");
					System.out.println("Player WINS! Dealer Bust!");
					break;

				}
			}
		}

	}

	private void drawFirstTwoCards() {
		System.out.println("First round of cards dealt to dealer and player. ");
		for (int i = 0; i < 2; i++) {
			this.playerHand.getCardFromDealer(this.dealerHand.dealCardToAPlayer(deck));
			this.dealerHand.hit(deck.dealCard());
		}
	}

	private boolean playerHit(Scanner userInput) {
		System.out.println("Would you like to hit or stay? Please type 1 to hit or 0 to stay. ");
		int selection = -1;
		while (selection != 0 && selection != 1) {
			selection = userInput.nextInt();
			if (selection == 1) {
				this.playerHand.getCardFromDealer(this.dealerHand.dealCardToAPlayer(deck));
				System.out.println("Player chose to hit.");
				return false;
			} else if (selection == 0) {
				System.out.println("Player is staying.");
				return true;
			} else {
				System.out.println("Choose a valid option. Please enter 0 or 1. ");
			}
		}
		return false;
	}

	private void printHands(String keyWord) {
		if (keyWord.equals("Hidden")) {
			System.out.println("Dealer's Hand: ");
			if (this.dealerHand != null) {
				this.dealerHand.showHiddenHand();
			}
		} else {
			System.out.println("Dealer's Hand-- Hand Value: " + this.dealerHand.getHandValue());
			this.dealerHand.printHand();
		}
		System.out.println("Player's Hand-- Hand Value: " + this.playerHand.getHandValue());
		this.playerHand.printHand();
	}

	private void dealerHit() {
		while (this.dealerHand.canDealerHit()) {
			this.dealerHand.hit(deck.dealCard());
		}
	}

}