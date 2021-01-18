package main.java.com.mm.mytree;

import java.util.List;
import java.util.ArrayList;

public class Node<T>{
    private int key;
    private T data;
    private Node<T> parent = null;

    private List<Node<T>> children = new ArrayList<>();

    public Node(int key) {
        this.key = key;
    }

    public Node(int key, T data) {
        this.key = key;
        this.data = data;
    }

    public void setNodeData(T data) {
        this.data = data;
    }

    public Node addChild(Node child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public int getNodeKey() {
        return this.key;
    }

    public T getNodeData() {
        return this.data;
    }

    public String getNode() {
        return getNodeKey() + ": " + getNodeData();
    }

    public Node<T> getParent() {
        return this.parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void deleteNode() {
        if (parent != null) {
            System.out.println("node parent: " + this.getParent().getNode());
            int index = this.parent.getChildren().indexOf(this);
            System.out.println("node index: " + index);
            System.out.println("this node: " + this.getNode());
            this.parent.getChildren().remove(this);
            for (Node<T> each : getChildren()) {
                each.setParent(this.parent);
            }
            this.parent.getChildren().addAll(index, this.getChildren());
        } else {
            deleteRootNode();
        }
        this.getChildren().clear();
    }

    public Node<T> deleteRootNode() {
        if (parent != null) {
            throw new IllegalStateException("deleteRootNode not called on root");
        }
        Node<T> newParent = null;
        if (!getChildren().isEmpty()) {
            newParent = getChildren().get(0);
            newParent.setParent(null);
            getChildren().remove(0);
            for (Node<T> each : getChildren()) {
                each.setParent(newParent);
            }
            newParent.getChildren().addAll(getChildren());
        }
        this.getChildren().clear();
        return newParent;
    }

    public static <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getNode());
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }

}
