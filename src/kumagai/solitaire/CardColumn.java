package kumagai.solitaire;

import java.util.*;

public class CardColumn
	extends ArrayList<Card>
{
	public Card getTop()
	{
		if (size() > 0)
		{
			return get(size() - 1);
		}
		else
		{
			return null;
		}
	}

	public Card removeTop()
	{
		if (size() > 0)
		{
			return remove(size() - 1);
		}
		else
		{
			return null;
		}
	}
}
