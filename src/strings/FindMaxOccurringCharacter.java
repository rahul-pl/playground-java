package strings;

/*
http://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/
*/

public class FindMaxOccurringCharacter
{
    public static void main(String args [])
    {
        String input = "testis counter ddd";
        int[] counter = new int[256];

        for (char c : input.toCharArray())
        {
            counter[(int) c]++;
        }

        int maxCount = 0;
        int maxItem = 0;
        for (int i = 0; i < counter.length; i++)
        {
            if (maxCount < counter[i])
            {
                maxCount = counter[i];
                maxItem = i;
            }
        }

        System.out.println("max char is " + (char) maxItem + " with count " + maxCount);
    }
}
