import java.time.Month;
import java.time.format.DateTimeFormatter;

public class BonusDates {
    public static void printBonusDatesBetween(int fromYear, int toYear) {
        // Create a DateTimeFormatter to format dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Loop through the years from fromYear to toYear 
        for (int year = fromYear; year <= toYear && year <= 2015; year++) {
            // Iterate through each month
            for (Month month : Month.values()) {
                // Calculate the number of days in the current month
                int daysInMonth = month.length(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));

                // Check if the month has at least 2 days and if the date is reversible
                if (daysInMonth >= 2 && isReversibleDate(year, month.getValue(), 2)) {
                    // Format the date and print it
                    String formattedDate = String.format("%04d-%02d-%02d", year, month.getValue(), 2);
                    System.out.println(formattedDate);
                }
            }
        }
    }

    // Check if a given date (year, month, day) is reversible
    private static boolean isReversibleDate(int year, int month, int day) {
        String originalDate = String.format("%04d%02d%02d", year, month, day);
        String reversedDate = new StringBuilder(originalDate).reverse().toString();
        return originalDate.equals(reversedDate);
    }

    public static void main(String[] args) {
        // Call the printBonusDatesBetween method for years 2010 to 2015
        printBonusDatesBetween(2010, 2015);
    }
}
