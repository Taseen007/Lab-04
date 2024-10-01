import java.util.ArrayList;
import java.util.List;

public class BookAnalyzer {


    public int totalBooksRead(List<Book> books) {
        return books.size();
    }

    public List<String[]> booksPerMonth(List<Book> books) {
        List<String[]> booksPerMonth = new ArrayList<>();

        for (Book book : books) {
            String month = book.getDateRead().substring(0, 7);

            boolean found = false;
            for (String[] entry : booksPerMonth) {
                if (entry[0].equals(month)) {
                    entry[1] = String.valueOf(Integer.parseInt(entry[1]) + 1);
                    found = true;
                    break;
                }
            }

            if (!found) {
                booksPerMonth.add(new String[]{month, "1"});
            }
        }

        return booksPerMonth;
    }

    public List<Book> top10LongestBooks(List<Book> books) {
        List<Book> longestBooks = new ArrayList<>();

        for (Book book : books) {
            longestBooks.add(book);

            longestBooks.sort((b1, b2) -> Integer.compare(b2.getPages(), b1.getPages()));

            if (longestBooks.size() > 10) {
                longestBooks.remove(longestBooks.size() - 1);
            }
        }

        return longestBooks;
    }

    public String mostReadGenre(List<Book> books) {
        List<String> genres = new ArrayList<>();
        List<Integer> genreCounts = new ArrayList<>();

        for (Book book : books) {
            String genre = book.getGenre();
            boolean found = false;

            for (int i = 0; i < genres.size(); i++) {
                if (genres.get(i).equals(genre)) {
                    genreCounts.set(i, genreCounts.get(i) + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                genres.add(genre);
                genreCounts.add(1);
            }
        }

        int maxCount = 0;
        String mostReadGenre = null;
        for (int i = 0; i < genres.size(); i++) {
            if (genreCounts.get(i) > maxCount) {
                maxCount = genreCounts.get(i);
                mostReadGenre = genres.get(i);
            }
        }

        return mostReadGenre;
    }

    public double averageBookLength(List<Book> books) {
        int totalPages = 0;

        for (Book book : books) {
            totalPages += book.getPages();
        }

        if (books.size() == 0) {
            return 0;
        }
        return (double) totalPages / books.size();
    }
}
