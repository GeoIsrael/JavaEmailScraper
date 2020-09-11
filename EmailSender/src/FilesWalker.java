

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

public class FilesWalker {
    public static void main(String[] args) throws IOException {
//        final String pwd = System.getProperty("~/jpg/");

    	final String pwd = "/home/g/jpg/";

    	Files.walk(Paths.get(pwd))
        .filter(Files::isRegularFile)
        .forEach(System.out::println);

    	
    	
        System.out.println("Working Directory = " + pwd);
        Path dir = Paths.get(pwd);
        System.out.println("Files.walk");
        try {
            Files.walk(dir, 1).forEach(path -> FilesWalker.doSomething("walk", path));
        } catch (IOException e) {
            logException("walk", e); }
        }
//        System.out.println("Files.walkFileTree");
//        try {
//            Files.walkFileTree(dir, Collections.emptySet(), 1, new SimpleFileVisitor<Path>() {
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                    doSomething("visitFile", file);
//                    return FileVisitResult.CONTINUE;
//                }
//
//                @Override
//                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//                    logException("visitFile", exc);
//                    return FileVisitResult.CONTINUE;
//                }
//            });
//        } catch (IOException e) {
//            logException("walkFileTree", e);
//        }
//        System.out.println("Files.list");
//        try {
//            Files.list(dir).forEach(path -> FilesWalker.doSomething("dir", path));
//        } catch (IOException e) {
//            logException("dir", e);
//        }
//    }

    private static void logException(String title, IOException e) {
        System.err.println(title + "\terror: " + e);
    }

    private static void doSomething(String title, Path file) {
        System.out.println(title + "\t: " + file);
    }
}
