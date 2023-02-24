package com.academy.learnprogramming;

import com.sun.source.tree.Tree;

public class Main {

    public static void main(String[] args) {
	Solution solution = new Solution();
    solution.maxDepth(new Solution.TreeNode(1,null,new Solution.TreeNode(2,new Solution.TreeNode(3,null,new Solution.TreeNode
            (4,null,new Solution.TreeNode(5,new Solution.TreeNode(6,new Solution.TreeNode(7,null,null),null),null))),null)));

//      solution.maxDepth(new Solution.TreeNode(3,new Solution.TreeNode(9),new Solution.TreeNode(20,new Solution.TreeNode(15),new Solution.TreeNode(7))));
//        solution.maxDepth(new Solution.TreeNode(1,new Solution.TreeNode(2, new Solution.TreeNode(4), new Solution.TreeNode(5)), new Solution.TreeNode(3)));
//      solution.maxDepth(new Solution.TreeNode(0));
//          solution.maxDepth(new Solution.TreeNode(1,new Solution.TreeNode(2),null));
//        solution.maxDepth(new Solution.TreeNode(1,null,new Solution.TreeNode(2)));

//    solution.maxDepth(new Solution.TreeNode(-8,new Solution.TreeNode(-6,new Solution.TreeNode(6,null,new Solution.TreeNode(5)),null),new Solution.TreeNode(-7)));
//      solution.maxDepth(new Solution.TreeNode(0, new Solution.TreeNode(2, new Solution.TreeNode(1, new Solution.TreeNode(5),new Solution.TreeNode(1)),null),
//              new Solution.TreeNode(4,new Solution.TreeNode(3, null,new Solution.TreeNode(6)),new Solution.TreeNode(-1, null, new Solution.TreeNode(8)))));

    }
}
