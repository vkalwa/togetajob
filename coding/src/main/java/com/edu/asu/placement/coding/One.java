package com.edu.asu.placement.coding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class One {
	public static void main(String[] args) {
		System.out.println(isUniqueString("abcde") ? "unique" : "not unique");
		System.out.println(isPermutation("string1", "str2ing") ? "Yes" : "No");
		System.out.println(urlEncodeSpaces("Mr John Smith    ".toCharArray()));
		System.out.println(stringCompression("aaaa1bcd"));
	} 

	private static String stringCompression(String string) {
		int counter = 1;
		char[] input = string.toCharArray();
		StringBuilder output = new StringBuilder().append(input[0]);
		for (int i = 1; i < input.length; i++) {
			if (input[i] == input[i-1]) {
				counter++;
			} else {
				output.append(counter);
				counter = 1;
				output.append(input[i]);
			}
		}
		output.append(counter);
		if (string.length() < output.length()) {
			return string;
		} else {
			return output.toString();
		}
	}

	private static char[] urlEncodeSpaces(char[] input) {
		int global = input.length - 1;
		for (int i = input.length - 1; i >= 0; i--) {
			if (input[i] == ' ' && global == input.length - 1) {
				continue;
			}
			if (input[i] != ' ') {
				input[global] = input[i];
				global--;
			}
			else {
				input[global] = '0';
				input[global-1] = '2';
				input[global-2] = '%';
				global = global - 3;
			}
		}
		return input;
	}

	private static boolean isPermutation(String string1, String string2) {
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (char c : string1.toCharArray()) {
			if (!charMap.containsKey(c)) {
				charMap.put(c, 0);
			}
			charMap.put(c, charMap.get(c) + 1);
		}
		for (char c : string2.toCharArray()) {
			if (!charMap.containsKey(c)) {
				return false;
			}
			charMap.put(c, charMap.get(c) - 1);
		}
		for (char c : charMap.keySet()) {
			if (charMap.get(c) != 0)
				return false;
		}
		return true;
	}

	private static boolean isUniqueString(String string) {
		Set<Character> charSet = new HashSet<Character>();
		for (char c : string.toCharArray()) {
			if (charSet.contains(c)) {
				return false;
			} else {
				charSet.add(c);
			}
		}
		return true;
	}
}
