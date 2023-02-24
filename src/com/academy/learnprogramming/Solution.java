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
            System.out.println("root is null returning 0");
            return 0;
        }
        if (root.right == null && root.left == null){
            System.out.println("root has no branches returning 1");
            return 1;
        }
        if (root.right != null){
            rightStuff(root);
            leafRaker();
        }
        if (root.left != null){
            leftStuff(root);
            leafRaker();
        }

        System.out.println("left depth "+leftDepth+"  right depth "+rightDepth);
        int returnValue = Math.max(rightDepth,leftDepth) +1;
        System.out.println("returing "+returnValue);
        return returnValue;
    }
    public void rightStuff(TreeNode stem){
        System.out.println("rightstuff called");
        System.out.println("current node is "+stem.val+" current depth is "+rightDepth);
        if (stem.right != null && stem.left != null){
            System.out.println("subracting from right depth");
            rightDepth --;
        }
        if (stem.left != null){
            System.out.println("Adding "+stem.left.val+" to the leaf pile ");
            rightDepth++;
            System.out.println("right depth is "+rightDepth);
            leafPile.add(stem.left);
            button = true;
        }
        if (stem.right != null) {
            rightDepth++;
            System.out.println("current node changing from "+stem.val+"  to  "+stem.right.val);
            stem = stem.right;
            System.out.println("current node is "+stem.val+" current depth is "+rightDepth);
            rightStuff(stem);
        }
        if (stem.right == null){
            System.out.println("you've reached the end of this right stem at stem val "+stem.val);
        }
    }
    public void leftStuff(TreeNode stem){
        System.out.println("leftstuff called");

        System.out.println("current node is "+stem.val+" current depth is "+leftDepth);
        if (stem.left != null) {
            leftDepth++;
            System.out.println("current node changing from "+stem.val+"  to  "+stem.left.val);
            stem = stem.left;
            System.out.println("current node is "+stem.val+" current depth is "+leftDepth);
        }
        if (stem.right != null && stem.left != null){
            leftDepth --;
        }
        if (stem.left == null && stem.right == null){
            System.out.println("you've reached the end of this stem at stem val "+stem.val);
        }
        if (stem.right != null){
            leftDepth++;
            System.out.println("Adding "+stem.right.val+" to the leaf pile ");
            leafPile.add(stem.right);
            button = false;
        }
        if (stem.left != null){
            leftStuff(stem);
        }
        if (stem.left == null && stem.right != null){
            System.out.println("you've reached the end of this stem at stem val "+stem.val);
        }
    }
    public void leafRaker(){
        while (!(leafPile.isEmpty())){
               if (button){
                   System.out.println("raking "+leafPile.get(0).val);
                   if (leafPile.get(0).right != null){
                       rightDepth--;
                   }
                   rightStuff(leafPile.get(0));
                   leafPile.remove(leafPile.get(0));
               }
               if (!button){
                   System.out.println("raking "+leafPile.get(0).val);
                   if (leafPile.get(0).left != null){
                       leftDepth--;
                   }
                   leftStuff(leafPile.get(0));
                   leafPile.remove(leafPile.get(0));
               }
        }
    }
    
}