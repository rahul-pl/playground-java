import java.util.Arrays;

public class NQueenRecursive
{
    public static void main(String args [])
    {
        int number = 4;
        int[] positions = new int[number];
        Arrays.fill(positions, -1);

//        print(positions);
        solve(positions, 0, number);
    }

    private static void solve(int[] positions, int filled, int number)
    {

        print(positions);
        if (safe(positions, filled))
        {
            if (filled == number)
            {
                System.out.println("found");
                print(positions);
            }
            else
            {
                System.out.println("filled is " + filled);
                for (int i = 0; i < positions.length; i++)
                {
                    positions[filled] = i;
                    solve(positions, (filled + 1), number);
                }
            }
        }
    }

    private static boolean safe(int[] positions, int filled)
    {
        for (int i = 0; i < filled; i++)
        {
            int ith = positions[i];
            for (int j = i+1; j < filled; j++)
            {
                int jth = positions [j];
                if ((ith == jth) || (Math.abs(ith -jth) == Math.abs(i - j)))
                {
//                    System.out.println("i is " + i + " j is " + j + " ith is " + ith + " jth is " + jth);
                    return false;
                }
            }
        }
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
