package kumagai.solitaire;

import java.util.*;

public class AllCard
	extends ArrayList<CardAndRandomValue>
{
	public AllCard()
	{
		Random random = new Random();

		for (int i=0 ; i<13 ; i++)
		{
			for (int j=0 ; j<4 ; j++)
			{
				add(new CardAndRandomValue(new Card(i, j), random.nextInt()));
			}
		}

		Collections.sort(
			this,
			new Comparator<CardAndRandomValue>()
			{
				@Override
				public int compare(CardAndRandomValue c1, CardAndRandomValue c2)
				{
					return Integer.compare(c1.randomValue, c2.randomValue);
				}
			});
	}

	public Card [] getCards()
	{
		ArrayList<Card> cards = new ArrayList<Card>();

		for (CardAndRandomValue cardAndRandomValue : this)
		{
			cards.add(cardAndRandomValue.card);
		}

		return cards.toArray(new Card [] {});
	}
}
