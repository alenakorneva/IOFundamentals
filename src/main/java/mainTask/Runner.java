package mainTask;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Runner {
    public static void main(String[] args) {
        Path mainDirectory = Paths.get(args[0]);
        ActionsWithFilesAndDirectories actionsWithFilesAndDirectories = new ActionsWithFilesAndDirectories(mainDirectory);
        actionsWithFilesAndDirectories.getListOfFilesAndDirectoriesInDirectory();
    }
}
