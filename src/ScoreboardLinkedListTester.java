import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Jose Stovall / GGY323
 * 
 *         This class is (an admittedly over-the-top) tester class for a ScoreBoard class which is based around LinkedLists
 *
 */

public class ScoreboardLinkedListTester
{
	public static void main(String[] args)
	{
		// Random is used to generate 10 score values FOR the user
		Random rand = new Random();

		// The main test scoreboard which this class is meant to demonstrate
		ScoreboardLinkedList testScoreBoard = new ScoreboardLinkedList();

		// Some simple logic and notifications letting the user know what I'm doing:
		System.out.println("Randomly generating scoreboard entries...");

		for (int i = 0; i < 10; i++)
			testScoreBoard.add(new GameEntry("t" + (i + 1), rand.nextInt(24)));

		System.out.println();
		System.out.println("Random List Generated: " + testScoreBoard);
		System.out.println();

		// A command prompt, if you will
		System.out.println("Enter Command:");

		Scanner s = new Scanner(System.in);

		// Constantly loops until manually left via "exit" command (or application termination)
		while (true)
		{
			// Gets next line
			String command = s.nextLine();

			// Searches for the add command
			if (command.toLowerCase().contains("add"))
			{
				// Splits the next line int an array of String objects, separated by non-text characters
				String[] commandParts = command.split("[\\W]");
				// Confirms that the # of arguments was correct
				if (commandParts.length == 3)
				{
					// Adds the item if possible; catches an error if the "score" isn't formatted right
					try
					{
						testScoreBoard.add(new GameEntry(commandParts[1], Integer.parseInt(commandParts[2])));
						System.out.println("Current scoreboard: " + testScoreBoard);
					}
					catch (NumberFormatException e)
					{
						System.out.println("Command Syntax Error. Usage example: add t1 10");
					}
				}
				else
				{
					System.out.println("Command Syntax Error. Usage example: add t1 10");
				}
			}
			// Searches for the remove command
			else if (command.toLowerCase().contains("remove"))
			{
				// Splits the next line int an array of String objects, separated by non-text characters
				String[] commandParts = command.split("[\\W]");
				// Confirms that the # of arguments was correct

				if (commandParts.length == 2)
				{
					// Removes object and relists the scoreboard
					testScoreBoard.remove(testScoreBoard.getEntryFromName(commandParts[1]));
					System.out.println("Current scoreboard: " + testScoreBoard);

				}
				else
				{
					System.out.println("Command Syntax Error. Usage example: remove t1");
				}

			}
			// Searches for the list command
			else if (command.toLowerCase().contains("list"))
			{
				System.out.println(testScoreBoard);
			}
			// Searches for the help command
			else if (command.toLowerCase().contains("help"))
			{
				System.out.println("Command list: list, exit, add <name> <score>, remove <name>");
			}
			// Searches for the exit command
			else if (command.toLowerCase().contains("exit"))
			{
				break;
			}
			// Displays an error if the command isn't matched by any above searches
			else
			{
				System.out.println("Command not found. Please use the commands: list, exit, add <name> <score>, remove <name>");
			}
		}

		// This is where the break will land you - shows the board one more time and then closes the scanner; app is terminated
		System.out.println("Exiting. Scoreboard is: " + testScoreBoard);
		s.close();
	}
}