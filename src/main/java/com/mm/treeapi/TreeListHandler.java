package com.mm.treeapi;

import com.mm.mytree.MyTree;
import com.mm.mytree.Node;

import java.util.List;
import java.util.LinkedList;

class TreeListHandler {

    public static List<MyTree> treeList = new LinkedList<MyTree>();

    public static void addTree(MyTree newTree) {
        treeList.add(newTree);
    }

    public static boolean contains(MyTree tree) {
        if (treeList.contains(tree))
            return true;
        else
            return false;
    }

    static int getTreeIndex(MyTree tree) {
        int i = 0;
        for(MyTree t: treeList)
        {
            if (t == tree) {
                return i;
            } else {
                i++;
            }
        }
        return i;
    }


    // Add bottom method to work with tree's root instead name

    /*
    public static void addNodeInTree(MyTree tree, Node node, Node parent) {
        if (treeList.contains(tree)) {
            for(MyTree t: treeList)
            {
                if (t == tree) {
                    t.getRoot().addChild(node);
        } else {
            System.out.println("Exception");
        }
    }

     */

    public static void printTree(MyTree tree) {
        if (treeList.contains(tree)) {
            for (MyTree t : treeList) {
                if (t == tree) {
                    t.printTree(t.getRoot(), "  ");
                }
            }
        } else {
            System.out.println("Exception");
        }
    }

}
