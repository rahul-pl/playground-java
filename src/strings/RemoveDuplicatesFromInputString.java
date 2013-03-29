package strings;

/*
http://www.geeksforgeeks.org/remove-all-duplicates-from-the-input-string/
QUICKSORT
*/

public class RemoveDuplicatesFromInputString
{
    public static void main(String args [])
    {
        String input = "zzzzabcxyzaam";
        char[] chars = input.toCharArray();
        sort(chars, 0, chars.length - 1);
        System.out.println(chars);
    }

    private static void sort(char[] chars, int start, int end)
    {
        System.out.println("sorting in position " + start + " and " + end + " of " + new String(chars));
        if (end - start <= 1)
        {
        }
        else
        {
            int pivot = end;
            int nextPosition = start;
            for (int i = start; i < end; i++)
            {
                if (chars[i] < chars[pivot])
                {
                    swap(chars, i, nextPosition);
                    nextPosition++;
                }
            }
            System.out.println("swapping pivot");
            swap(chars, pivot, nextPosition);
            System.out.println(new String(chars));
            sort(chars, start, nextPosition - 1);
            sort(chars, nextPosition + 1, end);
        }
    }

    private static void swap(char[] chars, int i, int nextPosition)
    {
        System.out.println("swapping " + chars[i] + " to position " + nextPosition);
        char temp = chars[i];
        chars[i] = chars[nextPosition];
        chars[nextPosition] = temp;
    }
}
