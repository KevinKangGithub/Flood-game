package code;

import java.util.Scanner;

public class LinkedGrid {
	public Node root;
	private int n;
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public LinkedGrid(int n) {
		root = new Node();
		setN(n);
		
		Node top = null;
		Node left = root;
		Node firstInRow = root;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n - 1; j++) {
				Node temp = new Node(random(0, 5));
				
				left.setRight(temp);
				if(top != null) top.setDown(temp);
				
				temp.setLeft(left);
				temp.setUp(top);
				
				left = temp;
				if(top != null) top = top.getRight();
			}
			if(i != n - 1) {
				Node temp = new Node(random(0, 5));
				firstInRow.setDown(temp);
				temp.setUp(firstInRow);
				top = firstInRow.getRight();
				left = temp;
				
				firstInRow = temp;
			}
		}
	}
	
	public void display() {
		Node firstInRow = root;
		
		while(firstInRow != null) {
			Node current = firstInRow;
			while(current != null) {
				printColor(current.getData());
				current = current.getRight();
			}
			firstInRow = firstInRow.getDown();
			System.out.println();
		}
	}
	
	//TODO: MINIMUM NUMBER OF TRIES NEEDED (backtracking? O(5^NM) way too long)
	public int minimumNumberTriesNeeded() {
		
		return 0;
	}
	
	public void printColor(int n) {
		if(n == 0) System.out.print("🟥");
		else if(n == 1) System.out.print("🟨");
		else if(n == 2) System.out.print("🟦");
		else if(n == 3) System.out.print("🟪");
		else if(n == 4) System.out.print("🟩");
		else if(n == 5) System.out.print("🟧");
	}
	
	
	public void flood(int color, Node u) {
		if(u.getData() == color) return;
		
		int initialColor = u.getData();
		u.setData(color);
		if(u.getUp() != null && u.getUp().getData() == initialColor) 
			flood(color, u.getUp());
		if(u.getLeft() != null && u.getLeft().getData() == initialColor) 
			flood(color, u.getLeft());
		if(u.getDown() != null && u.getDown().getData() == initialColor) 
			flood(color, u.getDown());
		if(u.getRight() != null && u.getRight().getData() == initialColor) 
			flood(color, u.getRight());
	}
	
	public boolean allSameColor() {
		Node firstInRow = root;
		
		while(firstInRow != null) {
			Node current = firstInRow;
			while(current != null) {
				if(current.getData() != root.getData()) return false;
				current = current.getRight();
			}
			firstInRow = firstInRow.getDown();
		}
		return true;
	}
	
	
	public int random(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}
}
