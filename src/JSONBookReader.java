import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JSONBookReader implements BookReader {
    @Override
    public List<Book> readBooks(String filePath) throws Exception {
        List<Book> books = new ArrayList<>();

        // Reading the entire JSON file into a String
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();

        // Parse the JSON content
        JSONArray jsonArray = new JSONArray(sb.toString());

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            // Extract each field from the JSON object
            String title = jsonObject.getString("title");
            String author = jsonObject.getString("author");
            String genre = jsonObject.getString("genre");
            int pages = jsonObject.getInt("pages");
            String dateRead = jsonObject.getString("date_read");

            // Create a new Book object and add it to the list
            Book book = new Book(title, author, genre, pages, dateRead);
            books.add(book);
        }

        return books;
    }
}

