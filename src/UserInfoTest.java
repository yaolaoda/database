import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;


public class UserInfoTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearch() throws SQLException {
		UserInfo userinfo=new UserInfo();
		userinfo.setUserId(1);
		
		UserInfoDAO uid=new UserInfoDAOImpl();
		UserInfo userinfo2=null;
		userinfo2=uid.search(userinfo);
		System.out.println("�����ǳƣ�"+userinfo2.getNickname());
		System.out.println("���ľ�ס�أ�"+userinfo2.getLocation());
		System.out.println("������Ƭ��"+userinfo2.getPhoto());
		System.out.println("�������ҽ��ܣ�"+userinfo2.getProfile());
		System.out.println("����ǩ������"+userinfo2.getSignature());
	}

	@Test
	public void testUpdate() throws SQLException {
		UserInfo userinfo=new UserInfo();
		userinfo.setUserId(1);
		UserInfoDAO uid=new UserInfoDAOImpl();
		UserInfo userinfo2=null;
		userinfo2=uid.search(userinfo);
		System.out.println("�����޸ģ�");
		Scanner sc=new Scanner(System.in);
		System.out.print("�����ǳƣ�");
		sc.nextLine();
		String nickname=sc.nextLine();
		if(nickname!=null && nickname.length()>0) userinfo2.setNickname(nickname);
		System.out.print("���ľ�ס�أ�");
		String location=sc.nextLine();
		if(location!=null && location.length()>0) userinfo2.setLocation(location);
		System.out.print("������Ƭ��");
		String photo=sc.nextLine();
		if(photo!=null && photo.length()>0) userinfo2.setPhoto(photo);
		System.out.print("�������ҽ��ܣ�");
		String profile=sc.nextLine();
		if(profile!=null && profile.length()>0) userinfo2.setProfile(profile);
		System.out.print("����ǩ������");
		String signature=sc.nextLine();
		if(signature!=null && signature.length()>0) userinfo2.setSignature(signature);
		uid.update(userinfo2);
	}

}
