package gcj13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe
{
    public static void main(String args []) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCases = Integer.parseInt(br.readLine());

        String s;
        for (int i = 0; i < numCases; i++)
        {
            char[][] board = new char[4][4];
            for (int j = 0; j < 4; j++)
            {
                s = br.readLine();
                for (int k = 0; k < 4; k++)
                {
                    board[j][k] = s.charAt(k);
                }
            }

            br.readLine();

            checkHorizontally(board, 'X');
            checkVertically(board, 'X');
            checkDiagonally(board, 'X');
        }
    }

    private static boolean checkDiagonally(char[][] board, char wanted)
    {
        char[] req = new char[4];
        req[0] = board[0][0];
        req[1] = board[1][1];
        req[2] = board[2][2];
        req[3] = board[3][3];
        int count = 0;
        for (int i = 0 ; i < 4; i++)
        {
            if (req[i] == wanted)
            {
                count++;
            }
            else if (req[i] != 'T')
            {
                return false;
            }
        }
        if (count >= 3)
        {

        }
        return true;
    }

    private static boolean checkVertically(char[][] board, char wanted)
    {
        return true;
    }

    private static boolean checkHorizontally(char[][] board, char wanted)
    {
        return true;
    }
}
