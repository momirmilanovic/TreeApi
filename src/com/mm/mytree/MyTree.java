package com.mm.mytree;

public class MyTree<T> {
    public Node<T> root;
    public MyTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getNode());
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }

    public int getRootKey() {
        return this.root.getNodeKey();
    }

    public void deleteNode(Node<T> node) {
        if (node.getParent() != null) {
            int index = node.getParent().getChildren().indexOf(node);  // get index of node in parent's children list
            node.getParent().getChildren().remove(node);            // remove node from parent's children list
            for (Node<T> each : node.getChildren()) {                  // set parent for every node from children list
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
}
