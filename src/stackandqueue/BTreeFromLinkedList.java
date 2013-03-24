package stackandqueue;

/*
    PROBLEM URL : http://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
*/

import java.util.LinkedList;
import java.util.List;

public class BTreeFromLinkedList
{
    public static void main(String args[])
    {
        List<Node> nodes = new LinkedList<Node>()
        {
            {
                add(new Node() {{value = 1;}});
                add(new Node() {{value = 2;}});
                add(new Node() {{value = 3;}});
                add(new Node() {{value = 4;}});
                add(new Node() {{value = 5;}});
                add(new Node() {{value = 6;}});
                add(new Node() {{value = 7;}});
                add(new Node() {{value = 8;}});
                add(new Node() {{value = 9;}});
            }
        };

        List<Node> pendingParents = new LinkedList<Node>();
        int childSelected = 0;
        Node firstNode = nodes.remove(0);
        Node currentParent = firstNode;
        while (nodes.size() > 0)
        {
            Node currentNode = nodes.remove(0);
            switch (childSelected)
            {
                case 0:
                    System.out.println("Nodes " + currentParent.value + "\'s left child being set to " + currentNode.value);
                    currentParent.left = currentNode;
                    pendingParents.add(currentNode);
                    childSelected = 1;
                    break;
                case 1:
                    System.out.println("Nodes " + currentParent.value + "\'s right child being set to " + currentNode.value);
                    currentParent.right = currentNode;
                    pendingParents.add(currentNode);
                    currentParent = pendingParents.remove(0);
                    childSelected = 0;
                    break;
            }
        }

        printNode(firstNode, 0);
    }

    public static void printNode(Node n, int level)
    {
        for (int i = 0; i < level; i++)
        {
            System.out.print("-");
        }
        System.out.println(n.value);
        if (n.left != null)
        {
            printNode(n.left, (level + 1));
        }
        if (n.right != null)
        {
            printNode(n.right, (level + 1));
        }
    }
    public static class Node
    {
        Node left;
        Node right;
        int value;
    }
}
