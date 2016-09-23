package com.edu.asu.placement.coding;

import java.util.Stack;

public class SetOfStacks extends Stack<Integer> {
	
	private static final long serialVersionUID = -7158693357754128155L;
	private Stack<Stack<Integer>> setOfStacks;
	int threshold;
	
	public SetOfStacks(int threshold) {
		setOfStacks = new Stack<Stack<Integer>>();
		this.threshold = threshold;
	}
	
	public Integer push (Integer value) {
		if (setOfStacks.isEmpty()) {
			Stack<Integer> startStack = new Stack<Integer>();
			startStack.push(value);
			setOfStacks.push(startStack);
		} else {
			Stack<Integer> currentStack = setOfStacks.pop();
			if(currentStack.size() == threshold) {
				setOfStacks.push(currentStack);
				currentStack = new Stack<Integer>();
				currentStack.push(value);
			} else {
				currentStack.push(value);
			}
			setOfStacks.push(currentStack);
		}
		return value;
	}
	
	public Integer pop() {
		Stack<Integer> currentStack = setOfStacks.pop();
		Integer returnValue = currentStack.pop();
		if (!currentStack.isEmpty()) {
			setOfStacks.push(currentStack);
		}
		return returnValue;
	}
	
	public Stack<Integer> popStack() {
		return setOfStacks.pop();
	}
}
