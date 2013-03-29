package backtracking;

public class StringPermutations
{
    public static void main(String args [])
    {
        String input = "input";

        permutate(input, 0);
    }

    private static void permutate(String input, int current)
    {
        if (current == input.length())
        {
            System.out.println("solution is " + input);
        }
        else
        {
            for (int i = current; i < input.length(); i++)
            {
                String swapped = swap(input, current, i);
                permutate(swapped, (current + 1));
            }
        }
    }

    private static String swap(String input, int j, int i)
    {
        StringBuffer buffer = new StringBuffer(input);
        char temp = buffer.charAt(i);
        buffer.setCharAt(i, buffer.charAt(j));
        buffer.setCharAt(j, temp);
        return buffer.toString();
    }
}
