package com.edu.asu.placement.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
@SuppressWarnings("unused")
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
		
		//System.out.println(checkIfBalanced(root) ? "Balanced" : "Unbalanced");
		
		//int arr[] = {1, 2, 3, 4, 5, 6, 7};
		//printPostOrder(arrayToBalancedBinaryTree(arr));
		List<LinkedList<TreeNode>> placeholder = new ArrayList<LinkedList<TreeNode>>();
		binaryTreeToLinkedLists(root, 0, placeholder);
		Iterator<LinkedList<TreeNode>> it = placeholder.iterator();
		while (it.hasNext()) {
			Iterator<TreeNode> nodeIt = it.next().iterator();
			while (nodeIt.hasNext()) {
				System.out.print(nodeIt.next().value);
			}
			System.out.println("");
		}
	}

	private static void binaryTreeToLinkedLists(TreeNode root, int level, List<LinkedList<TreeNode>> placeholder) {
		if (root == null) {
			return;
		}
		if (placeholder.size() <= level ) {
			placeholder.add(new LinkedList<TreeNode>(Arrays.asList(root)));
		} else {
			placeholder.get(level).add(root);
		}
		binaryTreeToLinkedLists(root.left, level + 1, placeholder);
		binaryTreeToLinkedLists(root.right, level + 1, placeholder);
		root.left = null;
		root.right = null;
	}

	private static TreeNode arrayToBalancedBinaryTree(int[] arr) {
		TreeNode root = null;
		if (arr.length <= 2) {
			root = new TreeNode(arr[arr.length - 1]);
			if (arr.length == 2) {
				root.left = new TreeNode(arr[0]);
			}
			return root;
		}
		root = new TreeNode(arr[arr.length/2]);
		root.left = arrayToBalancedBinaryTree(Arrays.copyOf(arr, arr.length/2));
		root.right = arrayToBalancedBinaryTree(Arrays.copyOfRange(arr, arr.length/2 + 1, arr.length));
		return root;
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