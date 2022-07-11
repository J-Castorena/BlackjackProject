package com.skilldistillery.blackjack.entities;

public class DealerHand extends Hand implements PlayerLogic {

	public DealerHand() {
		super();
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
	
	public boolean canDealerHit() {
		if(this.getHandValue() < 17) {
			return true;
		} else {
			return false;
		}
	}
	
	public void showHiddenHand() {
		int amountOfCards = 1;
		for (Card card : this.getHand()) {
			if(amountOfCards++ == 1) {
				System.out.println("*** HIDDEN CARD *** ");
			} else {
				System.out.println(card.toString());
			}
		}
	}
}
