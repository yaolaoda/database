import java.sql.Date;


public class ActingStaff {
	private int staffId;
	private String chineseName;
	private String foreignName;
	private String moreChineseName;
	private String moreForeignName;
	private String sex;
	private String constellation;
	private Date birthday;
	private String birthplace;
	private String profession;
	private String familyMember;
	private String imdbLink;
	
	public int getStaffId(){
		return this.staffId;
	}
	
	public void setStaffId(int id){
		this.staffId=id;
	}
	
	public String getChineseName(){
		return this.chineseName;
	}
	
	public void setChineseName(String name){
		this.chineseName=name;
	}
	
	public String getForeignName(){
		return this.foreignName;
	}
	
	public void setForeignName(String name){
		this.foreignName=name;
	}
	
	public String getMoreChineseName(){
		return this.moreChineseName;
	}
	
	public void setMoreChineseName(String name){
		this.moreChineseName=name;
	}
	
	public String getMoreForeignName(){
		return this.moreForeignName;
	}
	
	public void setMoreForeignName(String name){
		this.moreForeignName=name;
	}
	
	public String getSex(){
		return this.sex;
	}
	
	public void setSex(String sex){
		this.sex=sex;
	}
	
	public String getConstellation(){
		return this.constellation;
	}
	
	public void setConstellation(String constellation){
		this.constellation=constellation;
	}
	
	public Date getBirthday(){
		return this.birthday;
	}
	
	public void setBirthday(Date birthday){
		this.birthday=birthday;
	}
	
	public String getBirthplace(){
		return this.birthplace;
	}
	
	public void setBirthplace(String birthplace){
		this.birthplace=birthplace;
	}
		
	public String getProfession(){
		return this.profession;
	}
	
	public void setProfession(String profession){
		this.profession=profession;
	}
	
	public String getFamilyMember(){
		return this.familyMember;
	}
	
	public void setFamilyMember(String member){
		this.familyMember=member;
	}
	
	public String getImdbLink(){
		return this.imdbLink;
	}
	
	public void setImdbLink(String link){
		this.imdbLink=link;
	}

}
