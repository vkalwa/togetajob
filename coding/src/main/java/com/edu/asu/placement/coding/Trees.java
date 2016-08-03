package com.edu.asu.placement.coding;

import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Trees {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode firstLeft = new TreeNode(1);
		TreeNode firstRight = new TreeNode(2);
		root.left = firstLeft;
		root.right = firstRight;
		TreeNode secondLeft = new TreeNode(3);
		TreeNode secondRight = new TreeNode(4);
		firstLeft.left = secondLeft;
		firstLeft.right = secondRight;
		TreeNode thirdRight = new TreeNode(5);
		firstRight.right = thirdRight;
		
		printInOrder(root);
		System.out.println("");
		printPreOrder(root);
		System.out.println("");
		printPostOrder(root);
		System.out.println("");
		
		/*printInOrderIterative(root);
		System.out.println("");
		printPreOrderIterative(root);
		System.out.println("");
		printPostOrderIterative(root);
		System.out.println("");*/
		
		System.out.println(checkIfBalanced(root) ? "Balanced" : "Unbalanced");
	}

	private static boolean checkIfBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!checkIfBalanced(root.left) || !checkIfBalanced(root.right)) {
			return false;
		}
		if (height(root.left) - height(root.right) <= 1) {
			return true;
		}
		return false;
	}

	private static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return height(root.right) + 1;
		} else if (root.right == null) {
			return height(root.left) + 1;
		} else {
			return Math.max(height(root.left), height(root.right)) + 1;
		}
	}

	private static void printPostOrderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		stack.push(root);
		
		while (!stack.isEmpty()) {
			current = stack.pop();
			if (current.left == null && current.right == null) {
				System.out.print(current.value+", ");
				continue;
			}
			TreeNode localLeft = current.left;
			TreeNode localRight = current.right;
			current.left = null;
			current.right = null;
			stack.push(current);
			if (localRight != null) {
				stack.push(localRight);
			}
			if (localLeft != null) {
				stack.push(localLeft);
			}
		}
	}

	private static void printPreOrderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		
		stack.push(root);
		while (!stack.isEmpty()) {
			current = stack.pop();
			System.out.print(current.value+", ");
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
			
		}
	}

	private static void printInOrderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;
		
		while (current != null) {
			stack.push(current);
			current = current.left;
		}
		while (!stack.isEmpty()) {
			current = stack.pop();
			System.out.print(current.value+", ");
			if (current.right != null) {
				current = current.right;
				
				while (current != null) {
					stack.push(current);
					current = current.left;
				}
			}
		}
	}

	private static void printPostOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.value+", ");
	}

	private static void printPreOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value+", ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	private static void printInOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.value+", ");
		printInOrder(root.right);
	}
	

}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode(int value) {
		this.value = value;
	}
}