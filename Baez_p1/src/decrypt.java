import java.util.Scanner;

public class decrypt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your four digit encrypted number:");
		int userInput = scan.nextInt();
		// checks if input is four digits
		// wanted to also check for less than 4 digit but if the 1st digit in the decrypt 
		// is supposed to be zero then I wasn't sure the best way to check so I just hope
		// inputs are truthful
		if (userInput / 1000 >= 10)
		{
			System.out.println("Incorrect number of digit input");
			scan.close();
			return;
		}
		// Process to extract each digit from input
		int fourthDigit = userInput % 10;
		int thirdDigit = (userInput / 10) % 10;
		int secondDigit = (userInput / 100) % 10;
		int firstDigit = (userInput / 1000) % 10;
		
		// 1st phase of decryption
		// + 10 - 7 may seem redundant but done just in case
		// % 10 for numbers 0 1 2 to not be double digit for + 10 - 7
		fourthDigit = ((fourthDigit + 10) - 7) % 10;
		thirdDigit = ((thirdDigit + 10) - 7) % 10;
		secondDigit = ((secondDigit + 10) - 7) % 10;
		firstDigit = ((firstDigit + 10) - 7) % 10;
		// 2nd phase of decryption
		int temp = firstDigit;
		firstDigit = thirdDigit;
		thirdDigit = temp;
		temp = secondDigit;
		secondDigit = fourthDigit;
		fourthDigit = temp;
		System.out.printf("Your decrypted number:\n%d%d%d%d\n", firstDigit, secondDigit, thirdDigit, fourthDigit);
		scan.close();
	}

}
