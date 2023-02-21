package com.academy.learnprogramming;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int leftDepth = 0;
    int rightDepth = 0;
    int tempDepth = 0;
    int tempDepth2 = 0;

    TreeNode leftBranch = null;
    TreeNode rightBranch = null;
    TreeNode rightLeaf = null;
    TreeNode leftLeaf = null;
    ArrayList<TreeNode> leafPile = new ArrayList<>();
    ArrayList<TreeNode> leafPile2 = new ArrayList<>();

    public int maxDepth(TreeNode root) {

        if (rightBranch.right != null) {
            rightBranch = rightBranch.right;
            rightDepth++;
            rightStuff(rightBranch);
            //method call
            if (leafPile.size() > 0) {
                tempDepth = rightDepth;
                rightDepth = 3;
                for (int i = 0; i < leafPile.size(); i++) {
                    if (rightDepth > tempDepth) {
                        tempDepth = rightDepth;
                        rightDepth = 3 + i;
                    }
                    if (leafPile.get(i).right != null) {
                        rightStuff(leafPile.get(i));
                    }
                    if (leafPile.get(i).left != null) {
                        leafPile2.add(leafPile.get(i).left);

                    }
                }
            }
        }


        return root.val;
    }


    public void rightStuff(TreeNode branch) {
        while (rightBranch.right != null) {
            if (rightBranch.left != null) {
                leftLeaf = rightBranch.left;
                leafPile.add(leftLeaf);
            }
            rightBranch = rightBranch.right;
            rightDepth++;
        }

    }
}