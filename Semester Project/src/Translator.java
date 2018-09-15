/*
 * This class handles all communication between the tee sheet and the database.
 * It will receive the tee times as an object to send to the database
 * It will receive a day(int) and return an ArrayList of TeeTimes that match the day
 * 
 */

import java.util.ArrayList;
public class Translator
{
	
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
	
} // End class
