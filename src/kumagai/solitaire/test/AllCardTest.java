package kumagai.solitaire.test;

import junit.framework.*;
import kumagai.solitaire.*;

public class AllCardTest
	extends TestCase
{
	public void test1()
	{
		AllCard cards = new AllCard();

		for (CardAndRandomValue card : cards)
		{
			System.out.println(card.card);
		}
	}
}
