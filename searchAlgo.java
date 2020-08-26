package SimpleSearch;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Scanner;

interface searchAlgo {

    ArrayList<Integer> finder(HashMap<String, ArrayList<Integer>> index);

}

class all implements searchAlgo {

    @Override
    public ArrayList<Integer> finder(HashMap<String, ArrayList<Integer>> index) {
        String fourth = "\nEnter a name or email to search all suitable people.\n";
        Scanner scan2 = new Scanner(System.in);

        System.out.println(fourth);
        String c = scan2.nextLine();
        String y = c.toLowerCase();

        System.out.println("\nFound data:");
        if (index.containsKey(y)) {
            return index.get(y);
        }
        return new ArrayList<>();
    }
}

class any implements searchAlgo {

    @Override
    public ArrayList<Integer> finder(HashMap<String, ArrayList<Integer>> index) {
        String fourth = "\nEnter a name or email to search all suitable people.\n";
        Scanner scan2 = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();

        System.out.println(fourth);
        String c = scan2.nextLine();
        String[] y = c.toLowerCase().split(" ");

        System.out.println("\nFound data:");
        for (int i = 0; i < y.length; i++) {
            if (index.containsKey(y[i])) {
                a.addAll(index.get(y[i]));
            }
        }
        return a;
    }
}

class none implements searchAlgo {

    @Override
    public ArrayList<Integer> finder(HashMap<String, ArrayList<Integer>> index) {

        String fourth = "\nEnter a name or email to search all suitable people.\n";
        Scanner scan2 = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();

        System.out.println(fourth);
        String c = scan2.nextLine();
        String[] y = c.toLowerCase().split(" ");

        System.out.println("\nFound data:");
        for (int i = 0; i < y.length; i++) {
            if (index.containsKey(y[i])) {
                a.addAll(index.get(y[i]));
            }
        }
        return a;

    }
}
