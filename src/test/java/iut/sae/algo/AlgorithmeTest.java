package iut.sae.algo;

import org.junit.Test;

import iut.sae.algo.Algorithmes.simplicite31;
import junit.framework.TestCase;

public class AlgorithmeTest extends TestCase {

    /*
 * RLE("")=""
 * RLE("abc")="1a1b1c"
 * RLE("abbccc")="1a2b3c"
 * RLE("aaabaa")="3a1b2a"
 * RLE("aAa")="1a1A1a"
     */
    @Test
    public void testRLE() {
        assertEquals("", simplicite31.RLE(""));

        assertEquals("1a1b1c", simplicite31.RLE("abc"));
        assertEquals("1a2b3c", simplicite31.RLE("abbccc"));
        assertEquals("3a1b2a", simplicite31.RLE("aaabaa"));
        assertEquals("1a1A1a", simplicite31.RLE("aAa"));
        assertEquals("9W4W", simplicite31.RLE("WWWWWWWWWWWWW"));

    }


    /*
   * RLE(str, 1)=RLE(str)
   * RLE(str, 3)=RLE(RLE(RLE(str)))
     */
    @Test
    public void testRLERecursif() throws Exception {
        try {
            assertEquals("", simplicite31.RLE("", 1));
            assertEquals("", simplicite31.RLE("", 3));

            assertEquals("1a1b1c", simplicite31.RLE("abc", 1));
            assertEquals("1a2b3c", simplicite31.RLE("abbccc", 1));
            assertEquals("3a1b2a", simplicite31.RLE("aaabaa", 1));
            assertEquals("1a1A1a", simplicite31.RLE("aAa", 1));

            assertEquals("111a111b111c", (simplicite31.RLE("abc", 2)));
            assertEquals("311a311b311c", (simplicite31.RLE("abc", 3)));

        String message = "13211321322113311213212322211P13211321322113311213212322211O13211321322113311213212322211M13211321322113311213212322211P13211321322113311213212322211O13211321322113311213212322211M13211321322113311213212322211P13211321322113311213212322211U13211321322113311213212322211R13211321322113311213212322211I13211321322113311213212322211N";
        assertEquals(message,(simplicite31.RLE("POMPOMPURIN", 10)));
        } catch (Exception e) {
            fail("Exception inattendue");
        }
    }

    /*
  * unRLE(RLE(str))=str
  *
  * unRLE("")=""
  * unRLE("1a1b1c")="abc"
  * unRLE("1a2b3c")="abbccc"
  * unRLE("3a1b2a")="aaabaa"
  * unRLE("1a1A1a")="aAa"
     */
    @Test
    public void testUnRLE() {
        try {
            assertEquals("", simplicite31.unRLE(""));
            assertEquals("abc", simplicite31.unRLE("1a1b1c"));
            assertEquals("abbccc", simplicite31.unRLE("1a2b3c"));
            assertEquals("aaabaa", simplicite31.unRLE("3a1b2a"));
            assertEquals("aAa", simplicite31.unRLE("1a1A1a"));
            assertEquals("WWWWWWWWWWWWW", simplicite31.unRLE("9W4W"));
        } catch (Exception e) {
            fail("Exception inatendue");
        }
    }

    @Test
    public void testUnRLERecursif() {
        try {
            assertEquals("", simplicite31.unRLE("", 1));
            assertEquals("", simplicite31.unRLE("", 3));

            assertEquals("abc", simplicite31.unRLE("1a1b1c", 1));
            assertEquals("abbccc", simplicite31.unRLE("1a2b3c", 1));
            assertEquals("aaabaa", simplicite31.unRLE("3a1b2a", 1));
            assertEquals("aAa", simplicite31.unRLE("1a1A1a", 1));

            assertEquals("abc", (simplicite31.unRLE("111a111b111c", 2)));
            assertEquals("abc", (simplicite31.unRLE("311a311b311c", 3)));
        } catch (Exception e) {
            fail("Exception inattendue");
        }
    }
}
