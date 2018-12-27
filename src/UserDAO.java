import java.sql.SQLException;


public interface UserDAO {

	public User searchUser(User user) throws SQLException;
	
}
