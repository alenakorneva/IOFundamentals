package mainTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ActionsWithFilesAndDirectories {
    private Path mainDirectory;
    PrintingFiles printingFiles = new PrintingFiles();

    public ActionsWithFilesAndDirectories(Path directory) {
        this.mainDirectory = directory;
    }

    public void getListOfFilesAndDirectoriesInDirectory() {
        try {
            Files.walkFileTree(mainDirectory, printingFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
