package dp;

import java.io.*;
import java.util.ArrayList;

public class TwoParts
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            int[] integers = parse(br);
            if (integers == null)
            {
                br.close();
                return;
            }

            int sum = 0;

            for (int i = 0; i < integers.length; i++)
            {
                sum += integers[i];
            }

//            System.out.println("sum " + sum);

            int half = sum/2;

//            System.out.println("half " + half);

            boolean[] possible = new boolean[half + 1];

            possible[0] = true;

            for (int i = 0; i < integers.length; i++)
            {
                int number = integers[i];
                ArrayList<Integer> newPossibles = new ArrayList<Integer>();
                for (int k = 0; k < half - number + 1; k++)
                {
                    if (possible[k])
                    {
//                        System.out.println("adding to possibles " + (k + number));
                        newPossibles.add(k + number);
                    }
                }

                for (int k = 0; k < newPossibles.size(); k++)
                {
//                    System.out.println("setting true -> " + newPossibles.get(k));
                    possible[newPossibles.get(k)] = true;
                }
            }

            for (int i = possible.length - 1; i >= 0; i--)
            {
//                System.out.println("testing " + i);
                if (possible[i])
                {
//                    System.out.println("possible");
//                    System.out.println("solution is " + (sum - 2*i));
                    System.out.println(sum - 2*i);
                    break;
                }
            }
        }
    }

    public static int[] parse(BufferedReader br) throws IOException
    {
        int length = Integer.parseInt(br.readLine());
//        System.out.println("length is " + length);
        if (length == 0)
        {
            return null;
        }


        String[] strings = br.readLine().split(" ");
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++)
        {
            numbers[i] = Integer.parseInt(strings[i]);
            if (numbers[i] < 0)
            {
                numbers[i] *= -1;
            }
//            System.out.print(numbers[i] + " ");
        }
//        System.out.println();
//        System.out.println();
        return numbers;
    }
}
