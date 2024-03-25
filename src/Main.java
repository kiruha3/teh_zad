import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.ceil;

public class Main {
    public static final Integer SHELF = 5;

    public static void main(String[] args) {
        List<String> listBook = Arrays.asList("Война и мир", "Преступление и наказание", "Мастер и Маргарита", "1984",
                "Унесённые ветром", "Гарри Поттер и Философский камень", "Маленький принц", "Три товарища",
                "Граф Монте-Кристо", "Анна Каренина", "Гарри Поттер и Тайная комната", "Гарри Поттер и узник Азкабана",
                "Гарри Поттер и Кубок огня", "Гарри Поттер и Орден Феникса", "Гарри Поттер и Принц-полукровка",
                "Гарри Поттер и Дары Смерти", "Алиса в Стране чудес", "Алиса в Зазеркалье", "Лев, ведьма и платяной шкаф",
                "Приключения Шерлока Холмса", "Джейн Эйр", "Ветер в ивах", "Властелин колец: Братство кольца",
                "Властелин колец: Две крепости", "Властелин колец: Возвращение короля", "Гарри Поттер и Проклятое дитя",
                "Фауст", "Ромео и Джульетта", "Грозовой перевал", "Триумфальная арка", "Мертвые души", "Мёртвые души",
                "Три мушкетёра", "Отверженные", "Жизнь и судьба", "Идиот");
        int countBooksPerShelf = (listBook.size() / SHELF);
        printSortBooks(SHELF, countBooksPerShelf, sortBooks(listBook));
    }

    private static void printSortBooks(Integer SHELF, int countBooksPerShelf, String[][] sortBooks) {
        for (int i = 0; i < SHELF; i++) {
            for (int j = 0; j < countBooksPerShelf + 1; j++) {
                System.out.print(sortBooks[i][j] + "|");
            }
            System.out.println(" " + "\n");
        }
        System.out.println();
    }

    private static String[][] sortBooks(List<String> listBook) {
        List<String> sortedList = listBook.stream().sorted().collect(Collectors.toList());

        int countBooksPerShelf = (int) Math.ceil((double) sortedList.size() / SHELF);

        String[][] shelfWithBook = new String[SHELF][countBooksPerShelf];
        int j = 0;
        int i = 0;
        for (String s : sortedList) {
            shelfWithBook[i][j] = s;
            j++;
            if (j == countBooksPerShelf) {
                i++;
                j = 0;
            }

        }
        return shelfWithBook;

    }

}