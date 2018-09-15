/**
 * TeeTime - A tee time for a tee sheet
 * @author Josh
 */
public class TeeTime
{
	// Attributes
	private String name;
	private int golfers;
	private int time;
	private String rate;
	private int day;
	private String uid;

	// Constructors
	public TeeTime()
	{
		name = "";
		golfers = 0;
		time = 0;
		rate = "";
		day = 0;
		uid = "";
	} // End default constructor

	public TeeTime(String name, int golfers, int time, String rate, int day, String uid)
	{
		this.name = name;
		this.golfers = golfers;
		this.time = time;
		this.rate = rate;
		this.day = day;
		this.uid = uid;
	} // End constructor

	// Setters
	public void setName(String name)
	{
		this.name = name;
	}

	public void setGolfers(int golfers)
	{
		this.golfers = golfers;
	}

	public void setTime(int time)
	{
		this.time = time;
	}

	public void setRate(String rate)
	{
		this.rate = rate;
	}

	public void setDay(int day)
	{
		this.day = day;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	// Getters
	public String getName()
	{
		return name;
	}

	public int getGolfers()
	{
		return golfers;
	}

	public int getTime()
	{
		return time;
	}

	public String getRate()
	{
		return rate;
	}

	public int getDay()
	{
		return day;
	}

	public String getUid()
	{
		return uid;
	}

	// toString
	public String toString()
	{
		return "Day: " + day + "   Time: " + time + "   Name: " + name + "   Golfers: " + golfers + "   Rate: " + rate
				+ "    User ID: " + uid;
	}

} // End Class
