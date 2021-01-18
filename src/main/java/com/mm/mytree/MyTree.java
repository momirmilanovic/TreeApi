package main.java.com.mm.mytree;

public class MyTree<T> {
    public Node<T> root;
    public MyTree(Node root) {
        this.root = root;
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

    public <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getNode());
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }
}
