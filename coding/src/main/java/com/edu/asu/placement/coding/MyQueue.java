package com.edu.asu.placement.coding;

import java.util.Stack;

public class MyQueue {
	private Stack<Integer> pushStack;
	private Stack<Integer> popStack;
	
	public MyQueue() {
		pushStack = new Stack<Integer>();
		popStack = new Stack<Integer>();
	}
	
	public void push (Integer value) {
		if (!popStack.isEmpty()) {
			while (!popStack.empty()) {
				pushStack.push(popStack.pop());
			}
		}
		pushStack.push(value);
	}
	
	public Integer pop() {
		if (!pushStack.isEmpty()) {
			while (!pushStack.empty()) {
				popStack.push(pushStack.pop());
			}
		}
		return popStack.pop();
	}
}
