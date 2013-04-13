package dp;

/*
http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
 */

import java.util.Arrays;

public class PalindromePartitioningUsingMemoization
{
    static int[][] memoizedSolutions;

    public static void main(String args [])
    {
        String input = "abcbaaa";
        int length = input.length();
        memoizedSolutions = new int[length][length];
        fill(memoizedSolutions);

        maxPartition(input, 0, length);

        print(memoizedSolutions);
    }

    private static void fill(int[][] memoizedSolutions)
    {
        for (int i = 0; i < memoizedSolutions.length; i++)
        {
            int[] current = memoizedSolutions[i];
            Arrays.fill(current, -1);
        }
    }

    private static int maxPartition(String input, int start, int end)
    {
        if (memoizedSolutions[start][end] != -1)
        {
            return memoizedSolutions[start][end];
        }
        else if (start == end)
        {
            memoizedSolutions[start][end] = 0;
            return 0;
        }
        else
        {
            int min = end - start;
            for (int k = start; k < end; k++)
            {
                min = Math.min(min, (maxPartition(input, start, k) + maxPartition(input, k + 1, end)));
            }
            memoizedSolutions[start][end] = min;
            return min;
        }
    }

    private static void print(int[][] memoizedSolutions)
    {
        for (int i = 0; i < memoizedSolutions.length; i++)
        {
            int[] current = memoizedSolutions[i];
            for (int j = 0; j < current.length; j++)
            {
                System.out.print(current[j] + " ");
            }
            System.out.println();
        }
    }
}
