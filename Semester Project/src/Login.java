/**
 * Login - An object class for passing login information
 * @author Josh
 */
public class Login
{
	private String userName;
	private String password;
	private String uid;
	public static boolean status;

	public Login()
	{
		userName = "";
		password = "";
		uid = "";
	} // Default constructor

	public Login(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
		this.uid = getUserID(userName, password);
	}

	private String getUserID(String userName, String password)
	{

		// True would be replaced by a method in Connection that would check the
		// username and password for a match
		// Connection.checkPassword(userName, password) - would return a boolean
		status = true;
		String tempUID = "";
		System.out.println("Login status is: " + status);
		if (status)
		{
			// Insert method here to get uid from the database
			// Example: uid = Connection.getUserID(userName, password); - returns a string
			// "West101"

			tempUID = userName + 101;

		}

		else
		{
			// Insert bad user name or password error window
			System.out.println("BAD PASSWORD or USERNAME!");
			status = false;
		}

		System.out.println("User ID is: " + tempUID);
		return tempUID;
	} // End createUserID

	// Getters
	public String getUserName()
	{
		return userName;
	}

	public String getPassword()
	{
		return password;
	}

	public String getUID()
	{
		return uid;
	}

} // End class
