import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MovieDAOImpl extends DAOBase implements MovieDAO {

	@Override
	public void searchMovie(String keyword) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=this.getConnection();
			String sql="select * from Movie where chineseName like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println("chineseName:"+rs.getString("chineseName"));
				System.out.println("foreignName:"+rs.getString("foreignName"));
				System.out.println("movieType:"+rs.getString("movieType"));
				System.out.println("country/region:"+rs.getString("country/region"));
				System.out.println("releaseDate:"+rs.getString("releaseDate"));
				System.out.println("releaseYear:"+rs.getInt("releaseYear"));
				System.out.println();
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

	@Override
	public void selectMovie(int movieId) {
		// TODO Auto-generated method stub

	}

}
