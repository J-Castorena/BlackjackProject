package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		hand = new ArrayList<>();
	}

	public boolean isBust() {
		if (this.getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public int getHandValue() {
		int value = 0;
		if (this.hand.size() > 0) {
			for (Card card : this.hand) {
				if (card != null) {
					value = value + card.getValue();
				}
			}
		}
		return value;
	}
}


