package com.edu.asu.placement.coding;

public class LinkedLists {
	
	public static void main(String[] args) {
		Node n4 = new Node(2, null);
		Node n3 = new Node(1, n4);
		Node n2 = new Node(3, n3);
		Node n1 = new Node(3, n2);
		Node n0 = new Node(1,n1);
		Node nn1 = new Node(2, n0);
		printList(nn1);
		
		//removeDuplicates(nn1);
		//printList(nn1);
		
		//System.out.println("-------" + findNthLastNode(nn1, 3));
		
		//deleteNodeWithoutHead(n3);
		//printList(nn1);
		
		//partitionData(nn1, 3);
		//printList(nn1);
		
		//Node sum = addLL(nn1, n2);
		//printList(sum);
		System.out.println("---------");
		boolean flag = isPalindrome(nn1);
		System.out.println(flag ? "True" : "False");
		
	}
	
	private static boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		Node prev = null;
		Node forward = null;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		prev = slow;
		slow = slow.next;
		forward = slow.next;
		prev.next = null;
		prev = slow;
		slow = slow.next;
		prev.next = null;
		while (forward != null) {
			forward = forward.next;
			slow.next = prev;
			prev = slow;
			if (forward != null) {
				slow = forward;
			}
		}
		
		Node current = head;
		printList(current);
		System.out.println("---------");
		printList(slow);
		while (current != null) {
			if (current.value != slow.value) {
				return false;
			}
			current = current.next;
			slow = slow.next;
		}
		return true;
	}

	private static Node addLL(Node head1, Node head2) {
		Node sumHead = null;
		Node current = null;
		int carry = 0;
		
		while (head1 != null || head2 != null) {
			Node temp = new Node(((head1 == null ? 0 : head1.value) 
								+ (head2 == null ? 0 : head2.value) + carry) % 10,null);
			System.out.println("sum ----" + ((head1 == null ? 0 : head1.value) + (head2 == null ? 0 : head2.value) + carry)%10);
			carry = ((head1 == null ? 0 : head1.value) + (head2 == null ? 0 : head2.value) + carry)/10;
			if (current == null) {
				current = temp;
				sumHead = current;
			} else {
				current.next = temp;
				current = current.next;
			}
			if (head1 != null) {
				head1 = head1.next;
			}
			if (head2 != null) {
				head2 = head2.next;
			}
		}
		return sumHead;
	}

	private static void partitionData(Node head, int pivot) {
		Node left = head;
		Node right = head;
		int count = 0;
		while (right != null) {
			if (right.value < pivot) {
				count++;
			}
			right = right.next;
		}
		System.out.println(count+"----");
		right = head;
		for (int i = 0; i < count; i++) {
			right = right.next;
		}
		while (right != null) {
			if (left.value < pivot) {
				left = left.next;
				continue;
			}
			if (right.value < pivot) {
				int temp = left.value;
				left.value = right.value;
				right.value = temp;
			}
			right = right.next;
		}
		right = head;
		if (left.value < pivot) {
			left = left.next;
		}
		while (right != null) {
			if (right.value == pivot) {
				right.value = left.value;
				left.value = pivot;
				break;
			}
			right = right.next;
		}
	}

	private static void deleteNodeWithoutHead(Node current) {
		Node previous = null;
		while (current.next != null) {
			current.value = current.next.value;
			previous = current;
			current = current.next;
		}
		previous.next = null;
	}

	private static int findNthLastNode(Node head, int k) {
		Node slow = head;
		Node fast = head;
		int count = 0;
		int slowCount = 0;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			slowCount++;
		}
		if (fast.next != null) {
			count = (slowCount+1)*2;
		} else {
			count = slowCount*2 - 1;
		}
		int forwardK = count - k - 1;
		if (forwardK <= slowCount) {
			for (int i = 0; i <= forwardK; i++) {
				head = head.next;
			}
		} else if (forwardK > slowCount) {
			head = slow;
			for(int i = forwardK - slowCount; i < forwardK; i++) {
				head = head.next;
			}
		}
		System.out.println("count = " + count + " -- slowCount = " + slowCount + " -- forwardK = " + forwardK);
		return head.value;
	}

	private static void removeDuplicates(Node head) {
		if (head == null || head.next == null) {
			return;
		}
		Node currentHead = head;
		Node previous = head;
		Node current = head.next;
		while (currentHead != null) {
			while (current != null) {
				if (current.value == currentHead.value) {
					previous.next = current.next;
					current = previous.next;
				} else {
					previous = current;
					current = current.next;
				}
			}
			currentHead = currentHead.next;
			if (currentHead ==null || currentHead.next == null) {
				return;
			} 
			current = currentHead.next;
			previous = currentHead;
		}
	}

	public static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
}

class Node {
	int value;
	Node next;
	
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}
}
