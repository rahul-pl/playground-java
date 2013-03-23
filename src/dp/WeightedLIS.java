package dp;

import java.io.*;

public class WeightedLIS
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true)
        {
            Node[] nodes = parse(br);
            if (nodes == null)
            {
                br.close();
                return;
            }

            long[] result = new long[nodes.length];
            for (int i = 0; i < nodes.length; i++)
            {
//                System.out.println("present " + i);
                Node presentNode = nodes[i];
//                System.out.println("value " + presentNode.value + " weight " + presentNode.weight);
                long required = presentNode.weight;
                for (int j = 0; j < i; j++)
                {
//                    System.out.println("other " + j);
                    Node otherNode = nodes[j];
//                    System.out.println("value " + otherNode.value + " weight " + otherNode.weight);
                    if (presentNode.value > otherNode.value)
                    {
                        required = Math.max(required, result[j] + presentNode.weight);
                    }
                }
//                System.out.println("result " + i + " is " + required);
                result[i] = required;
            }

            long answer = 0;
            for (int i = 0; i < result.length; i++)
            {
                answer = Math.max(answer, result[i]);
            }
//            System.out.println("answer is " + answer);
            System.out.println(answer);
        }
    }

    private static Node[] parse(BufferedReader br) throws IOException
    {
        String s = br.readLine();
        int numNodes = Integer.parseInt(s);

        if (numNodes == 0)
        {
            return null;
        }

        Node[] nodes = new Node[numNodes];

        for (int i = 0; i < numNodes; i++)
        {
            nodes[i] = new Node();
        }

        String[] values = br.readLine().split(" ");

        for (int i = 0; i < numNodes; i++)
        {
            nodes[i].value = Integer.parseInt(values[i]);
        }

        values = br.readLine().split(" ");
        for (int i = 0; i < numNodes; i++)
        {
            nodes[i].weight = Integer.parseInt(values[i]);
        }

        return nodes;
    }

    public static class Node
    {
        public int value;
        public int weight;
    }
}
