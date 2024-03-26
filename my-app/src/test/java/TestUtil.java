import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }

  @Test
  public void testSizeOne() {
    assertFalse(c.compute(1));
  }

  @Test
  public void testEvenSize() {
    assertFalse(c.compute(1, 2, 3, 4));
  }

  @Test
  public void testArgumentZero() {
    try {
      c.compute(0, 1, 2);
      fail();
    } catch (RuntimeException e) {
        assertTrue(true);
    }
  }

  @Test
  public void testNoDivisor() {
    assertFalse(c.compute( 2, 2, 3));
  }

  @Test
  public void testDivisor() {
    assertTrue(c.compute( 1, 2, 3));
  }
}