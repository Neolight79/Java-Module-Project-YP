import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);   // Для использования точки в качестве разделителя целой и дробной части double
        SharedCalc calculator = new SharedCalc();

        // Стадия 1: Выводим инструкции работы с программой
        System.out.println("Приложение для разделения общего счета на равные платежи.");
        System.out.println(" 1. Введите количество участников");
        System.out.println(" 2. Введите товары и суммы (в отдельной строке наименование товара, в следующей сумма)");
        System.out.println(" 3. Введите 'Завершить' по окончании ввода товаров");
        System.out.println("Вы получите список товаров и сумму для оплаты каждым участником.\n");

        // Стадия 2: Цикл получения количества участников
        System.out.println("Введите количество участников (2-999):");
        while (true) {
            int persons = ScanValues.scanIntegerValue();
            if (persons > 1 && persons < 1000) {
                System.out.printf("Счет будет разделен на %d %s%n", persons, WordEndings.convertPersons(persons));
                    // Сообщаем калькулятору количество персон для разделения счета
                    calculator.setPersons(persons);
                    break;
                } else System.out.printf("Введенное число %d неверно! Диапазон от 2 до 999:%n", persons);
        }

        // Стадия 3: Добавляем товары и суммы
        System.out.println("Вводите по-строчно товары и стоимость:");
        while (true) {
            System.out.println("Введите название товара:");
            String item = ScanValues.scanStringValue();
            System.out.println("Теперь введите стоимость, например 12.34:");
            double value = ScanValues.scanDoubleValue();
            // Добавляем полученные значения в калькулятор и вывод сообщения об их добавлении
            CheckItem newItem = new CheckItem(item, value);
            calculator.addItem(newItem);
            System.out.printf("Добавлен товар '%s' стоимостью %.2f %s, в чеке %d %s на сумму %.2f %s%n",
                    item,
                    value,
                    WordEndings.convertRubles((int) Math.floor(value)),
                    calculator.items.size(),
                    WordEndings.convertGoods(calculator.items.size()),
                    calculator.getTotal(),
                    WordEndings.convertRubles((int) Math.floor(calculator.getTotal())));

            // Стадия 4: Выводим результат
            System.out.println("Введите 'Завершить' для окончания или любое слово для продолжения");
            if (ScanValues.scanStringValue().equalsIgnoreCase("Завершить")) {
                // Выводим статистику и завершаем цикл
                System.out.println(calculator.getResultAsString());
                break;
            }
        }
    }
}