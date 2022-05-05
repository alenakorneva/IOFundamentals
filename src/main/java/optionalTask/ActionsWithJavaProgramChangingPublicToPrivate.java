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

public class ActionsWithJavaProgramChangingPublicToPrivate {
    public ArrayList<String> readJavaProgramFromFile() {
        ArrayList<String> linesFromFile = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(PathNames.JAVA_PROGRAM_FOR_TASK_2))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                linesFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesFromFile;
    }

    public ArrayList<String> changePrivateModifiersToPublic(ArrayList<String> linesFromFile) {
        ArrayList<String> linesWithChangedModifiers = new ArrayList<>();
        for (String line : linesFromFile) {
            int indexOfPrivateModifier;
            StringBuilder lineInStringBuilderType = new StringBuilder(line);
            String[] wordsFromLine = line.split(" ");
            for (String word : wordsFromLine) {
                if (word.equals("private")) {
                    indexOfPrivateModifier = lineInStringBuilderType.indexOf(word);
                    lineInStringBuilderType.replace(indexOfPrivateModifier, (indexOfPrivateModifier + 7), "public");
                }
            }
            linesWithChangedModifiers.add(lineInStringBuilderType.toString());
        }
        return linesWithChangedModifiers;
    }

    public void writeInFileJvaProgramWithChangedModifiers(ArrayList<String> linesWithChangedModifiers) {
        try (BufferedWriter fileWriter = Files.newBufferedWriter(Paths.get(PathNames.JAVA_PROGRAM_FOR_TASK_2), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            fileWriter.write("\n");
            for (String line : linesWithChangedModifiers) {
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
