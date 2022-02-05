package optionalTask;

import java.util.ArrayList;

public class ActionsWithFileWithRandomNumbersRunner {
    private static ArrayList<Integer> randomNumbers;

    static {
        randomNumbers = new ArrayList<Integer>(){{
            add((int) (Math.random()*10));
            add((int) (Math.random()*100));
            add((int) (Math.random()*100));
        }};
    }

    public static void main(String[] args){
        ActionsWithFileWithRandomNumbers file = new ActionsWithFileWithRandomNumbers(randomNumbers);
        file.createFileWithRandomNumbers();
        ArrayList <Integer> linesFromFile = file.readNumbersFromFile();
        ArrayList<Integer> sortedLinesFromFile = file.sortLinesFromFile(linesFromFile);
        file.writeSortedNumbersInFile(sortedLinesFromFile);
    }
}
