import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl extends DAOBase implements UserDAO{

	@Override
	public User searchUser(User user) throws SQLException{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rs=null;
		User user2=null;
		String sql="select * from [User] where (username=? or telephone=? or email=?) and password=?";
		try{
			connection=getConnection();
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, user.getInput());
			pStatement.setString(2, user.getInput());
			pStatement.setString(3, user.getInput());
			pStatement.setString(4, user.getPassword());
			rs=pStatement.executeQuery();
			if(rs.next()){
				user2=new User();
				user2.setUserId(rs.getInt("userId"));
				user2.setUsername(rs.getString("username"));
				user2.setEmail(rs.getString("email"));
				user2.setTelephone(rs.getString("telephone"));
			}
			rs.close();
			pStatement.close();
		}catch(SQLException ex){
			
		}finally{
			try{
				connection.close();
			}catch(SQLException ex){
				
			}
		}
		return user2;
	}
}
