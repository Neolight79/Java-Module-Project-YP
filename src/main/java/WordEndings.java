public class WordEndings {
    public static String convertWord(String root, String oneItemEnd, String twoItemsEnd, String manyItemsEnd, int count) {
        if (count % 10 == 1 && !(count / 10 % 10 == 1)) return root + oneItemEnd;  // Если существительное в единственном числе
        else if (count % 10 > 1 && count % 10 < 5 && !(count / 10 % 10 == 1)) return root + twoItemsEnd;  // Если существительное от 2 до 4, кроме дцать
        else return root + manyItemsEnd;  // Если существительное во множественном числе
    }

    public static String convertRubles(int count) {
        return convertWord("рубл", "ь", "я", "ей", count);
    }

    public static String convertPersons(int count) {
        return convertWord("персон", "у", "ы", "", count);
    }
    public static String convertGoods(int count) {
        return convertWord("товар", "", "а", "ов", count);
    }
}
