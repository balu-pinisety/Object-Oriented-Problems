package com.ObjectOrientedProblems.DeckOfCards;

public class DeckOfCards {
	private static String suit[]={"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
	private static String rank[]= {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
	private static String deck[][]=new String[suit.length][rank.length];
	private static String user1[],user2[],user3[],user4[];
	private static int one=0, two=0, three=0, four=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String[][] deck = new String[suit.length][rank.length]; 
		System.out.println("All Deck cards: ");
		for (int i=0; i<suit.length;i++) {
			for (int j=0; j<rank.length; j++) {
				deck[i][j]=suit[i]+" "+rank[j];
				System.out.println(deck[i][j]);
			}
		}
		
		System.out.println("\nShuffled cards of Deck are: ");
		for (int i=0; i<suit.length;i++) {
			for (int j=0; j<rank.length; j++) {
				int suitRandm= i + (int) (Math.random() * (suit.length-i));
				int rankRandm= j + (int) (Math.random() * (rank.length-j));
				String temp=deck[suitRandm][rankRandm];
				deck[suitRandm][rankRandm]=deck[i][j];
				deck[i][j]=temp;
				System.out.println(deck[i][j]);
			}
		}
		
		user1= new String[9];
		user2= new String[9];
		user3= new String[9];
		user4= new String[9];
		int nmb=0;
		for (int i=0; i<suit.length;i++) {
			for (int j=0; j<rank.length; j++) {
				if (nmb<36) nmb++;
				else break;
				switch (nmb%4) {
				case 0: user1[one++]=deck[i][j];
					break;
				case 1: user2[two++]=deck[i][j];
					break;
				case 2: user3[three++]=deck[i][j];
					break;
				case 3: user4[four++]=deck[i][j];
					break;		
				}
			}
		}
		distributedCards(user1);
		rankCards(user1);
	}
	private static void distributedCards(String[] array) {
		System.out.println("\nDistributed Cards of PerSon One: ");
		for(String element: array) {
			System.out.printf("%s\n",element);
		}
	}
	private static void rankCards(String[] array) {
		int card=0;
		for (int i=0; i<rank.length;i++) {
			for (int j=0; j<suit.length; j++) {
				deck[j][i]=suit[j]+" "+rank[i];
				System.out.printf("%s\n",deck[j][i]);
				for (int k=0; k<user1.length; k++) {
					while(deck[j][i].equals(user1[k])) {
						String temp=user1[k];
						user1[k]=user1[card];
						user1[card]=temp;
						System.out.printf("%s\n",temp);
						card++;
						break;
					}
				}
			}
			
		}
		System.out.println("\nSorting Cards of PerSon One: ");
		for(String element: user1) {
			System.out.printf("%s\n",element);
		}
	}
}
