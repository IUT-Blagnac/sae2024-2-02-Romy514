import unittest
import simplicite30


class TestSimplicite30(unittest.TestCase):

    def test_RLE(self):
        self.assertEqual(simplicite30.RLE("abc"), "1a1b1c")
        self.assertEqual(simplicite30.RLE("abbccc"), "1a2b3c")
        self.assertEqual(simplicite30.RLE("aaabaa"), "3a1b2a")
        self.assertEqual(simplicite30.RLE("aAa"), "1a1A1a")
        self.assertEqual(simplicite30.RLE("WWWWWWWWWWWWW"), "9W4W")

    def test_RLE_rec(self):
        self.assertEqual(simplicite30.RLE_rec("abc", 1), "1a1b1c")
        self.assertEqual(simplicite30.RLE_rec("abbccc", 1), "1a2b3c")
        self.assertEqual(simplicite30.RLE_rec("aaabaa", 1), "3a1b2a")
        self.assertEqual(simplicite30.RLE_rec("aAa", 1), "1a1A1a")
        self.assertEqual(simplicite30.RLE_rec("abc", 2), "111a111b111c")
        self.assertEqual(simplicite30.RLE_rec("abc", 3), "311a311b311c")

        message = ("13211321322113311213212322211P13211321322113311213212322211O"
                   "13211321322113311213212322211M13211321322113311213212322211P"
                   "13211321322113311213212322211O13211321322113311213212322211M"
                   "13211321322113311213212322211P13211321322113311213212322211U"
                   "13211321322113311213212322211R13211321322113311213212322211I"
                   "13211321322113311213212322211N")
        self.assertEqual(simplicite30.RLE_rec("POMPOMPURIN", 10), message)

    def test_unRLE(self):
        self.assertEqual(simplicite30.unRLE("1a1b1c"), "abc")
        self.assertEqual(simplicite30.unRLE("1a2b3c"), "abbccc")
        self.assertEqual(simplicite30.unRLE("3a1b2a"), "aaabaa")
        self.assertEqual(simplicite30.unRLE("1a1A1a"), "aAa")
        self.assertEqual(simplicite30.unRLE("9W4W"), "WWWWWWWWWWWWW")

    def test_unRLE_rec(self):
        self.assertEqual(simplicite30.unRLE_rec("1a1b1c", 1), "abc")
        self.assertEqual(simplicite30.unRLE_rec("1a2b3c", 1), "abbccc")
        self.assertEqual(simplicite30.unRLE_rec("3a1b2a", 1), "aaabaa")
        self.assertEqual(simplicite30.unRLE_rec("1a1A1a", 1), "aAa")
        self.assertEqual(simplicite30.unRLE_rec("111a111b111c", 2), "abc")
        self.assertEqual(simplicite30.unRLE_rec("311a311b311c", 3), "abc")


if __name__ == '__main__':
    unittest.main()
