import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterIMP {
String DRIVER="com.mysql.jdbc.Driver";
String URL="jdbc:mysql://34.89.175.166:3306";
String USER="root";
String PASSWORD="daiG11";
String sql="Insert into dai.Users (email,password) VALUE (?,?)";
int i;
	public int registerUser(Users user) {
		// TODO Auto-generated method stub
		String e=user.getEmail();
		String p=user.getPassword();
		
	   //Connection to database and store value in
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,e);
			ps.setString(2,p);
			i=ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return i;
		
	}

}
