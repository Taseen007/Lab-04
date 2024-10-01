public class Book {
    private String title;
    private String author;
    private String genre;
    private int pages;
    private String dateRead;

    public Book(String title, String author, String genre, int pages, String dateRead) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.dateRead = dateRead;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getGenre() {
        return genre;
    }

    public String getDateRead() {
        return dateRead;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + pages + " pages)";
    }
}

