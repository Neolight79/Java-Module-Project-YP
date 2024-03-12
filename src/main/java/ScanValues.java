import java.util.Scanner;

public class ScanValues {
    public static int scanIntegerValue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) return scanner.nextInt();
            else {
                System.out.println("Некорректный ввод! Введите целое число, например 15:");
                scanner.nextLine();
            }
        }
    }

    public static double scanDoubleValue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextDouble()) return Math.floor(scanner.nextDouble() * 100) / 100;
            else {
                System.out.println("Некорректный ввод! Введите число с разделителем, например 12.34:");
                scanner.nextLine();
            }
        }
    }

    public static String scanStringValue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String result = scanner.next();
            if (!result.isEmpty()) return result;
            else {
                System.out.println("Пустое значение! Введите заново.");
                scanner.nextLine();
            }
        }
    }

}
