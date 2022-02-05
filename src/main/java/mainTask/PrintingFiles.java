package mainTask;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

public class PrintingFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes basicFileAttributes) {
        System.out.println(directory.getFileName());
        try {
            Files.write(Paths.get("D:\\IOFundamentals\\src\\main\\resources\\treeDirectoriesFromMainTask.txt"), (directory.getFileName().toString() + "\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes basicFileAttributes) {
        System.out.println(file.getFileName());
        try {
            Files.write(Paths.get("D:\\IOFundamentals\\src\\main\\resources\\treeDirectoriesFromMainTask.txt"), (file.getFileName().toString() + "\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }
}
