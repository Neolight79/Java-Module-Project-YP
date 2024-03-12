import java.util.Scanner;

public class ScanValues {
    private static final Scanner scanner = new Scanner(System.in);
    public static int scanIntegerValue() {
        while (true) {
            if (scanner.hasNextInt()) return scanner.nextInt();
            else {
                System.out.println("Некорректный ввод! Введите целое число, например 15:");
                scanner.nextLine();
            }
        }
    }

    public static double scanDoublePositiveValue() {
        while (true) {
            if (scanner.hasNextDouble()) {
                double scannedValue = scanner.nextDouble();
                if (scannedValue > 0) return Math.floor(scannedValue * 100) / 100;
                else {
                    System.out.println("Стоимость не может быть отрицательной или нулевой, введите снова.");
                    scanner.nextLine();
                }
            }
            else {
                System.out.println("Некорректный ввод! Введите число с разделителем, например 12.34:");
            }
        }
    }

    public static String scanStringValue() {
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
