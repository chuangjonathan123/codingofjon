import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Hour (1-12, put 12 as 0): ");
        int hour = input.nextInt();

        System.out.print("Minutes (0-59): ");
        int minute = input.nextInt();

        double angle = clock(hour, minute);
        System.out.println("Clockwise angle between hands: " + angle + " degrees");
    }

    public static double clock(int hour, int minute) {
        double hourAngle = (hour % 12) * 30 + minute * 0.5;
        double minuteAngle = minute * 6;

        double clockwise = minuteAngle - hourAngle;
        if (clockwise < 0) {
            clockwise += 360;
        }

        return clockwise;
    }
}
