package amazon;

public class P2
{
    public static void main(String args [])
    {
        int[] A = new int[]{1};
        int[] B = new int[]{6, 4, 3, 2, 2};
        System.out.println(returnIndex(A, B));
    }

    static int returnIndex(int[] A, int[] B)
    {
        int lenB = B.length;
        int i = -1;
        while (((i + 1) < A.length) && ((i + 1) < lenB) && (A[i + 1] == B[lenB - 1 - (i + 1)]))
        {
//            System.out.println((i + 1) + " " + (lenB - 1 - (i + 1)) + " " +
//                                    A[(i + 1)] + " " + B[(lenB - 1 - (i + 1))]);
            i++;
        }
        return i;
    }
}
