package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deck;

	public Deck() {
		deck = buildDeck();

	}

	private List<Card> buildDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		return deck;

	}
	public Card dealCard() {
		Card card = deck.remove(0);
		return card;
	}

	public int checkDeckSize() {
		return deck.size();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	

}
