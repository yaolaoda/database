import java.sql.SQLException;


public interface UserInfoDAO {

	public void search(UserInfo userinfo) throws SQLException;
	public void update(UserInfo userinfo) throws SQLException;

	
}
