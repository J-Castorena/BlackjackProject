package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	public List<Card> hand;

	public Hand() {
		hand = new ArrayList<>();
	}

	public void addCard(Card card) {
		this.hand.add(card);
	}

	public void clear() {
		this.hand.removeAll(hand);
	}

	public abstract int getHandValue();

	public List<Card> getHand() {
		return this.hand;
	}

	public int getHandSize() {
		return this.hand.size();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand []");
		return builder.toString();
	}

	public void showTheUnhiddenCard() {
		for (Card card : this.hand) {
			System.out.println(card.toString());
		}

	}

}
