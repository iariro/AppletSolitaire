package kumagai.solitaire;

import java.util.*;

public class Table
{
	public ArrayList<Card> yama1;
	public ArrayList<CardColumn> buffer1;
	public ArrayList<CardColumn> buffer2;

	public Table(Card [] cards)
	{
		int index = 0;

		buffer1 = new ArrayList<CardColumn>();
		buffer2 = new ArrayList<CardColumn>();

		for (int i=0 ; i<7 ; i++)
		{
			buffer1.add(new CardColumn());
			buffer2.add(new CardColumn());

			for (int j=0 ; j<i+1 ; j++)
			{
				if (j < i)
				{
					buffer1.get(i).add(cards[index]);
				}
				else
				{
					buffer2.get(i).add(cards[index]);
				}
				index++;
			}
		}

		yama1 = new ArrayList<Card>();

		for (int i=index ; i<cards.length ; i++)
		{
			yama1.add(cards[i]);
		}
	}

	public void dump()
	{
		for (int i=0 ; ; i++) // 重なり
		{
			int count = 0;

			for (int j=0 ; j<buffer1.size() ; j++) // 列
			{
				if (buffer1.get(j).size() + buffer2.get(j).size() > i + 1)
				{
					count++;
				}

				if (buffer1.get(j).size() + buffer2.get(j).size() >= i + 1)
				{
					if (i < buffer1.get(j).size())
					{
						System.out.printf("(%2s)", buffer1.get(j).get(i));
					}
					else
					{
						System.out.printf(" %2s ", buffer2.get(j).get(i - buffer1.get(j).size()));
					}
				}
				else
				{
					System.out.printf("      ");
				}
			}
			System.out.println();

			if (count <= 0)
			{
				break;
			}
		}
	}

	public boolean isMoveableOnBuffer(int toColumn, int fromColumn, int fromColumnIndex)
	{
		Card toCard = buffer2.get(toColumn).getTop();
		Card fromCard = buffer2.get(fromColumn).get(fromColumn);

		return toCard.canStack(fromCard);
	}

	public void moveOnBuffer(int toColumn, int fromColumn, int fromColumnIndex)
	{
		for (int i=fromColumnIndex ; i<buffer2.get(fromColumn).size() ; i++)
		{
			Card card = buffer2.get(fromColumn).get(i);
			buffer2.get(toColumn).add(card);
		}

		for (int i=buffer2.get(fromColumn).size()-1 ; i>=fromColumnIndex ; i--)
		{
			buffer2.get(fromColumn).remove(i);
		}
	}

	public void searchMoveableOnBuffer()
	{
		for ( ; ; )
		{
			int count = 0;

			for (int i=0 ; i<buffer2.size() ; i++)
			{
				for (int j=i+1 ; j<buffer2.size() ; j++)
				{
					if (buffer2.get(i).size() > 0 && buffer2.get(j).size() > 0)
					{
						if (buffer2.get(i).get(0).canStack(buffer2.get(j).getTop()))
						{
							System.out.printf("%d->%d\n", i, j);
							moveOnBuffer(j, i, 0);
							dump();
							turn(i);
							dump();
							count++;
						}
					}
				}
			}

			if (count <= 0)
			{
				break;
			}
		}
	}

	public void turn(int column)
	{
		if (buffer1.get(column).size() > 0 && buffer2.get(column).size() <= 0)
		{
			Card card = buffer1.get(column).removeTop();
			buffer2.get(column).add(card);
		}
	}
}
