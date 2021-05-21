package com.mm.mytree;

import com.mm.treeapi.TreeListHandler;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyTree<T> {
    public String treeName;
    public Node<T> root;
    private Node searchedNode = null;
    private JSONObject jsonTree = new JSONObject();

    public MyTree(String treeName, Node root) {
        this.treeName = treeName;
        this.root = root;
        // this.parentNode = null;
    }

    public String getTreeName() {
        return this.treeName;
    }

    public Node getRoot() {
        return this.root;
    }

    public int getRootKey() {
        return this.root.getNodeKey();
    }

    public void setNewJsonTree() {
        this.jsonTree = new JSONObject();
    }

    public boolean deleteNode(Node<T> node) {
        boolean nodeFound = false;
        if (node.getParent() != null) {
            int index = node.getParent().getChildren().indexOf(node);
            if (index != -1) {
                node.getParent().getChildren().remove(node);
                for (Node<T> each : node.getChildren()) {
                    each.setParent(node.getParent());
                }
                node.getParent().getChildren().addAll(index, node.getChildren());
                nodeFound = true;
            }
        } else {
            if (node == this.getRoot()) {
                deleteRootNode();
                nodeFound = true;
            }
        }
        if (nodeFound) {
            node.getChildren().clear();
        }
        return nodeFound;
    }

    public void deleteRootNode() {
        Node<T> newParent = null;
        if (!this.root.getChildren().isEmpty()) {
            newParent = this.root.getChildren().get(0);
            newParent.setParent(null);
            this.root.getChildren().remove(0);
            for (Node<T> each : this.root.getChildren()) {
                each.setParent(newParent);
            }
            newParent.getChildren().addAll(this.root.getChildren());
        }
        this.root = newParent;
    }

    public <T> void printTree(String treeName) {
        for (MyTree t : TreeListHandler.treeList) {
            if (t.getTreeName().equals(treeName)) {
                t.printTree(t.getRoot(), " ");
            }
        }
    }


    public <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getNode());
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }

    public JSONObject treeToJson(Node<T> root) {
        System.out.println("current node: " + root.getNodeKey());
        if (root.getParent() != null) {
            jsonTree.put(String.valueOf(root.getNodeKey()), root.getParent().getNodeKey());
        } else {
            setNewJsonTree();
            jsonTree.put(String.valueOf(root.getNodeKey()), 0);
        }

        root.getChildren().forEach(each -> treeToJson((Node) each));
        return jsonTree;
    }


    public Node getNodeByKey(Node root, int nodeKey) {
        if (root.getNodeKey() == nodeKey) {
            searchedNode= root;
        }

        root.getChildren().forEach(each -> getNodeByKey((Node) each, nodeKey));
        return searchedNode;
    }

}
