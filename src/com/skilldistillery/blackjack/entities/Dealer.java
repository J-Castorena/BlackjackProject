package com.skilldistillery.blackjack.entities;

import java.util.Collections;
import java.util.List;

public class Dealer implements PlayerLogic {
	
	private Deck deck;
	private BlackjackHand hand;
	
	public Dealer() {
		hand = new BlackjackHand();
	}

	@Override
	public boolean isBlackJack() {
		if (this.getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isBust() {
		if(this.getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	public Card dealCardToAPlayer(Deck deck) {
		Card card = deck.dealCard();
		return card;
		
	}

	public void hit(Card card) {
		hand.addCard(card);
	}

	@Override
	public void stay() {
	}

	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public boolean canDealerHit() {
		if(this.getHandValue() < 17) {
			return true;
		} else {
			return false;
		}
	}
	
	public void showHiddenHand() {
		int amountOfCards = 1;
		for (Card card : hand.getHand()) {
			if(amountOfCards++ == 1) {
				System.out.println("*** HIDDEN CARD *** ");
			} else {
				System.out.println(card.toString());
			}
		}
	}
	
	public void printHand() {
		for (Card card : hand.getHand()) {
			System.out.println(card.toString());
		}
	}
	
	public void shuffle() {
		Collections.shuffle((List<?>) this.deck);
	}
}
