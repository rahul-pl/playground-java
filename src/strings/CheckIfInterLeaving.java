package strings;

/*
http://www.geeksforgeeks.org/print-all-interleavings-of-given-two-strings/
 */

public class CheckIfInterLeaving
{
    public static void main(String args [])
    {
        String a = "AB";
        String b = "CD";
        String c = "ABCD";

        System.out.println(checkIfInterLeaving(c, a, b));
    }

    private static boolean checkIfInterLeaving(String c, String a, String b)
    {
        int pos = 0;
        while (true)
        {
            if ((ca(c, pos) != ca(a, pos)) && (ca(c, pos) != ca(a, pos)))
            {
                return false;
            }
            else if ((ca(c, pos) == ca(a, pos)) && (ca(c, pos) == ca(a, pos)))
            {
                //TODO
            }
            pos++;
        }
    }

    public static char ca(String s, int position)
    {
        return s.charAt(position);
    }
}
