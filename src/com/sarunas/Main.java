package com.sarunas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String word = "asf5g5g66";
        if (outputString(word)) {
            System.out.println(word);
        }

        Scanner inFile = new Scanner(new FileReader("inputs.txt"));
        String inputs = inFile.nextLine();
        String txtFile = "inputs.txt";

        ArrayList<String> words = words(txtFile);
        for (int i = 0; i < words.size(); i++) {
            if (outputString(words.get(i))) {
                System.out.println(words.get(i));
            }
        }
    }

    public static ArrayList<String> words(String txtFile) {
        ArrayList<String> words = new ArrayList<>();
        try {
            File file = new File(txtFile);
            Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String word = myReader.nextLine();
            words.add(word);
        }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return words;
    }

    public static Boolean outputString(String word) {
        String[] str = Parse(word).toArray(new String[0]);
        for (String s : str) {
            try {
                int val = (Integer.parseInt(s));
                if (val >= 10) {
                    return true;
                }
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return false;
    }

    private static List<String> Parse(String str) {
        List<String> output = new ArrayList<String>();
        Matcher match = Pattern.compile("[0-9]+|[a-z]+|[A-Z]+").matcher(str);
        while (match.find()) {
            output.add(match.group());
        }
        return output;
    }

}

