package kumagai.solitaire;

public class SolitaireMain
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Card [] cards = new AllCard().getCards();

		Table table = new Table(cards);
		table.dump();
		table.searchMoveableOnBuffer();
	}
}
