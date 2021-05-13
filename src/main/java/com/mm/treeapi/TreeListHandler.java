package com.mm.treeapi;

import com.mm.mytree.MyTree;
import com.mm.mytree.Node;

import java.util.List;
import java.util.LinkedList;

public class TreeListHandler {

    public static List<MyTree> treeList = new LinkedList<MyTree>();

    public static String addTree(MyTree newTree) {
        try {
            treeList.add(newTree);
            return "Added " + newTree.getTreeName();
        } catch (Exception e) {
            System.out.println("Cannot add new tree " + newTree.getTreeName() + " because " + e);
        }
        return "Tree " + newTree.getTreeName() + " not added!";
    }

    public static String removeTree(String treeName) {
        MyTree toRemove = null;
        for(MyTree t: treeList)
        {
            System.out.println("remove check  " + treeName + " now " + t.getTreeName());
            if (t.getTreeName().equals(treeName)) {
                System.out.println("removing  " + treeName + " eq " + t.getTreeName());
                toRemove = t;
            };
        }
        if (toRemove != null) {
            treeList.remove(toRemove);
            return "Removed " + treeName;
        } else
            return "No " + treeName + " in treeList!";
    }

    public static boolean contains(MyTree tree) {
        if (treeList.contains(tree))
            return true;
        else
            return false;
    }

    public static MyTree getTree(String treeName) {
        for(MyTree t: treeList)
        {
            if (t.getTreeName().equals(treeName)) {
                return t;
            };
        }
        return null;
    }

    static int getTreeIndex(MyTree tree) {
        int i = 0;
        for(MyTree t: treeList)
        {
            if (t == tree) {
                return i;
            }
            i++;
        }
        return i;
    }

    public static String addNodeInTree(String treeName, Node node, int parentKey) {
        // System.out.println("addNodeInTree in " + treeName + ", add " + node.getNodeData() + ", to parent " + parentKey);
        for (MyTree t : treeList) {
            if (t.getTreeName().equals(treeName)) {
                if (t.getNodeByKey(t.getRoot(), parentKey) != null) {
                    t.getNodeByKey(t.getRoot(), parentKey).addChild(node);
                } else {
                    System.out.println("parentKey " + treeName + " not found");
                    t.getRoot().addChild(node);
                }
                return "Node " + node.getNodeKey() + " added in " + treeName;
            }
        }
        return "Tree " + treeName + " not found!";
    }

    public static String deleteNodeFromTree(String treeName, int nodeKey) {
        // boolean treeFound = false;
        for (MyTree t : treeList) {
            if (t.getTreeName().equals(treeName)) {
                // treeFound = true;
                if (t.deleteNode(t.getNodeByKey(t.getRoot(), nodeKey))) {
                    return "Deleted " + nodeKey + " from " + treeName;
                } else {
                    return "No " + nodeKey + " in " + treeName + " tree.";
                }
            }
        }
        return "Tree " + treeName + " not found!";
    }

}
