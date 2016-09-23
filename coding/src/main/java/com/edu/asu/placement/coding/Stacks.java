package com.edu.asu.placement.coding;

public class Stacks {

	public static void main(String[] args) {
		SetOfStacks s = new SetOfStacks(3);
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		s.push(3);
		s.push(4);
		System.out.println(s.popStack());
		
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
		myQueue.push(4);
		System.out.println(myQueue.pop());
	}
}


