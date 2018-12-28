import java.sql.Date;


public class ShortComment {
	private int commentId;
	private String nickname;
	private Date time;
	private String content;
	private int score;
	private int usefulCount;
	private int movieId;
	
	public int getCommentId(){
		return this.commentId;
	}
	
	public void setCommentId(int id){
		this.commentId=id;
	}
	
	public String getNickname(){
		return this.nickname;
	}
	
	public void setNickname(String name){
		this.nickname=name;
	}
	
	public Date getTime(){
		return this.time;
	}
	
	public void setTime(Date time){
		this.time=time;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void setScore(int score){
		this.score=score;
	}
	
	public int getUsefulCount(){
		return this.usefulCount;
	}
	
	public void setUsefulCount(int count){
		this.usefulCount=count;
	}
	
	public int getMovieId(){
		return this.movieId;
	}
	
	public void setMovieId(int id){
		this.movieId=id;
	}
}
