import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVBookReader implements BookReader {
    @Override
    public List<Book> readBooks(String filePath) throws Exception {
        List<Book> books = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            Book book = new Book(values[0], values[1], values[2], Integer.parseInt(values[3]), values[4]);
            books.add(book);
        }
        br.close();
        return books;
    }
}

