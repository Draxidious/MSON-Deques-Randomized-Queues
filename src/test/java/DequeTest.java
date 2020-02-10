

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class DequeTest {

	private Deque<String> list;

	@Before
	public void setup(){
		list = new Deque<String>();
		Deque<String> l2 = new Deque<String>();
		if(list == null)
			fail("You didn't set your list in the Configuration file.");
		if(list == l2)
			fail("You should return a new instance of list with each call to Configuration.getDeque()");
	}

	@Test (timeout = 500)
	public void testaddFirstIsEmptySizeAndRemoveFirst() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		list.addFirst("hello");
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		list.addFirst("world");
		assertEquals(2, list.size());
		list.addFirst("foo");
		assertEquals(3, list.size());
		assertEquals("First element should .equals \"foo\".", "foo", list.removeFirst());
		assertEquals("First element should .equals \"world\".", "world", list.removeFirst());
	}

	@Test (timeout = 500)
	public void testaddLastIsEmptySizeAndRemoveLast() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		list.addLast("hello");
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		list.addLast("world");
		assertEquals(2, list.size());
		list.addLast("foo");
		assertEquals(3, list.size());
		assertEquals("Last element should .equals \"foo\".", "foo", list.removeLast());
		assertEquals("Last element should .equals \"world\".", "world", list.removeLast());

	}


	@Test (timeout = 500)
	public void testaddFirstRemoveFirstSizeAndIsEmpty() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.addFirst("hello");
		list.addFirst("there");
		list.addFirst("world");
		assertEquals("List should now have 3 elements", 3, list.size());
		assertEquals("world", list.removeFirst());
		assertEquals("List should now have 2 elements", 2, list.size());
		assertEquals("there", list.removeFirst());
		assertEquals("List should now have 1 elements", 1, list.size());
		assertEquals("hello", list.removeFirst());
		assertEquals("List should now have 0 elements", 0, list.size());
		assertTrue("All elements removed, list should be empty.", list.isEmpty());
	}

	@Test (timeout = 500)
	public void testaddLastRemoveLastSizeAndIsEmpty() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		list.addLast("hello");
		list.addLast("there");
		list.addLast("world");
		assertEquals("List should now have 3 elements", 3, list.size());
		assertEquals("world", list.removeLast());
		assertEquals("List should now have 2 elements", 2, list.size());
		assertEquals("there", list.removeLast());
		assertEquals("List should now have 1 elements", 1, list.size());
		assertEquals("hello", list.removeLast());
		assertEquals("List should now have 0 elements", 0, list.size());
		assertTrue("All elements removed, list should be empty.", list.isEmpty());
	}

	@Test (timeout = 500, expected = NoSuchElementException.class)
	public void testExceptionOnEmptyRemoveFirst() {
		list.removeFirst();
	}

	@Test (timeout = 500, expected = NoSuchElementException.class)
	public void testExceptionOnEmptyRemoveLast() {
		list.removeLast();
	}

	@Test (timeout = 500)
	public void removeLastPrincetonTest1()
	{
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(1);
		int rem = deque.removeLast();
		assertEquals(1,rem);
		deque.addFirst(3);
		deque.addFirst(4);
		deque.addFirst(5);
		deque.addFirst(6);
		rem = deque.removeLast();
		assertEquals(3,rem);
		deque.addFirst(8);
		rem = deque.removeLast();
		assertEquals(4,rem);
	}

	@Test (timeout = 500)
	public void removeLastPrincetonTest2()
	{
		Deque<Integer> deque = new Deque<Integer>();
		deque.addFirst(1);
		int rem = deque.removeLast();
		assertEquals(1,rem);
		deque.addFirst(3);
		rem = deque.removeFirst();
		assertEquals(3,rem);
		deque.addLast(5);
		assertEquals(1,deque.size());

		deque.addFirst(7);

		rem = deque.removeFirst();

		assertEquals(7,rem);
	}

	@Test (timeout = 500)
	public void testIterator()
	{
		list.addFirst("Hello");
		list.addFirst("World");
		Iterator<String> iter = list.iterator();
		assertTrue(iter.hasNext());
		String cur = iter.next();
		assertEquals("Should be World but was "+cur,"World",cur );
		assertTrue(iter.hasNext());
		 cur = iter.next();
		assertEquals("Should be Hello but was "+cur,"Hello",cur );
		assertFalse(iter.hasNext());
	}

}
