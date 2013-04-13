package strings;

/*
Matcher : matcher[q] is the largest k such that Pk is a suffix of Pq
Only matcher completed, will do actually matching later
 */

public class KMP
{
    public static void main(String args [])
    {
        String input = "ababac";
        char[] chars = input.toCharArray();

        int[] kmpMatcher = generateMatcher(chars);

        print(kmpMatcher);
    }

    /*
    matcher[k] is the largest proper suffix of Pk
    which is also a prefix of P
     */
    private static int[] generateMatcher(char[] chars)
    {
        int[] matcher = new int[chars.length];
        matcher[0] = 0;
        for (int i = 1; i < chars.length; i++)
        {
            System.out.println("doing for " + i);
            int k = i - 1;
            System.out.println("k > 0 " + (k > 0));
            System.out.println("match " + (chars[k] == chars[i]));
            while (k > 0 && chars[k] != chars[i])
            {
                k = matcher[k];
            }
            if (chars[k] == chars[i])
            {
                k++;
            }
            System.out.println("setting " + i + " to " + k);
            matcher[i] = k;
        }
        return matcher;
    }

    private static void print(int[] kmpMatcher)
    {
        for (int i = 0; i < kmpMatcher.length; i++)
        {
            System.out.print(kmpMatcher[i] + " ");
        }
        System.out.println();
    }
}
