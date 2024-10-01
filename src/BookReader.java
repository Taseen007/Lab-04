import java.util.List;

public interface BookReader {
    List<Book> readBooks(String filePath) throws Exception;
}

