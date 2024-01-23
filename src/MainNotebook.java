import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class MainNotebook {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("MacPro", 8, 1000, "Windows XP", "pink");
        Notebook notebook2 = new Notebook("HP Powilion 5", 16, 10000, "Windows 7", "black");
        Notebook notebook3 = new Notebook("MacPro", 8, 1000, "Windows XP", "white");
        Notebook notebook4 = new Notebook("Asus 1000", 32, 100000, "Windows 10", "white");
        Notebook notebook5 = new Notebook("Huawey", 2, 100, "Windows 8", "silwer");
        Notebook notebook6 = new Notebook("MacPro 2000", 64, 1000000, "Windows 11", "gold");

        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5, notebook6));
        printAllNotebook(notebooks);
        filterNotebook(notebooks);
        //Scanner sc = new Scanner(System.in);
        //System.out.println("проверка:");
        //String str = sc.nextLine();
        //System.out.println(str);
        System.out.println("А вот это конец мэйна!");
    }


    public static void printAllNotebook(Set<Notebook> notebooks) {
        System.out.println("В нашем интернет-магазине содержатся следующие ноутбуки:");
        System.out.println();

        for (Notebook note : notebooks) {
            System.out.println(note);
        }
        System.out.println();
    }

    public static void filterNotebook(Set<Notebook> notebooks) {
        System.out.println("Есди вы хотите подобрать определнный ноутбук, то введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет ");
        System.out.println("0 - Окончание работы. ");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

            switch (command) {
                case ("1"):
                    System.out.println("Вы можете ввести желаемый объем оперативной памяти и вам будут представлены варианты ноутбуков такого объема и выше.");
                    filterRamInGB(notebooks, sc.nextInt());
                    break;
                case ("2"):
                    System.out.println("Вы можете ввести желаемый объем жесткого диска и вам будут представлены варианты ноутбуков такого объема и выше.");
                    filterValueHDD(notebooks, sc.nextInt());
                    break;
                case ("3"):
                    System.out.println("Вы можете ввести название вашей любимой операционной системы.");
                    String favoriteOperatingSystem = sc.nextLine();
                    filterOperatingSystem(notebooks, favoriteOperatingSystem);
                    break;
                case ("4"):
                    System.out.println("Вы можете ввести название вашего любимого цвета.");
                    String favoriteColor = String.valueOf(sc.nextLine());
                    filterColor(notebooks, favoriteColor);
                    break;
                case ("0"):
                    return;
            }
            System.out.println("Программа фильтра завершилась успешно!");


    }

// рабочий код по поиску оперативной памяти
    public static void filterRamInGB(Set<Notebook> notebooks, int favoriteRamInGB) {
        System.out.println("Проверка размера оперативной памяти");
        for (Notebook note : notebooks) {
            int existRamInGB = note.getRamInGB();
            if (existRamInGB >= favoriteRamInGB) {
                System.out.println(note);
            }
        }
    }
//рабочий код по поиску размера жесткого диска
    public static void filterValueHDD(Set<Notebook> notebooks, int favoriteValueHDD) {
        System.out.println("Проверка размера жесткого диска");
        for (Notebook note : notebooks) {
            int existValueHDD = note.getValueHDD();
            if (existValueHDD >= favoriteValueHDD) {
                System.out.println(note);
            }
        }
    }

    // рабочий код по поиску операционной системы
    public static void filterOperatingSystem(Set<Notebook> notebooks, String favoriteOperatingSystem) {
        System.out.println("Проверка операционной системы");
        for (Notebook note : notebooks) {
            String existOperatingSystem = note.getOperatingSystem();
            if (existOperatingSystem.equals(favoriteOperatingSystem)) {
                System.out.println(note);
            }
        }
    }


    // рабочий код по поиску цвета ноутбука!
    public static void filterColor(Set<Notebook> notebooks, String favoriteColor) {
        System.out.println("Проверка цвета");
        for (Notebook note : notebooks) {
            String existColor = note.getColor();
            if (existColor.equals(favoriteColor)) {
                System.out.println(note);
            }
        }
    }


}