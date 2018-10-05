/*
 * This class handles all communication between the tee sheet and the database.
 * It will receive the tee times as an object to send to the database
 * It will receive a day(int) and return an ArrayList of TeeTimes that match the day
 * 
 */

import java.util.ArrayList;
public class Translator
{
	/**
	 * getTestTeeTimes - Used as a tester class for the remainder of the program
	 * @param day - Day to retrieve
	 * @return - An ArrayList of TeeTimes for the day requested
	 */
	public static ArrayList<TeeTime> getTestTeeTimes(int day)
	{
		// String name, int golfers, int time, String rate, int day, String uid
		
		// Create a bunch of tee times
		TeeTime test1 = new TeeTime("Smith", 4, 730, "Regular", 1, "Josh101");
		TeeTime test2 = new TeeTime("Johnson", 4, 750, "Regular", 1, "Josh101");
		TeeTime test3 = new TeeTime("Franks", 4, 1230, "Internet", 1, "Josh101");
		TeeTime test4 = new TeeTime("Williams", 4, 700, "Regular", 2, "Josh101");
		TeeTime test5 = new TeeTime("Stine", 4, 730, "Hotel", 2, "Josh101");
		TeeTime test6 = new TeeTime("Boyer", 2, 740, "Internet", 2, "Josh101");
		TeeTime test7 = new TeeTime("Cooper", 1, 740, "Regular", 2, "Josh101");
		
		// Add them to ArrayList
		
		ArrayList<TeeTime> test = new ArrayList<>();
		test.add(test1);
		test.add(test2);
		test.add(test3);
		test.add(test4);
		test.add(test5);
		test.add(test6);
		test.add(test7);
		
		// Get rid of the days that are not asked for
		for(int i = 0; i < test.size(); i++)
		{
			if(test.get(i).getDay() != day) 
			{
				test.remove(i);
				i--;
			}
		}	
		
		return test;

	} // End getTestTeeTimes
	
	/**
	 * getUserID - Checks the database if the user name and password exist, if true, retrieves UID of the user
	 * @param userName - Name of the user as a String
	 * @param password - Password of the user as a String
	 * @return the uid of the user, if valid
	 */
	private String getUserID(String username, String password)
	{
		// True would be replaced by a method in Connection that would check the
		// username and password for a match in the database
		// status = Connection.checkPassword(userName, password) - would return a boolean
		Boolean status = true;
		ArrayList uid;
		System.out.println("Login status is: " + status);
		if (status)
		{
			uid = Connection.getLogin();
		}
		return "";
	} // End createUserID
} // End class
