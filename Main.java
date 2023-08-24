import java.time.Month;
import java.time.format.DateTimeFormatter;

public class BonusDates {
    public static void printBonusDatesBetween(int fromYear, int toYear) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int year = fromYear; year <= toYear && year <= 2015; year++) {
            for (Month month : Month.values()) {
                int daysInMonth = month.length(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));

                if (daysInMonth >= 2 && isReversibleDate(year, month.getValue(), 2)) {
                    String formattedDate = String.format("%04d-%02d-%02d", year, month.getValue(), 2);
                    System.out.println(formattedDate);
                }
            }
        }
    }

    private static boolean isReversibleDate(int year, int month, int day) {
        String originalDate = String.format("%04d%02d%02d", year, month, day);
        String reversedDate = new StringBuilder(originalDate).reverse().toString();
        return originalDate.equals(reversedDate);
    }

    public static void main(String[] args) {
        printBonusDatesBetween(2010, 2015);
    }
}
