import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLBookReader implements BookReader {
    @Override
    public List<Book> readBooks(String filePath) throws Exception {
        List<Book> books = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(filePath));
        doc.getDocumentElement().normalize();

        NodeList bookList = doc.getElementsByTagName("book");
        for (int i = 0; i < bookList.getLength(); i++) {
            Node node = bookList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Book book = new Book(
                        element.getElementsByTagName("title").item(0).getTextContent(),
                        element.getElementsByTagName("author").item(0).getTextContent(),
                        element.getElementsByTagName("genre").item(0).getTextContent(),
                        Integer.parseInt(element.getElementsByTagName("pages").item(0).getTextContent()),
                        element.getElementsByTagName("date_read").item(0).getTextContent()
                );
                books.add(book);
            }
        }
        return books;
    }
}

