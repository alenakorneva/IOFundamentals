package mainTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionsWithFilesAndDirectories {
    private Path mainDirectory;
    protected static ArrayList<String> listOfFilesAndDirectoriesInTreeStructure = new ArrayList<>();

    public ActionsWithFilesAndDirectories(Path mainDirectory) {
        this.mainDirectory = mainDirectory;
    }

    public String createGap(int level) {
        String result = "";
        for (int i = 0; i < level; i++) {
            result += " ";
        }
        return result;
    }

    public void getListOfFilesAndDirectoriesInDirectory(Path directory, int level) {
        String gap = createGap(level);
        List<File> filesAndDirectories = new ArrayList<>(Arrays.asList(directory.toFile().listFiles()));
        for (File file : filesAndDirectories) {
            if (file.isDirectory()) {
                listOfFilesAndDirectoriesInTreeStructure.add("D" + gap + file.getName());
                listOfFilesAndDirectoriesInTreeStructure.add("\n");
                getListOfFilesAndDirectoriesInDirectory(file.toPath(), level + 1);

            } else {
                listOfFilesAndDirectoriesInTreeStructure.add("F" + gap + file.getName());
                listOfFilesAndDirectoriesInTreeStructure.add("\n");
            }
            //listOfFilesAndDirectoriesInTreeStructure.add("\n");
            /*if (file.isDirectory()) {
                getListOfFilesAndDirectoriesInDirectory(file.toPath(), level + 1);
            }*/
        }
    }

    public void writeListOfFilesAndDirectoriesInTreeStructure(ArrayList<String> listOfFilesAndDirectoriesInTreeStructure) {
        for (String line : listOfFilesAndDirectoriesInTreeStructure) {
            try {
                Files.write(Paths.get(PathNames.TREE_DIRECTORIES_FROM_MAIN_TASK), line.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> readLinesFromFile() {
        String line;
        ArrayList<String> linesFromFile = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(PathNames.TREE_DIRECTORIES_FROM_MAIN_TASK))) {
            while ((line = fileReader.readLine()) != null) {
                linesFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesFromFile;
    }

    public int countDirectoriesAmount(ArrayList<String> linesFromFile) {
        int directoriesAmount = 0;
        for (String line : linesFromFile) {
            StringBuilder stringBuilderLine = new StringBuilder(line);
            if (stringBuilderLine.charAt(0) == 'D') {
                directoriesAmount++;
            }
        }
        return directoriesAmount;
    }

    public int countFilesAmount(ArrayList<String> linesFromFile) {
        int filesAmount = 0;
        for (String line : linesFromFile) {
            StringBuilder stringBuilderLine = new StringBuilder(line);
            if (stringBuilderLine.charAt(0) == 'F') {
                filesAmount++;
            }
        }
        return filesAmount;
    }

    public double countAverageFilesAmountInDirectories(int directoriesAmount, int filesAmount) {
        return (double) filesAmount / directoriesAmount;
    }

    public double countAverageFilesNameLength(ArrayList<String> linesFromFile) {
        ArrayList<Integer> filesNameLengths = new ArrayList<>();
        int sumOfLengths = 0;

        for (String line : linesFromFile) {
            StringBuilder stringBuilderLine = new StringBuilder(line);
            if (stringBuilderLine.charAt(0) == 'F') {
                filesNameLengths.add((line.substring(1).trim().length()));
            }
        }

        for (Integer fileNameLength : filesNameLengths) {
            sumOfLengths += fileNameLength;
        }
        System.out.println("Sum of all files' names is " + sumOfLengths);
        System.out.println("Total amount of files is " + filesNameLengths.size());
        return (double) sumOfLengths / filesNameLengths.size();
    }
}
