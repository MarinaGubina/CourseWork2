package theory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args){
//Напишите Java-программу для проверки является ли введенное число - числом Армстронга.

        int number = 13455;
        int length = (int) (Math.log10(number)+1);
        int sum = 0;
        int n = number;
        while (!(n == 0)){
            sum += Math.pow(n%10,length);
            n = n/10;
        }
        boolean result = (sum == number);
        System.out.println(result);

        //Дан List <String> names. Удалите первую букву из каждого имени и верните отсортированный список.

        List<String> names = new LinkedList<>();
        names.add("Masha");
        names.add("Petya");
        names.add("Olga");
        names.add("Maksim");

        for (int i = 0; i < names.size(); i++){
            names.set(i,names.get(i).substring(1));
        }

        Collections.sort(names);
        System.out.println(names);
    }
}
