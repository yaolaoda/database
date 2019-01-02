import java.sql.*;

public class ShortCommentDAOImpl extends DAOBase implements ShortCommentDAO {

	@Override
	public void searchShortComment(int movieId) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=this.getConnection();
			String sql="select * from ShortComment where movieId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, movieId);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println("commentId:"+rs.getInt("commentId"));
				System.out.println("nickname:"+rs.getString("nickname"));
				System.out.println("content:"+rs.getString("content"));
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
	public void insertShortComment(ShortComment comment) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=this.getConnection();
			String sql="insert into ShortComment(nickname,time,content,score,usefulCount,movieId)"
					+ "values(?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//ps.setInt(1, comment.getCommentId());
			ps.setString(1, comment.getNickname());
			ps.setDate(2,comment.getTime());
			ps.setString(3,comment.getContent());
			ps.setInt(4, comment.getScore());
			ps.setInt(5, comment.getUsefulCount());
			ps.setInt(6, comment.getMovieId());
			ps.executeUpdate();
			ps.close();
			sql="select * from ShortComment where movieId = ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, comment.getMovieId());
			rs=ps.executeQuery();
			float sum=0;
			int count=0;
			while(rs.next()){
				count++;
				sum=sum+rs.getInt("score");
			}
			sum=sum/count;
			ps.close();
			if(comment.getScore()==1){
				sql="update Movie set oneStar = oneStar+1,score= ? where movieId= ?";
				ps=conn.prepareStatement(sql);
				ps.setFloat(1, sum);
				ps.setInt(2, comment.getMovieId());
				ps.executeUpdate();
			}
			else if(comment.getScore()==2){
				sql="update Movie set twoStar = twoStar+1,score= ? where movieId= ?";
				ps=conn.prepareStatement(sql);
				ps.setFloat(1, sum);
				ps.setInt(2, comment.getMovieId());
				ps.executeUpdate();
			}
			else if(comment.getScore()==3){
				sql="update Movie set threeStar = threeStar+1,score= ? where movieId= ?";
				ps=conn.prepareStatement(sql);
				ps.setFloat(1, sum);
				ps.setInt(2, comment.getMovieId());
				ps.executeUpdate();
			}
			else if(comment.getScore()==4){
				sql="update Movie set fourStar = fourStar+1,score= ? where movieId= ?";
				ps=conn.prepareStatement(sql);
				ps.setFloat(1, sum);
				ps.setInt(2, comment.getMovieId());
				ps.executeUpdate();
			}
			else if(comment.getScore()==5){
				sql="update Movie set fiveStar = fiveStar+1,score= ? where movieId= ?";
				ps=conn.prepareStatement(sql);
				ps.setFloat(1, sum);
				ps.setInt(2, comment.getMovieId());
				ps.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				ps.close();
				conn.close();
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
