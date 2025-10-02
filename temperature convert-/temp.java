import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Engineering Unit Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. mmHG to Atmospheres");
        System.out.print("Choose an option: ");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = input.nextDouble();
            double fahrenheit = (celsius * 9/5) + 32;
            System.out.println("In Fahrenheit: " + fahrenheit);
        } 
        else if (choice == 2) {
            System.out.print("Enter pressure in Pascals: ");
            double pascals = input.nextDouble();
            double atm = pascals / 760;
            System.out.println("In Atmospheres: " + atm);
        } 
        else {
            System.out.println("Invalid choice!");
        }

        input.close();
    }
}
