package strings;

/*
http://www.geeksforgeeks.org/print-all-interleavings-of-given-two-strings/
 */

public class InterLeavings
{
    public static void main(String args [])
    {
        String s = "AB";
        String t = "UV";
        interleavings("", s, t);
    }

    private static void interleavings(String tillNow, String s, String t)
    {
        if (s.length() == 0)
        {
            System.out.println("found " + tillNow + t);
        }
        else if (t.length() == 0)
        {
            System.out.println("found " + tillNow + s);
        }
        else
        {
            interleavings(tillNow + s.charAt(0), s.substring(1), t);
            interleavings(tillNow + t.charAt(0), s, t.substring(1));
        }
    }
}
