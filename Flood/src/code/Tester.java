package code;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		LinkedGrid list = new LinkedGrid(10);
		list.display();
		
		int guess = 25;
		while(guess > 0) {
			System.out.println("Tries left: " + guess--);
			System.out.println("1: 🟥");
			System.out.println("2: 🟨");
			System.out.println("3: 🟦");
			System.out.println("4: 🟪");
			System.out.println("5: 🟩");
			System.out.println("6: 🟧");
			int x = 1;
			do {
				if(!(x >= 1 && x <= 6)) System.out.println("Invalid color. Try again");
				System.out.print("Enter choice: ");
				x = input.nextInt();
			} while(!(x >= 1 && x <= 6));
			list.flood(--x, list.root);
			list.display();
			
			if(list.allSameColor()) {
				System.out.println("Success!");
				break;
			} else if(guess == 0) {
				System.out.println("You've ran out of tries. Pay $2.99 or watch an ad for 10 more tries. ");
			}
		}
	}

}
