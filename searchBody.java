package SimpleSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class searchBody {
    ArrayList<String> data = new ArrayList<>();
    HashMap<String, ArrayList<Integer>> invIndex = new HashMap<>();
    //File names = new File("C:/Users/Kyle/Desktop/names.txt");

    void search(String inFileName) throws FileNotFoundException {
        File file = new File(inFileName);

        if (file.isFile()) {
            try (Scanner scan = new Scanner(file)) {
                int a = 0;

                while (scan.hasNextLine()) {
                    String aa = scan.nextLine();

                    data.add(aa);

                    for (String s : aa.split(" ")) {
                        s = s.toLowerCase();

                        if (invIndex.containsKey(s)) {
                            invIndex.get(s).add(a);
                        } else {
                            invIndex.put(s, new ArrayList<>(List.of(a)));
                        }
                    }
                    a++;
                }
            }
        } else {
            System.out.println("Error! File not found.");
            //return;
        }
        menu();
    }

    void menu() {
        Scanner scan = new Scanner(System.in);
        String third = "=== Menu ===\n" + "1. Find a person\n" + "2. Print all people\n" + "0. Exit";
        //String fourth = "Enter a name or email to search all suitable people.\n";
        String fifth = "Select a matching strategy: ALL, ANY, NONE\n";

        //boolean u = true;
        boolean t = true;

        while (t) {
            System.out.println(third);

            switch (scan.nextInt()) {
                case 0:
                    System.out.println("\nciao!");
                    t = false;
                    break;

                case 1:
                    System.out.print("\n" + fifth);
                    //scan.next();

                    switch(scan.next()) {

                        case "ALL" :
                            all awl = new all();
                            ArrayList<Integer> awwl = awl.finder(invIndex);

                            if (awwl.size() == 0) {
                                System.out.println("\nNOT FOUND\n");
                                break;
                            }
                            for (int aw : awwl) {
                                System.out.println(data.get(aw));
                            }
                            System.out.println("");
                            break;


                        case "ANY" :
                            any owl = new any();
                            ArrayList<Integer> owwl = owl.finder(invIndex);

                            if (owwl.size() == 0) {
                                System.out.println("\nNOT FOUND\n");
                                break;
                            }
                            for (int ow : owwl) {
                                System.out.println(data.get(ow));
                            }
                            System.out.println("");
                            break;


                        case "NONE" :
                            none uwl = new none();
                            ArrayList<Integer> uwwl = uwl.finder(invIndex);
                            ArrayList<String> dataa = data;
                            int c = 0;

                            if (uwwl.size() == 0) {
                                System.out.println("\nNOT FOUND\n");
                                break;
                            }
                            Collections.sort(uwwl);
                            for (int uw : uwwl) {
                                dataa.remove(uw - c);
                                c += 1;
                            }

                            for (String u : dataa) {
                                System.out.println(u);
                            }
                            System.out.println("");
                            //System.out.println(uwwl.toString());
                            //System.out.println(data.toString());
                            break;


                        default:
                            System.out.println("\nTry again.\n");
                            break;

                    }

                    t = true;
                    break;

                case 2:
                    System.out.println("\n=== List of people ===");
                    for (String dat : data) {
                        System.out.println(dat);
                    }
                    System.out.println("");
                    t = true;
                    break;

                default:
                    System.out.println("\nIncorrect option! Try again.\n");
                    t = true;
                    break;
            }

        }
    }

}
