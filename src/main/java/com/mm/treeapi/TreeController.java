package com.mm.treeapi;

import com.mm.mytree.MyTree;
import com.mm.mytree.Node;
import com.mm.persons.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class TreeController {

    @GetMapping("/")
    public String index() {
        return "TreeApi project.";
    }

    @PostMapping("/createtree/{treeName}/{rootName}/{rootId}")
    public String createTree(@PathVariable String treeName, @PathVariable String rootName, @PathVariable int rootId) {
        TreeListHandler.addTree(new MyTree(treeName, new Node(rootId, new Person(rootName, rootId))));
        return "Created tree " + treeName;
    }

    @PostMapping("/addnodeintree/{treeName}/{nodeKey}/{parentKey}")
    public String addNodeInTree(@PathVariable String treeName, @PathVariable int nodeKey, @PathVariable int parentKey, @RequestBody String personName) {
        TreeListHandler.addNodeInTree(treeName, new Node(nodeKey, new Person(personName, nodeKey)), parentKey);
        return "Added " + nodeKey + " in tree " + treeName;
    }

    @GetMapping("/printtree/{treeName}")
    public String printTree(@PathVariable String treeName) {
        TreeListHandler.getTree(treeName).printTree(treeName);
        return "Printed tree " + treeName;
    }

    @GetMapping("/alltrees")
    public String allTrees() {
        System.out.println("Printing all trees:");
        for (MyTree t : TreeListHandler.treeList) {
            t.printTree(t.getTreeName());
        }
        return "Printed all trees (" + TreeListHandler.treeList.size() + ")";
    }


    @DeleteMapping("/{treeName}")
    public String deleteTree(@PathVariable String treeName) {
        TreeListHandler.removeTree(treeName);
        return "Delete " + treeName;
    }

    @DeleteMapping("/{treeName}/{nodeKey}")
    public String deleteNode(@PathVariable String treeName, @PathVariable int nodeKey) {
        TreeListHandler.deleteNodeFromTree(treeName, nodeKey);
        return "Deleted node " + nodeKey + " from " + treeName;
    }
}
