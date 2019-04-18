/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whojavatestfx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author MSI-PC
 */
public class Array {
    static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<String> array = createArray();
        
        printArray(array);
        insertElement(array);
        
        System.out.println("\n------ FINAL ARRAY ------");
        System.out.println(array);
    }
    
    public static String arrayToString(ArrayList<String> array) {
        ArrayList<String> indexedList = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            indexedList.add(Integer.toString(i) + "." + array.get(i));
        }
        
        return ("[" + String.join(", ", indexedList) + "]");
    }
    
    public static ArrayList<String> createArray() {
        System.out.println("Fill the array.\nType 'stop' to finish.");
        ArrayList<String> array = new ArrayList<>();
        
        fillArray(array);
        
        return array;
    }
    
    public static void fillArray(ArrayList<String> array) {
        System.out.print("Type the next number to put into the array: ");
        String nextElement = input.nextLine();
        if (!nextElement.equals("stop")) {
            array.add(nextElement);
            fillArray(array);
        }
    }
    
    public static void insertElement(ArrayList<String> array){
        System.out.print("Do you want to insert another element [y | n]: ");
        String addElementChoice = input.nextLine();
        if (addElementChoice.equals("y")) {
            Integer index = defineIndex(array);
            while (!((index >= 0) && (index <= array.size()-1))) {
                System.out.println("Index out of bounds. Try again.");
                index = defineIndex(array);
            }
            System.out.print("Type the element to input: ");
            array.add(index, input.nextLine());
            printArray(array);
            
            insertElement(array);   
        } else if (!(addElementChoice.equals("y") || addElementChoice.equals("n"))) {
            System.out.println("Unknown command. Try again.");
            insertElement(array);
        }
    }
    
    public static int defineIndex(ArrayList<String> array) {
        String outputMessage = String.format("Choose the index between %d and %d: ", 0, array.size()-1);
        System.out.print(outputMessage);
        Integer index = Integer.parseInt(input.nextLine());
        
        return index;
    }
    
    public static void printArray(ArrayList<String> array) {
        System.out.print("Select how to print out the array [array | column]: ");
        String choice = input.nextLine();
        if (choice.equals("array")) {
            System.out.println(array);
        } else if (choice.equals("column")) {
            printColumn(array);
        } else {
            System.out.println("Unknown command. Try again.");
            printArray(array);
        }
    }
    
    public static void printColumn(ArrayList<String> list) {
        list.forEach((element) -> {
            System.out.println(element);
        });
    }
}
