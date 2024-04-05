package org.list;

import java.io.File;
import java.util.*;

public class WishList {
    public static void main(String[] args) {
        File root = new File("./resources/wish-list.txt");
        Scanner scan = new Scanner(System.in);
        List<String> gifts = new ArrayList<>();
        boolean exit = false;
        do {
            System.out.println("Which gift you would like to add to your wish list:");
            String gift = scan.nextLine();

            //aggiungi gift all'array gifts
            gifts.add(gift);

            //ogni iterazione deve mostrare la lunghezza della lista
            System.out.println("On your wish list are " + gifts.size() + " gifts");

            System.out.println("would you like to add more gifts? Y/N");
            String addGiftOrNo = scan.nextLine().toUpperCase();
            if (Objects.equals(addGiftOrNo, "N")){
                System.out.println("Your wish list has been updated");
                exit = true;
            }
        } while (!exit);

        //ordinare la lista
        Collections.sort(gifts);

        System.out.println("On your wish list are:");
        for (String singleGift : gifts){
            System.out.println("- "+singleGift);
        }

        scan.close();
    }
}
