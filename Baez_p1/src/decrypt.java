import java.util.Scanner;

public class decrypt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your four digit encrypted number:");
		int userInput = scan.nextInt();
		// checks if input is four digits
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
