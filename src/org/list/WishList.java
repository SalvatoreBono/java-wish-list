package org.list;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WishList {
    public static void main(String[] args) {
        //file txt
        File root = new File("./resources/wish-list.txt");
        List<String> myWishList  = new ArrayList<>();

        try {
            //recuperare dati nel file
            Scanner readingFile = new Scanner(root);
            //finchè readingFile ha una linea
            while (readingFile.hasNextLine()){
                //aggiungo nella myWishList  i file txt
                myWishList.add(readingFile.nextLine().replaceAll("- ",""));
            }
            readingFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("Which gift you would like to add to your wish list:");
            String gift = scan.nextLine();

            //aggiungi gift all'array gifts
            myWishList .add(gift);

            //ogni iterazione deve mostrare la lunghezza della lista
            System.out.println("On your wish list are " + myWishList .size() + " gifts");

            System.out.println("would you like to add more gifts? Y/N");
            String addGiftOrNo = scan.nextLine().toUpperCase();
            if (Objects.equals(addGiftOrNo, "N")){
                System.out.println("Your wish list has been updated");
                exit = true;
            }
        } while (!exit);

        //ordinare la lista
        Collections.sort(myWishList );

        try {
            //percorso dove scrivere
            FileWriter fileWriter = new FileWriter(root);

            System.out.println("On your wish list are:");
            for (String singleGift : myWishList ){
                //scrivi nel file
                fileWriter.write("- "+singleGift +"\n");
                System.out.println("- "+singleGift);
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        scan.close();
    }
}
