package com.skilldistillery.blackjack.entities;

public interface PlayerLogic {

	int getHandValue();
	
	boolean isBlackJack();
	
	boolean isBust();
	
	void stay();
}
