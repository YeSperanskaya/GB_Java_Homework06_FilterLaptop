import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainNotebook {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("MacPro", 8, 1000, "Windows XP", "pink");
        Notebook notebook2 = new Notebook("HP Powilion 5", 16, 10000, "Windows 7", "black");
        Notebook notebook3 = new Notebook("MacPro", 8, 1000, "Windows XP", "pink");
        Notebook notebook4 = new Notebook("Asus 1000", 32, 100000, "Windows 10", "white");
        Notebook notebook5 = new Notebook("Huawey", 2, 100, "Windows 8", "silwer");
        Notebook notebook6 = new Notebook("MacPro 2000", 64, 1000000, "Windows 11", "gold");

        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2,notebook3,notebook4,notebook5,notebook6));
        printAllNotebook(notebooks);







    }


    public static void printAllNotebook(Set<Notebook> notebooks) {
        System.out.println("В нашем интернет-магазине содержатся следующие ноутбуки:");
        System.out.println();

        for (Notebook note : notebooks) {
            System.out.println(note);
        }
        System.out.println();
    }

    public static void filterNotebook(String[] args) {
        System.out.println("Есди вы хотите подобрать определнный ноутбук, то введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет ");

        Scanner sc = new Scanner(System.in);
        int commandInt = sc.nextInt();
        String commandText;
        String faworiteColor;
        while (true) {
            switch (commandInt) {
                case (1):
                    System.out.println("Введите минимальный размер ОЗУ");
                    commandInt = sc.nextInt();
                case (2):
                case (3):
                case (4):
                    System.out.println("Введите ваш любимый цвет ноутбука: ");
                    faworiteColor = sc.nextLine();


            }
        }

    }

}
