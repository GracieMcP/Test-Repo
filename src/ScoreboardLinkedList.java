import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author Jose Stovall / GGY323
 * 
 *         A Linked-List implementation of the textbook's Scoreboard object
 *
 */

public class ScoreboardLinkedList
{
	// The object's main list
	private LinkedList<GameEntry> board;

	// Simple constructor; no argument for size required because LL's are dynamically sized
	public ScoreboardLinkedList()
	{
		board = new LinkedList<GameEntry>();
	}

	/**
	 * @param entry
	 *            Game Entry to be added - sorting is included!
	 */
	public void add(GameEntry entry)
	{
		this.board.add(entry);
		sort();
		// Essentially limits the size to the 10 best entries.
		if (this.board.size() > 10)
			this.board.removeFirst();
	}

	/**
	 * @param entry
	 *            Game Entry to be removed - sorting is included!
	 */
	public void remove(GameEntry entry)
	{
		this.board.remove(entry);
		sort();
	}

	/**
	 * @return The number of entries currently stored
	 */
	public int getEntryCount()
	{
		return this.board.size();
	}

	/**
	 * 
	 * @param name
	 *            Name of the GameEntry that is being searched
	 * @return A GameEntry object which matches the name of the argument passed
	 */
	public GameEntry getEntryFromName(String name)
	{
		Iterator<GameEntry> iter = this.board.iterator();

		while (iter.hasNext())
		{
			GameEntry curr = iter.next();

			if (curr.getName().equals(name))
				return curr;
		}

		return null;
	}

	// Sorts the board using LinkedLists packaged sort method.
	// A new Comparator anonymous class is created to tell the sort method how to order things

	public void sort()
	{
		this.board.sort(new Comparator<GameEntry>()
		{
			@Override
			public int compare(GameEntry o1, GameEntry o2)
			{
				// Compares based on scores
				if (o1.getScore() < o2.getScore())
					return -1;
				else if (o1.getScore() == o2.getScore())
					return 0;
				else
					return 1;
			}
		});
	}

	// Overridden for System.out convenience
	@Override
	public String toString()
	{
		return this.board.toString();
	}



}
