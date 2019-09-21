import java.util.Scanner;

public class pollProgram {

	public static void main(String[] args) 
	{
		// Initialization for everything I need
		Scanner scan = new Scanner(System.in);
		String[] topics = new String[5];
		int[][] responses = new int[5][10];
		double[] avg = new double[5];
		int[] sums = new int[5];
		int maxIndex = 0;
		int minIndex = 0;
		topics[0] = "cheeeeese:";
		topics[1] = "pepperoni:";
		topics[2] = "anchovies:";
		topics[3] = "mushrooms:";
		topics[4] = "pineapple:"; 
		char userCheck = 'y';
		int userInput; 
		
		// Polling Process
		while (userCheck != 'q')
		{
			if (userCheck != 'y')
			{
				System.out.println("Invalid continue entry");
				scan.close();
				return;
			}
			System.out.println("On a scale of 1 (lowest) to 10 (highest):\nHow much do you like these pizza toppings?");
			for (int i = 0; i < 5; i++)
			{
				System.out.println(topics[i]);
				userInput = scan.nextInt();
				if ((userInput <= 0) || (userInput > 10))
				{
					System.out.println("Invalid number entry");
					scan.close();
					return;
				}
				responses[i][(userInput - 1)] += 1;
			}
			System.out.println("Would you like to take the poll again?\n(Enter q to quit and y to go again)");
			userCheck = scan.next().charAt(0);
		}
		// Counting up Inputs for Data Display
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				sums[i] = sums[i] + (responses[i][j] * (j + 1));
			}
			avg[i] = (sums[i]) / 10.0;
		}
		int max = sums[0];
		int min = sums[4];
		
		for (int i = 0; i < 5; i++)
		{
			if (sums[i] > max)
			{
				max = sums[i];
				maxIndex = i;
			}
			else if (sums[i] < min)
			{
				min = sums[i];
				minIndex = i;
			}
		}
		// Data Display
		System.out.println("                 DATA BREAKDOWN");
		System.out.println("          | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10| TOTAL AVG'S ");
		for (int i = 0; i < 5; i++)
		{
			System.out.print(topics[i] + "| ");
			for (int j = 0; j < 10; j++) 
			{
				System.out.print(responses[i][j] + " | ");
			}
			System.out.print("     " + avg[i]);
			System.out.println();
			
		}
		System.out.println();
		System.out.println("HIGHEST POINT TOTAL: " + max + " for the topping " + topics[maxIndex]);
		System.out.println("LOWEST POINT TOTAL: " + min + " for the topping " + topics[minIndex]);
		
	}

}
