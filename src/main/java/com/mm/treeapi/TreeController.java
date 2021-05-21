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
        return TreeListHandler.addTree(new MyTree(treeName, new Node(rootId, new Person(rootName, rootId))));
    }

    @PostMapping("/addnodeintree/{treeName}/{nodeKey}/{parentKey}")
    public String addNodeInTree(@PathVariable String treeName, @PathVariable int nodeKey, @PathVariable int parentKey, @RequestBody String personName) {
        return TreeListHandler.addNodeInTree(treeName, new Node(nodeKey, new Person(personName, nodeKey)), parentKey);
    }

    @GetMapping("/showtree/{treeName}")
    public String printTree(@PathVariable String treeName) {
        if (TreeListHandler.getTree(treeName) != null) {
            TreeListHandler.getTree(treeName).printTree(treeName);
            return String.valueOf(TreeListHandler.getTree(treeName).treeToJson(TreeListHandler.getTree(treeName).getRoot()));
        } else {
            return "Tree " + treeName + " not found!";
        }


    }

    @GetMapping("/alltrees")
    public String allTrees() {
        System.out.println("Printing all trees:");
        try {
            for (MyTree t : TreeListHandler.treeList) {
                t.printTree(t.getTreeName());
            }
            return "Printed all trees (" + TreeListHandler.treeList.size() + ")";
        } catch (Exception e) {
            return "Printing all trees error: " + e;
        }
    }


    @DeleteMapping("/{treeName}")
    public String deleteTree(@PathVariable String treeName) {
        return TreeListHandler.removeTree(treeName);
    }

    @DeleteMapping("/{treeName}/{nodeKey}")
    public String deleteNode(@PathVariable String treeName, @PathVariable int nodeKey) {
        return  TreeListHandler.deleteNodeFromTree(treeName, nodeKey);
    }
}
