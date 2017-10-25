package com.company;
import java.util.Scanner;


public class Main {
    //inialized global things
    static Scanner scnr = new Scanner(System.in);
    static String menu = "Please select the option you would like to see\n\n1. Display character frequencies alphabetically\n2. Display sorted frequencies\n3.Show types of character frequencies\n4. Quit\n";
    static int i;

    //FIRST FUNCTION
    public static void alphabeticalSort(String userString) {
        int stringLength = userString.length();
        char[] characterArray = new char[stringLength];
        int[] characterFrequency = new int[95];


        //populates array of strings with individual characters
        for (i = 0; i < stringLength; ++i) {
            characterArray[i] = userString.charAt(i);
        }

        //runs through each letter of the array and adds one to character frequency for each occurance
        for (int j = 0; j < stringLength; ++j) {
            for (i = 32; i < 127; ++i) {
                if (characterArray[j] == i) {
                    ++characterFrequency[i - 32];
                }
            }
        }

        //if frequency is greater than 0, prints and runs through all characters
        for (i = 0; i < 95; ++i) {
            if (characterFrequency[i] > 0) {
                System.out.println(((char) (i + 32)) + " frequency: " + characterFrequency[i]);
            }
        }
        System.out.println();
    }


    //SECOND FUNCTION

    public static void frequencySort(String userString) {
        System.out.println("The sorted by frequency characters are:\n\n");
        int stringLength = userString.length();
        char[] characterArray = new char[stringLength];
        int[] characterFrequency = new int[95];


        //populates array of strings with individual characters
        for (i = 0; i < stringLength; ++i) {
            characterArray[i] = userString.charAt(i);
        }

        //runs through each letter of the array and adds one to character frequency for each occurance
        for (int j = 0; j < stringLength; ++j) {
            for (i = 32; i < 127; ++i) {
                if (characterArray[j] == i) {
                    ++characterFrequency[i - 32];
                }
            }
        }

        //populates new character array with all symbols
        char[] newAllSymbols = new char[95];
        for (i = 32; i < 127; ++i) {
            newAllSymbols[i - 32] = (char) (i);
        }

        //sorts array from greatest to least, pairs characters with respective place in frequency array
        int temp;
        for (int i = 0; i < characterFrequency.length - 1; ++i) {
            for (int j = 0; j < characterFrequency.length - 1; ++j) {
                if (characterFrequency[j + 1] > characterFrequency[j]) {
                    int tempPlaceholder;
                    tempPlaceholder = characterFrequency[j + 1];
                    characterFrequency[j + 1] = characterFrequency[j];
                    characterFrequency[j] = tempPlaceholder;
                    char tempPlaceholderchar;
                    tempPlaceholderchar = newAllSymbols[j + 1];
                    newAllSymbols[j + 1] = newAllSymbols[j];
                    newAllSymbols[j] = tempPlaceholderchar;

                }
            }
        }
        for (i = 0; i < 95; ++i) {
            if (characterFrequency[i] > 0)
                System.out.println(newAllSymbols[i] + " frequency: " + characterFrequency[i]);
        }
        System.out.println();
    }


    public static void charTypes(String userString) {
        int stringLength = userString.length();
        char[] characterArray = new char[stringLength];
        int[] characterFrequency = new int[95];
        int textCount = 0;
        int symbolCount = 0;
        int whiteSpaceCount = 0;
        int numberCount = 0;


        //populates array of strings with individual characters
        for (i = 0; i < stringLength; ++i) {
            characterArray[i] = userString.charAt(i);
        }

        //adds to each count dependant upon the ASCII value
        for (int j = 0; j < stringLength; ++j) {
            if (characterArray[j] == 32) {
                ++whiteSpaceCount;
            } else if ((characterArray[j] <= 57) && (characterArray[j] >= 48)) {
                ++numberCount;
            } else if (((characterArray[j] >= 65) && characterArray[j] <= 90) || ((characterArray[j] >= 97) && characterArray[j] <= 122)) {
                ++textCount;
            } else {
                ++symbolCount;
            }
        }

        //prints values
        System.out.println("Textual Character count: " + textCount);
        System.out.println("Numerical Character count: " + numberCount);
        System.out.println("White Space Character count: " + whiteSpaceCount);
        System.out.println("Symbol Character count: " + symbolCount);
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Character Sorter Program");
        System.out.println("Please enter a string to be sorted");
        String userString = scnr.nextLine();
        System.out.println(menu);
        boolean start = true;
        int userInput=0;


        //loops if statements that call respecitve methods
        while (start) {
            try {
                userInput = scnr.nextInt();
                if ((userInput < 1) || userInput > 4) {
                    System.out.println("Error, bad input,please enter number 1-4");
                }
            }catch(Exception e){
                System.out.println("Error, bad input, please enter number 1-4");
                scnr.nextLine();
            }

            //if userinput is integer not 1-4 prints error message


            //sorts alphabetically
            if (userInput == 1) {
                alphabeticalSort(userString);
                System.out.println(menu);
            }

            //runs sort by frequency
            if (userInput == 2) {
                frequencySort(userString);
                System.out.println(menu);
            }

            //runs charType function
            if (userInput == 3) {
                charTypes(userString);
                System.out.println(menu);
            }
            if (userInput == 4) {
                System.out.println("Character sorter exited succesfully");
                start = false;
                return;
            }
        }
    }
}