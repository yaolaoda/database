import static org.junit.Assert.*;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;


public class ShortCommentDAOImplTest {
	private static ShortCommentDAOImpl commentImpl=new ShortCommentDAOImpl();
		
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearchShortComment() {
		commentImpl.searchShortComment(3);
	}

	@Test
	public void testInsertShortComment() {
		ShortComment comment=new ShortComment();
		comment.setNickname("Hetty");
		comment.setContent("ºÃ¿´µÄÓ´");
		comment.setMovieId(3);
		comment.setScore(5);
		Date date=new Date(System.currentTimeMillis());
		comment.setTime(date);
		comment.setUsefulCount(3025);
		commentImpl.insertShortComment(comment);
	}

}
