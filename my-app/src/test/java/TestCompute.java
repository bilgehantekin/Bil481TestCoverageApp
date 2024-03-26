import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testZeroSize() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    when(mq.size()).thenReturn(0);
    assertEquals(-1, c.countNumberOfOccurrences("a"));
  }

  @Test
  public void testNoOccurrences() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    when(mq.size()).thenReturn(3);
    when(mq.contains("x")).thenReturn(false);
    when(mq.getAt(0)).thenReturn("y");
    when(mq.getAt(1)).thenReturn("y");
    when(mq.getAt(2)).thenReturn("y");
    assertEquals(0, c.countNumberOfOccurrences("x"));
  }

  @Test
  public void testOccurrences() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    when(mq.size()).thenReturn(3);
    when(mq.contains("x")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("x");
    when(mq.getAt(1)).thenReturn("y");
    when(mq.getAt(2)).thenReturn("x");
    assertEquals(2, c.countNumberOfOccurrences("x"));
  }
}