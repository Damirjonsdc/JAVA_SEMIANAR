public class Phonebook {
    public class Notebook {
        private String model;
        private int ram;
        private int hdd;
        private String os;
        private String color;

        // Конструктор класса
        public Notebook(String model, int ram, int hdd, String os, String color) {
            this.model = model;
            this.ram = ram;
            this.hdd = hdd;
            this.os = os;
            this.color = color;
        }

        // Геттеры и сеттеры для полей класса

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getRam() {
            return ram;
        }

        public void setRam(int ram) {
            this.ram = ram;
        }

        public int getHdd() {
            return hdd;
        }

        public void setHdd(int hdd) {
            this.hdd = hdd;
        }

        public String getOs() {
            return os;
        }

        public void setOs(String os) {
            this.os = os;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
        import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Dell", 8, 500, "Windows", "Black"));
        notebooks.add(new Notebook("HP", 4, 1000, "Windows", "Silver"));
        notebooks.add(new Notebook("Lenovo", 16, 1000, "Linux", "Gray"));

        Map<String, String> filterParams = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите критерии фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int choice = scanner.nextInt();

        scanner.nextLine(); // Считываем символ новой строки

        switch (choice) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int minRam = scanner.nextInt();
                filterParams.put("ram", String.valueOf(minRam));
                break;

            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minHdd = scanner.nextInt();
                filterParams.put("hdd", String.valueOf(minHdd));
                break;

            case 3:
                System.out.println("Введите операционную систему:");
                String os = scanner.nextLine();
                filterParams.put("os", os);
                break;

            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.nextLine();
                filterParams.put("color", color);
                break;

            default:
                System.out.println("Некорректный выбор");
                break;
        }

        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filterParams);

        System.out.println("Результаты фильтрации:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook.getModel());
        }
    }

    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, String> filterParams) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean passFilter = true;

            for (Map.Entry<String, String> filter : filterParams.entrySet()) {
                String key = filter.getKey();
                String value = filter.getValue();

                if (key.equals("ram") && notebook.getRam() < Integer.parseInt(value)) {
                    passFilter = false;
                    break;
                }

                if (key.equals("hdd") && notebook.getHd
                d() < Integer.parseInt(value)) {
                    passFilter = false;
                    break;
                }

                if (key.equals("os") && !notebook.getOs().equals(value)) {
                    passFilter = false;
                    break;
                }

                if (key.equals("color") && !notebook.getColor().equals(value)) {
                    passFilter = false;
                    break;
                }
            }

            if (passFilter) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }
}