import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Which units do you wish to use:\n US Imperial or Metric");
		System.out.println("Enter: lb for Imperial\nEnter: kg for Metric");
		String userChoice = scan.next();
		double bmi;
		double weight;
		double height;
		// Imperial Calculation
		if (userChoice.contentEquals("lb"))
		{
			System.out.println("Enter your weight (in pounds):");
			weight = scan.nextDouble();
			if (weight <= 0)
			{
				System.out.println("Invalid weight");
				scan.close();
				return;
			}
			System.out.println("Enter your height (in inches):");
			height = scan.nextDouble();
			// both height checks ensure don't divide by 0 
			// all checks make sure no negatives entered
			if (height <= 0)
			{
				System.out.println("Invalid height");
				scan.close();
				return;
			}
			bmi = (703 * weight) / Math.pow(height,  2);
		}
		// Metric calculation
		else if (userChoice.contentEquals("kg"))
		{
			System.out.println("Enter your weight (in kilograms):");
			weight = scan.nextDouble();
			if (weight <= 0)
			{
				System.out.println("Invalid weight");
				scan.close();
				return;
			}
			System.out.println("Enter your height (in meters):");
			height = scan.nextDouble();
			if (height <= 0)
			{
				System.out.println("Invalid height");
				scan.close();
				return;
			}
			bmi = weight / Math.pow(height, 2);
		}
		else
		{
			System.out.println("Invalid choice");
			scan.close();
			return;
		}
		
		System.out.printf("Your BMI is: %.2f\n\n", bmi);
		System.out.println("   BMI CATEGORIES");
		System.out.print("Underweight: <18.5\nNormal Weight: 18.5-24.9\nOverweight: 25-29.9\nObesity: 30+\n");
		scan.close();
	}

}
