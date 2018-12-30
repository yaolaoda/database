import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserInfoDAOImpl extends DAOBase implements UserInfoDAO{

	@Override
	public UserInfo search(UserInfo userinfo) throws SQLException {
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rs=null;
		UserInfo userinfo2=null;
		String sql="select * from [UserInfo] where userId=?";
		try{
			connection=getConnection();
			pStatement=connection.prepareStatement(sql);
			pStatement.setLong(1, userinfo.getUserId());
			rs=pStatement.executeQuery();
			if(rs.next()){
				userinfo2=new UserInfo();
				userinfo2.setUserinfoId(rs.getInt("userinfoId"));
				userinfo2.setUserId(userinfo.getUserId());
				userinfo2.setSignature(rs.getString("signature"));
				userinfo2.setProfile(rs.getString("profile"));
				userinfo2.setPhoto(rs.getString("photo"));
				userinfo2.setNickname(rs.getString("nickname"));
				userinfo2.setLocation(rs.getString("location"));
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
		return userinfo2;
	}

	@Override
	public boolean update(UserInfo userinfo) throws SQLException {
		int flag=0;
		Connection connection=null;
		PreparedStatement pStatement=null;
		String sql="update UserInfo set nickname=?,location=?,photo=?,profile=?,signature=? where userinfoId=?";
		try{
			connection=getConnection();
			pStatement=connection.prepareStatement(sql);
			pStatement.setString(1, userinfo.getNickname());
			pStatement.setString(2, userinfo.getLocation());
			pStatement.setString(3, userinfo.getPhoto());
			pStatement.setString(4, userinfo.getProfile());
			pStatement.setString(5, userinfo.getSignature());
			pStatement.setLong(6, userinfo.getUserinfoId());
			pStatement.executeUpdate();
			flag=1;
		}catch(SQLException ex){
			
		}finally{
			try{
				connection.close();
			}catch(SQLException ex){
				
			}
		}	
		if(flag==1) return true;
		else return false;
	}

}
