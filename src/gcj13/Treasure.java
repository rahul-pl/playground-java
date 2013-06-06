package gcj13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Treasure
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args []) throws IOException
    {
        int numCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numCases; i++)
        {
            String[] parts = br.readLine().split(" ");

            int numKeys = Integer.parseInt(parts[0]);
            int numChests = Integer.parseInt(parts[1]);

            ArrayList<String> keys = new ArrayList<String>();
            parts = br.readLine().split(" ");
            for (int j = 0; j < numKeys; j++)
            {
                keys.add(parts[j]);
            }

            Chest[] chests = new Chest[numChests];
            for (int j = 0; j < numChests; j++)
            {
                parts = br.readLine().split(" ");
                Chest chest = new Chest();
                chest.index = j + 1;
                chest.keyToOpen = parts[0];

                int numKeysContained = Integer.parseInt(parts[1]);
                Set<String> keysContained = new HashSet<String>();
                for (int k = 0; k < numKeysContained; k++)
                {
                    keysContained.add(parts[k + 2]);
                }
                chest.keysContained = keysContained;

                chests[j] = chest;
            }

            System.out.println("chests size " + chests.length + " keys " + keys.size());

            ArrayList<Chest> result = solve(chests, keys, new ArrayList<Chest>());

            System.out.print("Case #" + (i + 1) + ": ");
            if (result == null)
            {
                System.out.println("IMPOSSIBLE");
            }
            else
            {
                for (int z = 0; z < result.size(); z++)
                {
                    System.out.print(result.get(z).index + " ");
                }
                System.out.println();
            }
        }
    }

    private static ArrayList<Chest> solve(Chest[] chests, ArrayList<String> keys, ArrayList<Chest> result) throws IOException {
        br.readLine();

        System.out.println("at level " + result.size());

        System.out.print("selected ");
        for (int z = 0; z < result.size(); z++)
        {
            System.out.print(result.get(z).index + " ");
        }
        System.out.println();

        System.out.print("keys ");
        for (int z = 0; z < keys.size(); z++)
        {
            System.out.print(keys.get(z) + " ");
        }
        System.out.println();

        if (result.size() == chests.length)
        {
            return result;
        }
        else
        {
            for (int i = 0; i < chests.length; i++)
            {
                if (chests[i] != null)
                {
                    Chest chest = chests[i];
                    if (keys.contains(chest.keyToOpen))
                    {
                        ArrayList<String> cloned = (ArrayList<String>) keys.clone();
                        cloned.remove(chest.keyToOpen);
                        chests[i] = null;
                        result.add(chest);
                        cloned.addAll(chest.keysContained);

                        ArrayList<Chest> answer = solve(chests, cloned, result);

                        if (answer == null)
                        {
                            chests[i] = chest;
                            result.remove(chest);
                        }
                        else
                        {
                            System.out.println("ret ans");
                            return answer;
                        }
                    }
                }
            }
            System.out.println("ret null");
            return null;
        }
    }

    static class Chest
    {
        int index;
        String keyToOpen;
        Set<String> keysContained;
    }
}
