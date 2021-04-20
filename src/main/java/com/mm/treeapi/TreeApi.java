package com.mm.treeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mm.mytree.MyTree;
import com.mm.mytree.Node;
import com.mm.persons.Person;


@SpringBootApplication
public class TreeApi {
    public static void main(String[] args) {

        SpringApplication.run(TreeApi.class, args);

        System.out.println("TreeApi project (v2)");

        MyTree myTree1 = new MyTree("myTree1", new Node(1000, new Person("founder 1000", 1000)));
        MyTree myTree2 = new MyTree("myTree2", new Node(2000, new Person("founder 2000", 2000)));
        MyTree myTree3 = new MyTree("myTree3", new Node(3000, new Person("founder 3000", 3000)));
        MyTree myTree4 = new MyTree("myTree4", new Node(4000, new Person("founder 4000", 4000)));

        TreeListHandler.addTree(myTree1);
        TreeListHandler.treeList.add(myTree2);
        TreeListHandler.treeList.add(myTree3);
        TreeListHandler.addTree(myTree4);

        System.out.println("No. of trees: " + TreeListHandler.treeList.size());
        System.out.println("root of myTree3: " + TreeListHandler.treeList.get(2).getRoot().getNode());
        System.out.println("contains myTree3: " + TreeListHandler.treeList.contains(myTree3));
        System.out.println("index of myTree4: " + TreeListHandler.getTreeIndex(myTree4));

        TreeListHandler.getTree("myTree3").getRoot().addChild(new Node(31, new Person("p_31", 31)));
        TreeListHandler.getTree("myTree3").getRoot().addChild(new Node(32, new Person("p_32", 32)));

        System.out.println("****************  11111111111111111:");
        TreeListHandler.getTree("myTree3").printTree("myTree3");
        TreeListHandler.addNodeInTree("myTree3", new Node(35, new Person("p_35", 35)), myTree3.getRoot().getNodeKey());
        System.out.println("****************  222222222222222222");
        TreeListHandler.getTree("myTree3").printTree("myTree3");
        System.out.println("****************  333333333333333333333333");
        TreeListHandler.addNodeInTree("myTree3", new Node(37, new Person("p_37", 37)), 32);
        System.out.println("****************  44444444444444444444444444444444444444");
        TreeListHandler.getTree("myTree3").printTree("myTree3");
        System.out.println("****************  55555555555555555555555555");
        TreeListHandler.deleteNodeFromTree("myTree3", 32);
        TreeListHandler.getTree("myTree3").printTree("myTree3");
        // TreeListHandler.getTree("myTree3").treeToJson(myTree3.getRoot());
    }

}

