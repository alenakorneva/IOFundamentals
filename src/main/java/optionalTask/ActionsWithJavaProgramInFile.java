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

public class ActionsWithJavaProgramInFile {
    private ArrayList<String> linesFromFile = new ArrayList<>();
    private ArrayList<String> linesFromFileWithReversedCharacters = new ArrayList<>();

    public ArrayList<String> readJavaProgramFromFile(){
        try(BufferedReader fileReader = new BufferedReader(new FileReader("D:\\IOFundamentals\\src\\main\\resources\\javaProgramForTask3.txt"))){
            String line;
            while ((line = fileReader.readLine()) != null){
                linesFromFile.add(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return linesFromFile;
    }

    public ArrayList<String> reverseOrderOfCharactersInEachLine(ArrayList<String> linesFromFile){
        for(String line : linesFromFile){
            StringBuffer lineInTypeOfStringBuffer = new StringBuffer(line);
            linesFromFileWithReversedCharacters.add(lineInTypeOfStringBuffer.reverse().toString());
        }
        return linesFromFileWithReversedCharacters;
    }

    public void writeInFileLinesWithReversedCharacters(ArrayList<String> linesFromFileWithReversedCharacters){
        try(BufferedWriter fileWriter = Files.newBufferedWriter(Paths.get("D:\\IOFundamentals\\src\\main\\resources\\javaProgramForTask3.txt"), StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
            fileWriter.write("\n");
            for (String line : linesFromFileWithReversedCharacters){
                fileWriter.write(line + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
