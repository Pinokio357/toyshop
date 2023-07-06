import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.io.FileWriter;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Toy> toys = new ArrayList<>();
        Toy toy1 = new Toy(1, "машинка", 10, 20);
        toys.add(toy1);
        Toy toy2 = new Toy(2, "кукла", 10,20);
        toys.add(toy2);
        Toy toy3 = new Toy(3, "робот", 10,60);
        toys.add(toy3);


        changeChance(toys);


        String path = "raffle_prizes.txt";
        FileWriter writer = new FileWriter(path, false);

        for (int i = 0; i < 10; i++) {

            writer.write(getPrizeToy(toys).toString() + "\n");

        }
        writer.close();

    }
    public static Toy getPrizeToy(List<Toy> mass){
        int a = mass.get(0).getChance();
        int b = mass.get(1).getChance();
        int c = mass.get(2).getChance();
        int num;
        int index = 0;
        for (int i = 0; i < 10; i++) {
            num = (int)(Math.random()*(a+b+c));
            if(num<a & num>=0){
                index = 0;
            }
            if(num>=a & num< a+b){
                index = 1;
            }
            if(num>=a+b & num<a+b+c){
                index = 2;
            }
        }
        return mass.get(index);
    }
    public static void changeChance(List<Toy> mass){
        showToys(mass);
        int choise;
        choise = getNumber("введите 1, если хотите изменить вероятность выпадения игрушки, 2 для сохранения текущих параметров","необходимо ввести число от 1 до ", 2);
        if(choise==1){
            showToys(mass);
            choise = getNumber("введите индекс изменяемой игрушки","необходимо ввести число от 1 до ",3);
            for (Toy toy: mass) {
                if(toy.getId() == choise){
                    toy.setChance(getNumber("введите значение вероятности: ","необходимо ввести число от 1 до ", 100));
                }

            }

        }
    }



    public static boolean isDigit(String message)  {
        if(message == null || message.isEmpty()){
            return false;
        }
        else{
            try{
                parseInt(message);
                return true;
            }
            catch (NumberFormatException e){
                return false;
            }
        }
    }
    public static int getNumber(String message, String errorMessage, int max){
        Scanner in = new Scanner(System.in);
        String test;
        int result = 0;
        boolean flag = false;
        while(!flag){
            System.out.println(message);
            test = in.next();
            if(isDigit(test) && parseInt(test) <= max){
                result = parseInt(test);
                flag = true;
            }
            else{
                System.out.println(errorMessage + max);
            }
        }
        return result;

    }
    public static void showToys(List<Toy> mass) {
        for (Toy toy:mass) {
            System.out.println(toy);
        }
    }
}

