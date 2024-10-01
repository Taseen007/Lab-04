import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "C:\\Users\\User\\Downloads\\Lab4\\src\\Book.XML";
            String fileType = getFileExtension(filePath);

            BookReader bookReader = BookReaderFactory.getBookReader(fileType);
            List<Book> books = bookReader.readBooks(filePath);

            BookAnalyzer analyzer = new BookAnalyzer();


            System.out.println("Total books read: " + analyzer.totalBooksRead(books));


            System.out.println("Books per month:");
            List<String[]> booksPerMonth = analyzer.booksPerMonth(books);
            for (String[] entry : booksPerMonth) {
                System.out.println(entry[0] + ": " + entry[1] + " books");
            }


            System.out.println("Top 10 longest books: " + analyzer.top10LongestBooks(books));


            System.out.println("Most read genre: " + analyzer.mostReadGenre(books));


            System.out.println("Average book length: " + analyzer.averageBookLength(books));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return "";
        }
        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }
}

