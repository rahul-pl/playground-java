package strings;

/*

http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

!!! HAVE A PROBLEM FOR repeating character's case !!!

 */

public class StringPermutations
{
    public static void main(String args [])
    {
        String input = "baa";
        char[] chars = input.toCharArray();

        permutate(chars, 0);
    }

    private static void permutate(char[] chars, int i)
    {
//        System.out.println("permuting -> i " + i + " chars " + new String(chars));
        if (i == chars.length - 1)
        {
            System.out.println("found " + new String(chars));
        }
        else
        {
            for (int j = i; j < chars.length; j++)
            {
                if ((chars[i] != chars[j]) || (i == j))
                {
//                System.out.println("swapping i -> " + i + " " + chars[i] + " j -> " + j + " " + chars[j]);
                    swap(chars, i, j);
                    permutate(chars, i + 1);
                    swap(chars, i, j);
                }
            }
        }
    }

    private static void swap(char[] chars, int i, int j)
    {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
