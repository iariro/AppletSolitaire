package kumagai.solitaire;

public class Card
{
	public final int number;
	public final int mark;

	public Card(int number, int mark)
	{
		this.number = number;
		this.mark = mark;
	}

	public String getMarkString()
	{
		switch (mark)
		{
			case 0:
				return "ハート　";
			case 1:
				return "ダイヤ　";
			case 2:
				return "スペード";
			case 3:
				return "クラブ　";
			default:
				throw new IllegalArgumentException();
		}
	}

	public String getMarkString2()
	{
		switch (mark)
		{
			case 0:
				return "Ｈ";
			case 1:
				return "Ｄ";
			case 2:
				return "Ｓ";
			case 3:
				return "Ｃ";
			default:
				throw new IllegalArgumentException();
		}
	}

	public char getNumberString()
	{
		if (number == 0)
		{
			return 'Ａ';
		}
		else if (number >= 1 && number <= 9)
		{
			return (char)('０' + number);
		}
		else if (number == 10)
		{
			return 'Ｊ';
		}
		else if (number == 11)
		{
			return 'Ｑ';
		}
		else if (number == 12)
		{
			return 'Ｋ';
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	public char getNumberString2()
	{
		if (number == 0)
		{
			return 'Ａ';
		}
		else if (number >= 1 && number <= 8)
		{
			return (char)('１' + number);
		}
		else if (number == 9)
		{
			return '十';
		}
		else if (number == 10)
		{
			return 'Ｊ';
		}
		else if (number == 11)
		{
			return 'Ｑ';
		}
		else if (number == 12)
		{
			return 'Ｋ';
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	public boolean canStack(Card card)
	{
		return (mark / 2 != card.mark / 2) && (number == card.number - 1);
	}

	@Override
	public String toString()
	{
		return String.format("%s%s", getMarkString2(), getNumberString2());
	}
}
