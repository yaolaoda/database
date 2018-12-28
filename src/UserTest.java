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
		System.out.println("�������û���/����/�ֻ���");
		String input=sc.next();
		System.out.println("����������");
		String password=sc.next();
		
		User user=new User();
		user.setInput(input);
		user.setPassword(password);
		
		UserDAO ud=new UserDAOImpl();
		User user2=null;
		user2=ud.searchUser(user);
		if(user2!=null){
			System.out.println("��¼�ɹ�!");
			System.out.println("�����û�����"+user2.getUsername());
			System.out.println("�������䣺"+user2.getEmail());
			System.out.println("�����ֻ��ţ�"+user2.getTelephone());		
		}
	}

}
