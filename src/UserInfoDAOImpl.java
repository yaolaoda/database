import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserInfoDAOImpl extends DAOBase implements UserInfoDAO{

	@Override
	public void search(UserInfo userinfo) throws SQLException {
		Connection connection=null;
		PreparedStatement pStatement=null;
		String sql="select * from UserInfo where userId=?";
		try{
			connection=getConnection();
			pStatement=connection.prepareStatement(sql);
			pStatement.setLong(1, userinfo.getUserId());
		}catch(SQLException ex){
			
		}finally{
			try{
				connection.close();
			}catch(SQLException ex){
				
			}
		}		
	}

	@Override
	public void update(UserInfo userinfo) throws SQLException {
		Connection connection=null;
		PreparedStatement pStatement=null;
		String sql="update UserInfo set ";
		try{
			connection=getConnection();
			pStatement=connection.prepareStatement(sql);
			pStatement.setLong(1, userinfo.getUserId());
		}catch(SQLException ex){
			
		}finally{
			try{
				connection.close();
			}catch(SQLException ex){
				
			}
		}	
	}

}
