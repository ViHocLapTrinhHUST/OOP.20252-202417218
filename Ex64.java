import java.util.Scanner;

public class Ex64 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a month : ");
            String monthInput = scanner.nextLine().trim();

            System.out.print("Enter a year : ");
            String yearInput = scanner.nextLine().trim();

            int year = -1;
            try {
                year = Integer.parseInt(yearInput);
                if (year < 0) {
                    System.out.println("Invalid year. Must be a non-negative number. Please try again.\n");
                    continue; 
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format. Must contain only digits. Please try again.\n");
                continue; 
            }

            int monthNumber = getMonthNumber(monthInput);
            if (monthNumber == -1) {
                System.out.println("Invalid month entered. Please try again.\n");
                continue; 
            }
            int days = calculateDays(monthNumber, year);
            System.out.println("\nNumber of days: " + days);

            break; 
        }

        scanner.close();
    }


    private static int getMonthNumber(String month) {
        switch (month.toLowerCase()) {
            case "1": case "jan": case "jan.": case "january": 
                return 1;
            case "2": case "feb": case "feb.": case "february": 
                return 2;
            case "3": case "mar": case "mar.": case "march": 
                return 3;
            case "4": case "apr": case "apr.": case "april": 
                return 4;
            case "5": case "may": case "may.": 
                return 5;
            case "6": case "jun": case "jun.": case "june": 
                return 6;
            case "7": case "jul": case "jul.": case "july": 
                return 7;
            case "8": case "aug": case "aug.": case "august": 
                return 8;
            case "9": case "sep": case "sep.": case "sept": case "sept.": case "september": 
                return 9;
            case "10": case "oct": case "oct.": case "october": 
                return 10;
            case "11": case "nov": case "nov.": case "november": 
                return 11;
            case "12": case "dec": case "dec.": case "december": 
                return 12;
            default: 
                return -1;
        }
    }
    private static int calculateDays(int month, int year) {
        if (month == 2) {
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            return isLeapYear ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
  
            return 30;
        } else {
         
            return 31;
        }
    }
}