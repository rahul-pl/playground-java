package backtracking;

import java.util.Arrays;

/*
    PROBLEM URL : http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
*/
public class NQueen
{
    public static void main(String args [])
    {
        int number = 3;
        int[] columns = new int[number];
        Arrays.fill(columns, -1);

//        print(columns);
        solve(columns, 0, number);
    }

    private static void solve(int[] columns, int nextRow, int number)
    {
        System.out.print("checking ");
        print(columns);
        if (nextRow == number)
        {
            System.out.print("found ");
            print(columns);
        }
        else
        {
            for (int column = 0; column < number; column++)
            {
                if (safeToAdd(column, nextRow, columns))
                {
                    columns[nextRow] = column;
                    solve(columns, nextRow + 1, number);
                    columns[nextRow] = -1;
                }
            }
        }
    }

    private static boolean safeToAdd(int column, int row, int[] columns)
    {
        for (int i = 0; i < row; i++)
        {
            if ((column == columns[i]) ||
                    (Math.abs(row - i) == Math.abs(column - columns[i])))
            {
                System.out.print("unsafe with " + column + " at position " + row + " | ");
                print(columns);
                return false;
            }
        }
        System.out.print("  safe with " + column + " at position " + row + " | ");
        print(columns);
        return true;
    }

    private static void print(int[] positions)
    {
        for (int i = 0; i < positions.length; i++)
        {
            System.out.print(positions[i] + " ");
        }
        System.out.println();
    }
}
