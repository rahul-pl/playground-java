package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Balances
{
    private static Map<Integer, balance> balances;

    static class added
    {
        int label;
        int l = 0;
        int r = 0;
    }

    static class balance
    {
        int label;
        List<balance> lBalances;
        List<balance> rBalances;
        int lw;
        int rw;

        balance(int label)
        {
            System.out.println("created balance " + label);
            this.label = label;
            lBalances = new ArrayList<balance>();
            rBalances = new ArrayList<balance>();
        }

        int weight()
        {
            int w = 10 +lw + rw;
            for (balance b : lBalances)
            {
                w += b.weight();
            }
            for (balance b : rBalances)
            {
                w += b.weight();
            }
            return w;
        }
    }

    public static void main(String args []) throws IOException
    {
        balances = new HashMap<Integer, balance>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++)
        {
            System.out.println("looking at " + i);
            balance b;
            if ((b = balances.get(i)) == null)
            {
                System.out.println("does not exist");
                b = new balance(i);
                balances.put(i, b);
            }

            String[] lParts= br.readLine().split(" ");
            b.lw = Integer.parseInt(lParts[0]);
            System.out.println("in left weight was " + b.lw);
            for (int j = 1; j < lParts.length; j++)
            {
                int newLabel = Integer.parseInt(lParts[j]);
                balance nb = new balance(newLabel);
                balances.put(newLabel, nb);
                b.lBalances.add(nb);
            }

            String[] rParts= br.readLine().split(" ");
            b.rw = Integer.parseInt(rParts[0]);
            System.out.println("in right weight was " + b.rw);
            for (int j = 1; j < rParts.length; j++)
            {
                int newLabel = Integer.parseInt(rParts[j]);
                balance nb = new balance(newLabel);
                balances.put(newLabel, nb);
                b.rBalances.add(nb);
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        balance(balances.get(0));
    }

    private static int balance(balance b)
    {
        System.out.println("balancing " + b.label + " lw " + b.lw + " rw " + b.rw + " lSize " + b.lBalances.size() + " rSize " + b.rBalances.size());
        int lSum = b.lw;
        for (balance bal : b.lBalances)
        {
            lSum += balance(bal);
        }

        int rSum = b.rw;
        for (balance bal : b.rBalances)
        {
            rSum += balance(bal);
        }

        added added = new added();

        System.out.println("node " + b.label + " -> l total " + lSum + " rTotal " + rSum);
        if (lSum < rSum)
        {
            added.label = b.label;
            added.l = rSum - lSum;
            b.lw += added.l;
            System.out.println("added to left of " + b.label + " " + added.l);
        }
        else if (rSum < lSum)
        {
            added.label = b.label;
            added.r = lSum - rSum;
            b.rw += added.r;
            System.out.println("added to right of " + b.label + " " + added.r);
        }

        return b.weight();
    }
}
