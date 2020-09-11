import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class Controller {

	public static void main(String[] args) {
		
//		String str = new String(Files.readAllLines(path).toString()
		Files.walkFileTree(Paths.get("/home/g/jpg"), new SimpleFileVisitor<Path>() {
		    @Override
		    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		        System.out.println("file: " + file);
		        return FileVisitResult.CONTINUE;
		    }
		});

	

}
