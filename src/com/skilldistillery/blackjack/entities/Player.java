package com.skilldistillery.blackjack.entities;

public class Player implements PlayerLogic {

	private BlackjackHand hand;

	public Player() {
		hand = new BlackjackHand();
	}

	public void getCardFromDealer(Card card) {
		hand.addCard(card);
	}

	public int getHandValue() {

		int value = 0;
		if (hand.getHandSize() > 0) {
			for (Card card : hand.getHand()) {
				if (card != null) {
					value = value + card.getValue();
				}
			}
		}
		return value;
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
		if (this.getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void stay() {
	}

	public void printHand() {
		for (Card card : hand.getHand()) {
			System.out.println(card.toString());
		}
	}

}
