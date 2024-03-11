import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 15);
        Cat cat2 = new Cat("Rex", 25);
        Cat cat3 = new Cat("Timosha", 10);
        Cat cat4 = new Cat("Kesha", 20);

        Plate plate = new Plate(20);
        plate.info();

        ArrayList <Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);


        Scanner scanner = new Scanner(System.in);
        for (Cat cat : cats) {
            plate.info();
            if (!cat.satiety()) {
                cat.eat(plate);
            }
            
            if (cat.satiety()) {
                System.out.println("кот " + cat.getName() + " сыт" );
               
            }
            while (!cat.satiety()) {
                System.out.print(
                        "Введите количество еды, которое хотите положить в тарелку, чтобы накормить остальных котов: ");
                String food = scanner.nextLine();
                plate.addFood(Integer.parseInt(food));
                plate.info();
                cat.eat(plate);
                System.out.println("кот " + cat.getName() + (cat.satiety() ? " сыт" : " голоден"));
            }

        }
        scanner.close();
        plate.info();
    }
    

    
}
