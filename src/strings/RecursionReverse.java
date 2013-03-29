package strings;

public class RecursionReverse
{
    public static void main(String args[])
    {
        String input = "input";
        System.out.println(reverse(input));
    }

    private static String reverse(String input)
    {
        if (input.equals(""))
        {
            return "";
        }
        else
        {
            int length = input.length();
            return input.substring(length - 1) + reverse(input.substring(0, length - 1));
        }
    }
}
