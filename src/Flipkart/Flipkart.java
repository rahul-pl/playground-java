package Flipkart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class Flipkart
{
    public static void main(String args[] ) throws Exception
    {
        int rootIndex = -1;
        HashMap<Integer, List<Integer>> nodes = new HashMap<Integer, List<Integer>>();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(br.readLine());
        String[] parentArray = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
        {
            int parentIndex = Integer.parseInt(parentArray[i]);
            if (parentIndex == -1)
            {
                rootIndex = i;
            }
            else
            {
                if (!nodes.containsKey(parentIndex))
                {
                    nodes.put(parentIndex, new ArrayList<Integer>());
                }
                nodes.get(parentIndex).add(i);
            }
        }
        ArrayList<ArrayList<Integer>> children = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentLevel = new ArrayList<Integer>();
        currentLevel.add(rootIndex);
        children.add(currentLevel);

        while (true)
        {
            ArrayList<Integer> nextLevel = new ArrayList<Integer>();
            for (Integer i : currentLevel)
            {
                if (nodes.get(i) != null)
                {
                    nextLevel.addAll(nodes.get(i));
                }
            }
            if (nextLevel.size() == 0)
            {
                break;
            }
            children.add(nextLevel);
            currentLevel = nextLevel;
        }

        ListIterator<ArrayList<Integer>> iterator = children.listIterator(children.size());
        while (iterator.hasPrevious())
        {
            ArrayList<Integer> integers = iterator.previous();
            StringBuilder builder = new StringBuilder();
            for (Integer integer : integers)
            {
                builder.append(integer).append(" ");
            }
            String ans = builder.toString();
            ans = ans.substring(0, ans.length() - 1);
            System.out.println(ans);
        }
    }
}
