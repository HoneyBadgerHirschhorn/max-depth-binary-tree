package com.academy.learnprogramming;

import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    public static class TreeNode {
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
    int totalDepth = 1;
    TreeNode leftBranch = null;
    TreeNode rightBranch = null;
    TreeNode rightLeaf = null;
    TreeNode leftLeaf = null;
    LinkedList<TreeNode> leafPile = new LinkedList<>();
    boolean button;


    public int maxDepth(TreeNode root) {
        if (root == null){
            System.out.println("returning 0");
            return 0;
        }
        if (root.right == null && root.left == null){
            System.out.println("returning 1");
            return 1;
        }
        if (root.right == null){
            System.out.println("root.right == null");
            if (root.left != null) {
//                leftDepth++;
                leftStuff(root.left);
                System.out.println("raking pile due to null root.right");
                while (!leafPile.isEmpty()){
                    leafRaker();
                }
            }
        }
        if (root.right != null) {
            rightStuff(root.right);
            while (!leafPile.isEmpty()) {
                System.out.println("raking leaves due to non null root.right");
                leafRaker();
            }
        }
        if (root.left != null) {
//            leftDepth++;
            leftStuff(root.left);
            while (!leafPile.isEmpty()){
                System.out.println("raking leaves due to non null root.left");
                leafRaker();
            }
        }
        System.out.println("right is "+rightDepth+" left is "+leftDepth);
        totalDepth = Math.max(rightDepth, leftDepth);
        System.out.println("total depth is "+(totalDepth));
        return (totalDepth);
    }


    public void rightStuff(TreeNode branch) {
        if (rightDepth < 1){
            rightDepth = 1;
        }
        rightDepth++;
        System.out.println("right depth is now v1 "+rightDepth);
        System.out.println("right branch.val is "+branch.val);
        if (branch.right == null && branch.left == null){
            rightDepth++;
            System.out.println("right depth is now v3 "+rightDepth);
        }
        if (branch.left != null) {
            System.out.println("right outer loop add");
            button = true;
            if (!(leafPile.contains(branch.left))) {
                System.out.println("adding " + branch.left.val + " to leaf pile");
                leafPile.add(branch.left);
            }
        }
        while (branch.right != null) {
            rightDepth++;
            System.out.println("right depth is now v2 "+rightDepth);
            if (branch.left != null && !(leafPile.contains(branch.left))) {
                System.out.println("right inner loop add");
                button = true;
                leafPile.add(branch.left);
                System.out.println("adding " + branch.left.val + " to leaf pile");
            }

            if (branch.right != null) {
                System.out.println("going right towards node " + branch.right.val);
                branch = branch.right;
                rightBranch = branch;
            }
            if (branch.right == null && branch.left != null){
                button = true;
                System.out.println("right inner add 3");
                leafPile.add(branch.left);
                System.out.println("adding " + branch.left.val + " to leaf pile");

            }
        }


        System.out.println("ending right stuff");
    }

    public void leafRaker() {
        if (button) {
            if (!leafPile.isEmpty()) {
                System.out.println("raking right leaf pile! with " + leafPile.get(0).val);
                rightStuff(leafPile.get(0));
                leafPile.remove(leafPile.get(0));
            }
        }
        if (!button) {
            if (!leafPile.isEmpty()) {
                System.out.println("raking left leaf pile! with " + leafPile.get(0).val);
                leftStuff(leafPile.get(0));
                leafPile.remove(leafPile.get(0));
            }
        }
    }


    public void leftStuff(TreeNode branch) {
        System.out.println("branch.val is "+branch.val);
        leftDepth ++;
        if (branch.right == null && branch.left == null){
            leftDepth++;
            System.out.println("right depth is now v3 "+rightDepth);
        }
        System.out.println("left depth is "+leftDepth);
        if (branch.right != null && !(leafPile.contains(branch.right))) {
            System.out.println("left outer loop add");
            button = false;
            System.out.println("adding " + branch.right.val + " to leaf pile");
            leafPile.add(branch.right);
        }
        while (branch.left != null) {
            leftDepth++;
            if (branch.right != null && !(leafPile.contains(branch.right))) {
                leftDepth++;
                System.out.println("left depth is "+leftDepth);
                button = false;
                System.out.println("left inner add 1");
                leafPile.add(branch.right);
                System.out.println("adding " + branch.right.val + " to leaf pile");
            }
            if (branch.left == null && branch.right != null && !(leafPile.contains(branch.right))) {
                button = false;
                System.out.println("left depth is "+leftDepth);
                leftDepth++;
                System.out.println("Left inner add 2");
                leafPile.add(branch.right);
                System.out.println("adding " + branch.right.val + " to leaf pile");
            }
            System.out.println("going left! with node " + branch.left.val);
            branch = branch.left;
            if (branch.left == null && branch.right != null){
                button = false;
                System.out.println("Left inner add 3");
                leafPile.add(branch.right);
                System.out.println("adding " + branch.right.val + " to leaf pile");
            }
        }
        System.out.println("leftDepth " + leftDepth + " total depth " + totalDepth);
    }
}