package mainTask;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        Path mainDirectory = Paths.get(args[0]);
        ActionsWithFilesAndDirectories actionsWithFilesAndDirectories = new ActionsWithFilesAndDirectories(mainDirectory);
        actionsWithFilesAndDirectories.getListOfFilesAndDirectoriesInDirectory(mainDirectory, 1);
        actionsWithFilesAndDirectories.writeListOfFilesAndDirectoriesInTreeStructure(ActionsWithFilesAndDirectories.listOfFilesAndDirectoriesInTreeStructure);
        ArrayList<String> linesFromFile = actionsWithFilesAndDirectories.readLinesFromFile();
        int directoriesAmount = actionsWithFilesAndDirectories.countDirectoriesAmount(linesFromFile);
        System.out.println(directoriesAmount);
        int filesAmount = actionsWithFilesAndDirectories.countFilesAmount(linesFromFile);
        System.out.println(filesAmount);
        double averageAmountOfFilesInDirectories = actionsWithFilesAndDirectories.countAverageFilesAmountInDirectories(directoriesAmount, filesAmount);
        System.out.println(averageAmountOfFilesInDirectories);
    }
}
