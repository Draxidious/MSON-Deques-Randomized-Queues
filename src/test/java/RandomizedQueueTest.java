import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class RandomizedQueueTest {
    RandomizedQueue<String> rq;
	@Before
	public void setUp() throws Exception {
		rq = new RandomizedQueue<String>();
	}

	@Test
	public void testIsEmpty() {

		rq.enqueue("Hi");
		assertFalse(rq.isEmpty());
		rq.dequeue();
		assertTrue(rq.isEmpty());
	}

	@Test
	public void testSize() {
		rq.enqueue("Hi");
		assertEquals(1, rq.size());
		rq.enqueue("Hello");
		assertEquals(2, rq.size());
		rq.dequeue();
		assertEquals(1, rq.size());
		rq.dequeue();
		assertEquals(0, rq.size());
	}

	@Test
	public void testEnqueue() {
		ArrayList<String> expectedResults = new ArrayList<String>();
		expectedResults.add("Hello");
		expectedResults.add("World");
		rq.enqueue("Hello");
		rq.enqueue("World");
		assertEquals(2, rq.size());
		String actualResult = rq.dequeue();
		assertTrue("should contain "+actualResult, expectedResults.contains((actualResult)));
		actualResult =  rq.dequeue();
		assertTrue("should contain the other word "+actualResult, expectedResults.contains((actualResult)));

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
		rq.enqueue("Hello");
		rq.enqueue("World");
		rq.enqueue("Ack");
		ArrayList<String> check = new ArrayList<>();
		check.add("Hello");
		check.add("World");
		check.add("Ack");
		assertEquals("Should be in check, and should not be repeated: ",true,check.contains(rq.sample()));
		assertEquals("Should be in check, and should not be repeated: ",true,check.contains(rq.sample()));
		assertEquals("Should be in check, and should not be repeated: ",true,check.contains(rq.sample()));


	}

	@Test
	public void testIterator() {
		rq.enqueue("Hello");
		rq.enqueue("World");
		rq.enqueue("Ack");
		ArrayList<String> check = new ArrayList<>();
		check.add("Hello");
		check.add("World");
		check.add("Ack");

		Iterator<String> iter = rq.iterator();
		assertTrue(iter.hasNext());
		String cur = iter.next();
		assertEquals("Should be in check, and should not be repeated: "+cur,true,check.contains(cur));
		check.remove(cur);
		assertTrue(iter.hasNext());
		cur = iter.next();
		assertEquals("Should be in check, and should not be repeated: "+cur,true,check.contains(cur));
		check.remove(cur);
		assertTrue(iter.hasNext());
		cur = iter.next();
		assertEquals("Should be in check, and should not be repeated: "+cur,true,check.contains(cur));
		check.remove(cur);
		assertFalse(iter.hasNext());
	}

}
