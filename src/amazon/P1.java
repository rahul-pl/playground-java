package amazon;

public class P1
{
    public static void main(String args [])
    {
        int[] A = new int[]{4,3,4,5,6,7,8};
        int n = 6;
        System.out.println(firstOccurence(A, n));
    }

    static int firstOccurence(int[] A, int n)
    {
        int start = 0;
        int end = A.length - 1;
        boolean found = false;
        while (start <= end || A[start] != n)
        {
            if (A[start] == n)
            {
                found = true;
                break;
            }
            int modulo = Math.abs(A[start] - n);
            start += modulo;
        }
        if (found)
        {
            return start;
        }
        else
        {
            return -1;
        }
    }
}
