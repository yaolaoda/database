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
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=this.getConnection();
			String sql="select * from Movie where movieid=?";
			ps=conn.prepareStatement(sql);
			ps.setLong(1, movieId);
			rs=ps.executeQuery();
			System.out.println("查询结果：");
			while(rs.next()){
				System.out.println("movieId:"+rs.getInt("movieId"));
				System.out.println("chineseName:"+rs.getString("chineseName"));
				System.out.println("foreignName:"+rs.getString("foreignName"));
				System.out.println("movieType:"+rs.getString("movieType"));
				System.out.println("country/region:"+rs.getString("country/region"));
				System.out.println("language:"+rs.getString("language"));
				System.out.println("releaseDate:"+rs.getString("releaseDate"));
				System.out.println("movieLength:"+rs.getInt("movieLength"));
				System.out.println("alternateName:"+rs.getString("alternateName"));
				System.out.println("imdbLink:"+rs.getString("imdbLink"));
				System.out.println("score:"+rs.getFloat("score"));
				System.out.println("plotSummary:"+rs.getString("plotSummary"));
				System.out.println("releaseYear:"+rs.getInt("releaseYear"));
				System.out.println("oneStar:"+rs.getInt("oneStar"));
				System.out.println("twoStar:"+rs.getInt("twoStar"));
				System.out.println("threeStar:"+rs.getInt("threeStar"));
				System.out.println("fourstar:"+rs.getInt("fourStar"));
				System.out.println("fiveStar:"+rs.getInt("fiveStar"));
			}
			sql="select ActingStaff.chineseName,MovieStaff.status,ActingStaff.staffid from Movie,MovieStaff,ActingStaff where Movie.movieid=MovieStaff.movieid and ActingStaff.staffid=MovieStaff.staffid and Movie.movieid=?";			
			ps=conn.prepareStatement(sql);		
			ps.setLong(1, movieId);
			rs=ps.executeQuery();
			int i=5;
			System.out.println();
			System.out.println("演职员：");
			while(rs.next()&&(i>0)){
				System.out.print('\t');
				System.out.println("staffid:"+rs.getString("staffid"));
				System.out.print('\t');
				System.out.println(rs.getString("status")+":"+rs.getString("chineseName"));	
				i--;
			}
			System.out.print('\t');System.out.println("更多演职员......");
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
