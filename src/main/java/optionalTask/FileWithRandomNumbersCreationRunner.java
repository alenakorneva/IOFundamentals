package optionalTask;

import java.util.ArrayList;

public class FileWithRandomNumbersCreationRunner {
    private static ArrayList<Integer> randomNumbers;
    static {
        randomNumbers = new ArrayList<Integer>(){{
            add((int) (Math.random()*10));
            add((int) (Math.random()*100));
            add((int) (Math.random()*100));
        }};
    }

    public static void main(String[] args){
        FileWithRandomNumbersCreation file = new FileWithRandomNumbersCreation(randomNumbers);
        file.createFileWithRandomNumbers();
        ArrayList <Integer> linesFromFile = file.readNumbersFromFile();
        ArrayList<Integer> sortedLinesFromFile = file.sortLinesFromFile(linesFromFile);
        file.writeSortedNumbersInFile(sortedLinesFromFile);
    }
}
