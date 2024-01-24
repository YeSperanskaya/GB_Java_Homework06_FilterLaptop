import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class MainNotebook {
    private static Notebook filtrNotebook = new Notebook(null, 0, 0, "null", "null");

    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("MacPro", 8, 1000, "Windows XP", "pink");
        Notebook notebook2 = new Notebook("HP Powilion 5", 16, 10000, "Windows 7", "black");
        Notebook notebook3 = new Notebook("MacPro", 8, 1000, "Windows XP", "white");
        Notebook notebook4 = new Notebook("Asus 1000", 32, 100000, "Windows 10", "white");
        Notebook notebook5 = new Notebook("Huawey", 2, 100, "Windows 8", "silwer");
        Notebook notebook6 = new Notebook("MacPro 2000", 64, 1000000, "Windows 11", "gold");

        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5, notebook6));
        //printAllNotebook(notebooks);
        //filterNotebook(notebooks);
        System.out.println(filtrNotebook);
        filter(notebooks);
    }

    public static void filter(Set<Notebook> notebooks) {
        System.out.println("Есди вы хотите подобрать определнный ноутбук, то введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет ");
        System.out.println("5 - вы можете посмотреть все ноутбуки, которые у нас есть");
        System.out.println("7 - очистить фильтр");
        System.out.println("9 - еще раз посмотреть инструкцию");
        System.out.println("0 - результат поиска");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        boolean endOfFiltr = true;
        while (endOfFiltr == true) {
            switch (command) {
                // тут  меняю данные в экземпляре фильтр нотебук
                case ("1"):
                    System.out.println("Вы можете ввести желаемый объем оперативной памяти и вам будут представлены варианты ноутбуков такого объема и выше.");
                    int findRamInGB = Integer.valueOf(sc.nextLine());
                    filtrNotebook.setRamInGB(findRamInGB);
                    System.out.println(filtrNotebook);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("2"):
                    System.out.println("Вы можете ввести желаемый объем жесткого диска и вам будут представлены варианты ноутбуков такого объема и выше.");
                    int findValueHDD = Integer.valueOf(sc.nextLine());
                    filtrNotebook.setValueHDD(findValueHDD);
                    System.out.println(filtrNotebook);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("3"):
                    System.out.println("Вы можете ввести название вашей любимой операционной системы.");
                    String findOperatingSystem = sc.nextLine();
                    filtrNotebook.setOperatingSystem(findOperatingSystem);
                    System.out.println(filtrNotebook);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("4"):
                    System.out.println("Вы можете ввести название вашего любимого цвета.");
                    String findColor = sc.nextLine();
                    filtrNotebook.setColor(findColor);
                    System.out.println(filtrNotebook);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("5"):
                    printAllNotebook(notebooks);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("7"):
                    filtrNotebook.setRamInGB(0);
                    filtrNotebook.setValueHDD(0);
                    filtrNotebook.setOperatingSystem(null);
                    filtrNotebook.setColor(null);
                    System.out.println(filtrNotebook);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                case ("9"):
                    System.out.println("Есди вы хотите подобрать определнный ноутбук, то введите цифру, соответствующую необходимому критерию:");
                    System.out.println("1 - ОЗУ");
                    System.out.println("2 - Объем ЖД");
                    System.out.println("3 - Операционная система");
                    System.out.println("4 - Цвет ");
                    System.out.println("7 - очистить фильтр");
                    System.out.println("9 - еще раз посмотреть инструкцию");
                    System.out.println("0 - результат поиска");
                    command = sc.nextLine();
                    break;
                case ("0"):
                    endOfFiltr = false;
                    break;
                default:
                    System.out.println("Вы ввели неверную команду, чтобы посмотреть инструкцию введите 9");
            }

        }
        System.out.println("Выход из вайла");
        System.out.println(filtrNotebook);
        System.out.println("проверка поиска");
        findNotebooksWithFiltr(notebooks);

    }

    public static void findNotebooksWithFiltr(Set<Notebook> notebooks) {
        System.out.println("Вам могут подойти следующие ноутбуки:");
        Set<Notebook> result = new HashSet<>();
        for (Notebook note : notebooks) {
            if (filtrNotebook.getRamInGB() <= note.getRamInGB() || filtrNotebook.getRamInGB() == 0) {
                if (filtrNotebook.getValueHDD() <= note.getValueHDD() || filtrNotebook.getValueHDD() == 0) {
                    if (filtrNotebook.getOperatingSystem().equals(note.getOperatingSystem()) || filtrNotebook.getOperatingSystem().equals("null")) {
                        if (filtrNotebook.getColor().equals(note.getColor()) || filtrNotebook.getColor().equals("null")) {
                            System.out.println(note);
                        }
                    }
                }
            }
        }
        //System.out.println(result);
        System.out.println("Конец поиска!");
    }


    public static void printAllNotebook(Set<Notebook> notebooks) {
        System.out.println("В нашем интернет-магазине содержатся следующие ноутбуки:");
        System.out.println();

        for (Notebook note : notebooks) {
            System.out.println(note);
        }
        System.out.println();
    }
}



/*
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
                    String favoriteColor = sc.nextLine();
                    filterColor(notebooks, favoriteColor);
                    break;
                case ("0"):
                    return;
            }
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

     */