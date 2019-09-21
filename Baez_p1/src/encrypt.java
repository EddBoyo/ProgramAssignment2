import java.util.Scanner;

public class encrypt {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your four digit integer:");
		int userInput = scan.nextInt();
		// checks if input is four digits
		if (((userInput / 1000) == 0) || (userInput / 1000 >= 10))
		{
			System.out.println("Incorrect number of digit input");
			scan.close();
			return;
		}
		// getting the four digits separately from input
		int fourthDigit = userInput % 10;
		int thirdDigit = (userInput / 10) % 10;
		int secondDigit = (userInput / 100) % 10;
		int firstDigit = (userInput / 1000) % 10;
		
		// 1st phase of encyption
		firstDigit = (firstDigit + 7) % 10;
		secondDigit = (secondDigit + 7) % 10;
		thirdDigit = (thirdDigit + 7) % 10;
		fourthDigit = (fourthDigit + 7) % 10;
		
		// 2nd phase of encryption
		int temp = firstDigit;
		firstDigit = thirdDigit;
		thirdDigit = temp;
		temp = secondDigit;
		secondDigit = fourthDigit;
		fourthDigit = temp;
		System.out.printf("Your encypted number:\n%d%d%d%d\n", firstDigit, secondDigit, thirdDigit, fourthDigit);
		scan.close();
	}

}
