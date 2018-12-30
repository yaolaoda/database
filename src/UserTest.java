import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;


public class UserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearchUser() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入用户名/邮箱/手机号");
		String input=sc.next();
		System.out.println("请输入密码");
		String password=sc.next();
		
		User user=new User();
		user.setInput(input);
		user.setPassword(password);
		
		UserDAO ud=new UserDAOImpl();
		User user2=null;
		user2=ud.searchUser(user);
		if(user2!=null){
			System.out.println("登录成功!");
			System.out.println("您的用户名："+user2.getUsername());
			System.out.println("您的邮箱："+user2.getEmail());
			System.out.println("您的手机号："+user2.getTelephone());		
		}
	}

}
