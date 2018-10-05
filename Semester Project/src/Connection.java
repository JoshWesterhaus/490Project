import java.sql.*;
import javax.swing.JOptionPane;

/*
 * Class to connect to the MySQL Database 
 * Similar to the facade class that has a singleton connection that is established 
 * at the beginning of the program. 
 */
public class Connection {
	
public static void main(String[] args){
{
	try {
		String host = "jdbc:mysql://sql9.freesqldatabase.com/sql9255339";
		String username = "sql9255339";
		String password = "S8EkeFyZuD";
		java.sql.Connection con = DriverManager.getConnection(host, username, password);
		
		//Verify the connection is working by printing all usernames
		Statement test = con.createStatement();
		ResultSet rs = test.executeQuery("select * from user");
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
	} catch (SQLException error) {
		System.out.println(error.getMessage());
	}
}
}
}// End class
