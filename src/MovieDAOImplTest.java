import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MovieDAOImplTest {
	private static MovieDAOImpl movieDAOImpl=new MovieDAOImpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSearchMovie() {
		movieDAOImpl.searchMovie("֮");
	}

	@Test
	public void testSelectMovie() {
		movieDAOImpl.selectMovie(2);
	}

}
