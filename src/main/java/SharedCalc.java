import java.util.ArrayList;

public class SharedCalc {
    private int persons;
    private double total;
    ArrayList<CheckItem> items = new ArrayList<>();

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public SharedCalc() {
        this.persons = 0;
        this.total = 0f;
    }
    public void addItem(CheckItem item) {
        items.add(item);
        total += item.value;
    }

    public double getTotal() {
        return total;
    }

    public String getResultAsString() {
        StringBuilder completeList = new StringBuilder();
        // Формируем чек в виде строки
        System.out.println("Добавленные товары:");
        for (int i = 0; i < items.size(); i++) {
            completeList.append(String.format("%s\n\t\t\t%.2f %s\n",
                    items.get(i).itemName,
                    items.get(i).value,
                    WordEndings.convertRubles((int) Math.floor(items.get(i).value))));
        }
        completeList.append("------------------------\n");
        completeList.append(String.format("Итого:\n\t\t\t%.2f %s\n",
                total,
                WordEndings.convertRubles((int) Math.floor(total))));
        completeList.append("------------------------\n");
        double eachPart = Math.ceil(total / persons * 100) / 100;
        completeList.append(String.format("С каждого по %.2f %s",
                eachPart,
                WordEndings.convertRubles((int) Math.floor(eachPart))));
        // Проверяем остаток и если он есть, то делаем приписку
        double rest = total - eachPart * persons;
        if (rest < 0) completeList.append(String.format(",\nа лишние %.2f %s в качестве чаевых.", -rest, WordEndings.convertRubles((int) Math.floor(-rest))));
        return completeList.toString();
    }

}
