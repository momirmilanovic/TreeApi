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

        MyTree myTree1 = new MyTree(new Node(1000, new Person("founder 1000", 1000)));
        MyTree myTree2 = new MyTree(new Node(2000, new Person("founder 2000", 2000)));
        MyTree myTree3 = new MyTree(new Node(3000, new Person("founder 3000", 3000)));
        MyTree myTree4 = new MyTree(new Node(4000, new Person("founder 4000", 4000)));

        TreeListHandler.treeList.add(myTree1);
        TreeListHandler.treeList.add(myTree2);
        TreeListHandler.treeList.add(myTree3);
        TreeListHandler.addTree(myTree4);

        System.out.println("No. of trees: " + TreeListHandler.treeList.size());
        System.out.println("root of myTree3: " + TreeListHandler.treeList.get(2).getRoot().getNode());
        System.out.println("contains myTree3: " + TreeListHandler.treeList.contains(myTree3));
        System.out.println("index of myTree4: " + TreeListHandler.getTreeIndex(myTree4));
        TreeListHandler.printTree(myTree3);




    }

}

