/*
Given an English book in a text file, print the 10 most commonly occurring words in descending order
Input: filename as String
Output: "<word>: <occurences>" on STDOUT for Top 10 words
 */

// 20265123
// 26501739

// 34173408
// 32024417

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task {

    public static void main(String[] args) throws FileNotFoundException {
        Task test = new Task();
        long startTime = System.nanoTime();
        //System.out.println(test.fourSum(new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000}, 294967296));
        //System.out.println(test.fourSum(new int[]{-5, 5, 5, 0, 2, 3, -2, -3, 0, 0}, 10));
        //System.out.println(test.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        test.demo();
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }


    public void demo() throws FileNotFoundException {
        Map<String, Integer> words = new HashMap();
        File myObj = new File("filename.txt");
        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                handleLine(words, data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        List<String> result = findTenMostUsed(words);
        for (int i = 0; i < 10 && i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static List<String> findTenMostUsed(Map<String, Integer> words) {
        return words.entrySet().
                stream()
                .sorted((entryOne, entryTwo) -> entryTwo.getValue().compareTo(entryOne.getValue()))
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .limit(10)
                .collect(Collectors.toList());
    }

    private static void handleLine(Map<String, Integer> words, String data) {
        String[] res = data.split("\\W");
        for (String word : res) {
            if (!word.isEmpty()) {
                String upWord = word.toUpperCase();
                if (words.containsKey(upWord)) {
                    int quantity = words.get(upWord);
                    words.put(upWord, ++quantity);
                } else {
                    words.put(upWord, 1);
                }
                //System.out.println(word);
            }
        }
    }
}
