public class BookReaderFactory {
    public static BookReader getBookReader(String fileType) throws Exception {
        switch (fileType.toLowerCase()) {
            case "csv":
                return new CSVBookReader();
            case "json":
                return new JSONBookReader();
            case "xml":
                return new XMLBookReader();
            default:
                throw new Exception("Unsupported file type: " + fileType);
        }
    }
}

