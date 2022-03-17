package mainTask;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintingFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes basicFileAttributes) {
        ActionsWithFilesAndDirectories.numberOfDirectory++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes basicFileAttributes) {
        ActionsWithFilesAndDirectories.numberOfFile++;
        return FileVisitResult.CONTINUE;
    }
}
