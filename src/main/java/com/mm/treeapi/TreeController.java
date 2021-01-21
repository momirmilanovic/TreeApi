package com.mm.treeapi;

import com.mm.mytree.MyTree;
import com.mm.mytree.Node;
import com.mm.persons.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreeController {

    @GetMapping("/")
    public String index() {
        return "TreeApi REST!";
    }

    @PostMapping("/createtree/{rootName}/{rootId}")
    public String createTree(@PathVariable String rootName, @PathVariable int rootId) {
        MyTree newTree = new MyTree(new Node(rootId, new Person(rootName, rootId)));
        TreeListHandler.addTree(newTree);
        return "Created tree " + newTree.getRoot().getNodeData();
    }
}
