/**
 * Login - An object class for passing login information
 * @author Team 4
 */
public class Login
{
	private String userName;
	private String password;
	private String uid;
	public static boolean status;

	/**
	 * Default Constructor with a not valid credentials(DO NOT USE!!!)
	 */
	public Login()
	{
		userName = "";
		password = "";
		uid = "";
		status = false;
	} // Default constructor

	/**
	 * Login - The constructor to use to create a valid login
	 * @param userName - The user name as a string
	 * @param password - The password as a string
	 */
	public Login(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
		this.uid = getUserID(userName, password);
	}

	/**
	 * getUserID - Checks the database if the user name and password exist, if true, retrieves UID of the user
	 * @param userName - Name of the user as a String
	 * @param password - Password of the user as a String
	 * @return the uid of the user, if valid
	 */
	private String getUserID(String userName, String password)
	{

		// True would be replaced by a method in Connection that would check the
		// username and password for a match in the database
		// status = Connection.checkPassword(userName, password) - would return a boolean
		status = true;
		String tempUID = "";
		System.out.println("Login status is: " + status);
		if (status)
		{
			// Insert method here to get uid from the database
			// Example: uid = Connection.getUserID(userName, password); - returns a string
			// "Josh101"

			tempUID = "Josh" + 101;
		}

		System.out.println("User ID is: " + tempUID);
		return tempUID;
	} // End createUserID

	// Getters
	/**
	 * getUserName - Gets the name of the user
	 * @return the name as a String
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * getPassword - Gets the password of the user
	 * @return the password as a String
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * getUID - Gets the User ID of the user
	 * @return the uid of the user as a String
	 */
	public String getUID()
	{
		return uid;
	}

} // End class
