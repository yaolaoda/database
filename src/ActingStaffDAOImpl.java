import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ActingStaffDAOImpl extends DAOBase implements ActingStaffDAO {

	@Override
	public void searchActingStaff(int staffId) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=this.getConnection();
			String sql="select * from ActingStaff where staffId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, staffId);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println("staffId:"+rs.getInt("staffId"));
				System.out.println("chineseName:"+rs.getString("chinesename"));
				System.out.println("foreignName:"+rs.getString("foreignName"));
				System.out.println("moreChineseName:"+rs.getString("moreChineseName"));
				System.out.println("moreForeign:"+rs.getString("moreForeignName"));
				System.out.println("sex:"+rs.getString("sex"));
				System.out.println("constellation:"+rs.getString("constellation"));
				System.out.println("birthday:"+rs.getDate("birthday"));
				System.out.println("birthpalce:"+rs.getString("birthplace"));
				System.out.println("profession:"+rs.getString("profession"));
				System.out.println("familyMember:"+rs.getString("familyMember"));
				System.out.println("imdbLink:"+rs.getString("imdbLink"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}			
	}

}
