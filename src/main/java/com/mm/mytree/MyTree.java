package com.mm.mytree;

import com.mm.persons.Person;
import com.mm.treeapi.TreeListHandler;

import java.util.concurrent.atomic.AtomicReference;

public class MyTree<T> {
    public String treeName;
    public Node<T> root;

    public MyTree(String treeName, Node root) {
        this.treeName = treeName;
        this.root = root;
    }
    /*
    public MyTree(Node root) {
        this.treeName = "default name";
        this.root = root;
    }

     */

    public String getTreeName() {
        return this.treeName;
    }

    public Node getRoot() {
        return this.root;
    }

    public int getRootKey() {
        return this.root.getNodeKey();
    }

    public void deleteNode(Node<T> node) {
        if (node.getParent() != null) {
            int index = node.getParent().getChildren().indexOf(node);
            node.getParent().getChildren().remove(node);
            for (Node<T> each : node.getChildren()) {
                each.setParent(node.getParent());
            }
            node.getParent().getChildren().addAll(index, node.getChildren());
        } else {
            deleteRootNode();
        }
        node.getChildren().clear();
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
        System.out.println("printTree search for tree " + treeName);
        for (MyTree t : TreeListHandler.treeList) {
            if (t.getTreeName().equals(treeName)) {
                System.out.println("printTree printing tree " + t.getTreeName());
                t.printTree(t.getRoot(), " ");
            }
        }
    }

    public <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getNode());
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }


    public Node getNodeByKey(Node node, int nodeKey) {
        //System.out.println("current node: " + node.getNodeData() + ", nodeKey: " + nodeKey);
        final Node[] parentNode = {null};
        class CheckNodes {
            public CheckNodes(Node n, int key) {
                if (n.getNodeKey() == key) {
                    //System.out.println("same keys, node:" + n.getNodeData());
                    parentNode[0] = n;
                }
            }
        }

        node.getChildren().forEach(each -> new CheckNodes((Node) each, nodeKey));
        /*
        final Node[] parentNode = {null};
        class CheckNodes {
             void check(Node n, int key) {
                if (n.getNodeKey() == key) {
                    System.out.println("same keys, node:" + n.getNodeData());
                    parentNode[0] = n;
                }
            }
        }


        node.getChildren().forEach(each -> CheckNodes check = new CheckNodes()
                                           );
        */
        /*
        if (node.getNodeKey() == nodeKey) {
            System.out.println("same keys, node:" + node.getNodeData());
            return node;
        }
         */
        //node.getChildren().forEach(each -> getNodeByKey((Node) each, nodeKey));
        // node.getChildren().forEach(each -> checkNodeKey());

        return parentNode[0];
    }

}
