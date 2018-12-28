import java.sql.SQLException;


public interface UserInfoDAO {

	public UserInfo search(UserInfo userinfo) throws SQLException;
	public boolean update(UserInfo userinfo) throws SQLException;

	
}
