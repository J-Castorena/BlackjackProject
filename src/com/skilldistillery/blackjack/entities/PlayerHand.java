package com.skilldistillery.blackjack.entities;

public class PlayerHand extends Hand implements PlayerLogic {
	public PlayerHand() {
		super();
	}
	
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

	@Override
	public void hit(Card card) {
		super.addCard(card);
	}

	@Override
	public void stay() {
	}

	
	
	
}
