/**
 * 
 * @author Jose Stovall / GGY323
 * 
 *         Most code acquired from the textbook, as I was instructed
 */

public class GameEntry
{
	private String name;
	private int score;

	/**
	 * Constructs a "Game Entry" with the given parameters
	 */

	public GameEntry(String name_in, int score_in)
	{
		this.name = name_in;
		this.score = score_in;
	}

	/**
	 * @return this object's name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @return this object's score
	 */
	public int getScore()
	{
		return this.score;
	}

	/**
	 * @return a String representing this object
	 */
	@Override
	public String toString()
	{
		return "(" + name + ", " + score + ")";
	}

	/**
	 * @return TRUE if the other object is the same, otherwise false overridden to ensure functionality
	 */
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof GameEntry))
			return false;
		GameEntry otherEntry = (GameEntry) other;

		return other == this ? true : !(this.name == otherEntry.getName()) ? false : this.score == otherEntry.getScore();
	}
}