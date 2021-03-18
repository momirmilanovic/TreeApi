package com.mm.treeapi;

import com.mm.mytree.MyTree;
import com.mm.mytree.Node;

import java.util.List;
import java.util.LinkedList;

public class TreeListHandler {

    public static List<MyTree> treeList = new LinkedList<MyTree>();

    public static void addTree(MyTree newTree) {
        treeList.add(newTree);
    }

    public static void removeTree(String treeName) {
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
        } else
            System.out.println("No " + treeName + " in treeList");
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

    // Add bottom method to work with tree's root instead name
    public static void addNodeInTree(String treeName, Node node, int parentKey) {
        // System.out.println("addNodeInTree in " + treeName + " add " + node.getNodeData() + " to parent " + parentKey);
        for (MyTree t : treeList) {
            if (t.getTreeName().equals(treeName)) {
                // System.out.println("same " + t.getTreeName() + " and " + treeName);
                t.getNodeByKey(t.getRoot(), parentKey).addChild(node);
            }
        }
    }

    public static void deleteNodeFromTree(String treeName, int nodeKey) {
        for (MyTree t : treeList) {
            if (t.getTreeName().equals(treeName)) {

            }
        }
    }

    // TO CONSIDER!
    public static void addNodeInTree(String treeName, Node node, Node parent) {
        // System.out.println("in " + treeName + " add " + node.getNodeData() + " to parent " + parent.getNodeData());
        for (MyTree t : treeList) {
            if (t.getTreeName() == treeName) {
                // System.out.println("same " + t.getTreeName() + " and " + treeName);
                addNode(t.getRoot(), t.getRoot(), node);
            }
        }
    }

    public static void addNode(Node parent, Node parentRef, Node node) {
        // System.out.println("current check " +  parent.getNodeData());
        if (parent == parentRef) {
            parent.addChild(node);
        }
        parent.getChildren().forEach(each ->  addNode((Node) each, parentRef, node));
    }

}
