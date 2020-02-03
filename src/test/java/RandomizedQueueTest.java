import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RandomizedQueueTest {
    RandomizedQueue<String> rq;
	@Before
	public void setUp() throws Exception {
		rq = new RandomizedQueue<String>();
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnqueue() {
		fail("Not yet implemented");
	}

	@Test
	public void testDequeue() {
		ArrayList<String> expectedResults = new ArrayList<String>();
		expectedResults.add("Hello");
		expectedResults.add("World");
		rq.enqueue("Hello");
		rq.enqueue("World");
		String actualResult = rq.dequeue();
		assertTrue("should contain "+actualResult, expectedResults.contains((actualResult)));
		actualResult =  rq.dequeue();
		assertTrue("should contain the other word "+actualResult, expectedResults.contains((actualResult)));
	}

	@Test
	public void testSample() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

}
