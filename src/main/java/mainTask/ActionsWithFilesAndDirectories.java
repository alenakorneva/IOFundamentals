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
    PrintingFiles printingFiles = new PrintingFiles();
    protected static int numberOfDirectory;
    protected static int numberOfFile;
    private Path mainDirectory;
    protected static ArrayList<String> listOfFilesAndDirectoriesInTreeStructure = new ArrayList<>();

    public ActionsWithFilesAndDirectories(Path mainDirectory) {
        this.mainDirectory = mainDirectory;
        walkDirectoryTree();
    }

    public void walkDirectoryTree() {
        try {
            Files.walkFileTree(mainDirectory, printingFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String createGap(int level) {
        String result = "";
        for (int i = 0; i < level; i++) {
            result += "\t";
        }
        return result;
    }

    public void getListOfFilesAndDirectoriesInDirectory(Path directory, int level) {
        String gap = createGap(level);
        List<File> filesAndDirectories = new ArrayList<>(Arrays.asList(directory.toFile().listFiles()));
        for (File file : filesAndDirectories) {
            System.out.println(gap + file.getName());
            listOfFilesAndDirectoriesInTreeStructure.add(gap + file.getName());
            listOfFilesAndDirectoriesInTreeStructure.add("\n");
            if (file.isDirectory()) {
                getListOfFilesAndDirectoriesInDirectory(file.toPath(), level + 1);
            }
        }
    }

    public void writeListOfFilesAndDirectoriesInTreeStructure(ArrayList<String> listOfFilesAndDirectoriesInTreeStructure) {
        for (String line : listOfFilesAndDirectoriesInTreeStructure) {
            try {
                Files.write(Paths.get(PathNames.treeDerectoriesFromMainTask), line.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String> readLinesFromFile() {
        String line;
        ArrayList<String> linesFromFile = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(PathNames.treeDerectoriesFromMainTask))) {
            while ((line = fileReader.readLine()) != null) {
                linesFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesFromFile;
    }

    public int countDirectoriesAmount(ArrayList<String> linesFromFile) {
        return numberOfDirectory;
    }

    public double countAverageFilesAmountInDirectories(int directoriesAmount, int filesAmount) {
        double count = filesAmount / directoriesAmount;
        return count;
    }

    public int countFilesAmount(ArrayList<String> linesFromFile) {
        return numberOfFile;
    }
}
