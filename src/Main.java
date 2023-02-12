import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        showProgress(100, 10);
    }

    public static void showProgress(int total, int increment) {
        // Calculate the number of digits in the total progress
        int digits = (int) Math.log10(total) + 1;
        // Calculate the length of the full visual bar
        int barLength = total / increment;
        // Loop to update the progress bar and percentage
        for (int i = 0; i <= total; i += increment) {
            // Reset the line to update the progress bar and percentage
            System.out.print("\r");
            // Print the label for the progress bar
            System.out.print("Progress: ");
            // Print the visual bar using the '|' symbol
            System.out.print(String.join("", Collections.nCopies(i / increment, "|")));
            // Print spaces to the right of the visual bar
            System.out.print(String.join("", Collections.nCopies(barLength - i / increment, " ")));
            // Print the percentage as an integer, padded with spaces to ensure it always stands on one position to the left of the full visual bar
            System.out.print(String.format(" %" + digits + "d%%", i));
            // Pause the program for one second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Print the stack trace in case of InterruptedException
                e.printStackTrace();
            }
        }
        // Move to the next line after the progress bar is complete
        System.out.println();
    }
}