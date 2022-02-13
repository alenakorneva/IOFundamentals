package optionalTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;

public class ActionsWithFileWithRandomNumbers {
    private ArrayList<Integer> randomNumbers;

    public ActionsWithFileWithRandomNumbers(ArrayList<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public void createFileWithRandomNumbers(){
        try (BufferedWriter fileChannel =  Files.newBufferedWriter(Paths.get(PathNames.fileToWriteRandomNumbers), StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW)){
            for (Integer number : randomNumbers){
                fileChannel.write(number + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> readNumbersFromFile(){
        ArrayList<Integer> linesFromFile = new ArrayList<>();
        try(BufferedReader fileReader = new BufferedReader(new FileReader(PathNames.fileToWriteRandomNumbers))) {
            String line;
            while ((line = fileReader.readLine()) != null){
                linesFromFile.add(Integer.parseInt(line));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return linesFromFile;
    }

    public ArrayList<Integer> sortLinesFromFile(ArrayList<Integer> linesFromFile){
        Collections.sort(linesFromFile);
        return linesFromFile;
    }

    public void writeSortedNumbersInFile(ArrayList<Integer> sortedLinesFromFile){
        try (BufferedWriter fileChannel =  Files.newBufferedWriter(Paths.get(PathNames.fileToWriteRandomNumbers), StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
            fileChannel.write("\n");
            for (Integer line : sortedLinesFromFile){
                fileChannel.write(line + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
