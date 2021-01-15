package com.mm.treeapi;

import com.mm.mytree.MyTree;
import com.mm.mytree.Node;
import com.mm.persons.Person;


public class TreeApi {
    public static void main(String[] args) {

        System.out.println("TreeApi project");

        Node root = new Node(999, new Person("root", 999));

        Node p1 = root.addChild(new Node(1, new Person("p_1", 1)));
        Node p11 = p1.addChild(new Node(11, new Person("p_11", 11)));
        Node p111 = p11.addChild(new Node(111, new Person("p_111", 111)));
        Node p12 = p1.addChild(new Node(12, new Person("p_12", 12)));
        Node p121 = p12.addChild(new Node(121, new Person("p_121", 121)));
        Node p122 = p12.addChild(new Node(122, new Person("p_122", 122)));
        Node p13 = p1.addChild(new Node(13, new Person("p_13", 13)));

        Node p2 = root.addChild(new Node(2, new Person("p_2", 2)));
        Node p21 = p2.addChild(new Node(21, new Person("p_21", 21)));
        Node p22 = p2.addChild(new Node(22, new Person("p_22", 22)));
        Node p211 = p21.addChild(new Node(211, new Person("p_211", 211)));
        Node p2111 = p211.addChild(new Node(2111, new Person("p_2111", 2111)));
        Node p23 = p2.addChild(new Node(23, new Person("p_23", 23)));

       Node.printTree(root, "   ");

       System.out.println("delete node p12");
       p12.deleteNode();
       Node.printTree(root, "   ");


       System.out.println("TreeApi impl. with MyTree");
       MyTree myTree1 = new MyTree(new Node(1000, new Person("root", 1000)));
       Node mt_node1 = myTree1.getRoot().addChild(new Node(1, new Person("mt_1", 1)));
       Node mt_node2 = myTree1.getRoot().addChild(new Node(2, new Person("mt_2", 2)));
       Node mt_node3 = myTree1.getRoot().addChild(new Node(3, new Person("mt_3", 3)));

       Node mt_node11 = mt_node1.addChild(new Node(11, new Person("mt_11", 11)));
       Node mt_node12 = mt_node1.addChild(new Node(12, new Person("mt_12", 12)));

       Node mt_node21 = mt_node2.addChild(new Node(21, new Person("mt_21", 21)));
       Node mt_node22 = mt_node2.addChild(new Node(22, new Person("mt_22", 22)));

       Node mt_node211 = mt_node21.addChild(new Node(211, new Person("mt_211", 211)));

       myTree1.printTree(myTree1.getRoot(), "  ");

       System.out.println("delete mt_node21");
       myTree1.deleteNode(mt_node21);
       myTree1.printTree(myTree1.getRoot(), "  ");

       System.out.println("delete root");
       myTree1.deleteRootNode();
       myTree1.printTree(myTree1.getRoot(), "  ");

    }

}

