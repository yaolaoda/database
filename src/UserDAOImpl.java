import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDAOImpl extends DAOBase implements UserDAO{

	@Override
	public void searchUser(User user) throws SQLException{
		Connection connection=null;
		PreparedStatement pStatement=null;
		String sql="select * from User where (username=? or telephone=? or email=?) and password=?";
		try{
			connection=getConnection();
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, user.getInput());
			pStatement.setString(2, user.getPassword());
		}catch(SQLException ex){
			
		}finally{
			try{
				connection.close();
			}catch(SQLException ex){
				
			}
		}
		
	}

	/*public void search(User user) throws SQLException {
		Connection connection=null;
		PreparedStatement pStatement=null;
		String sql="select * from UserInfo where userId=?";
		try{
			connection=getConnection();
			pStatement=connection.prepareStatement(sql);
			pStatement.setLong(1, user.getUserId());
		}catch(SQLException ex){
			
		}finally{
			try{
				connection.close();
			}catch(SQLException ex){
				
			}
		}		
	}*/
}
