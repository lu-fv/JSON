package Models;

import java.io.Serializable;

public class Book extends Library implements Serializable {
    private  String Author;

    public Book(String name, String editorial, Integer edition, String author) {
        super(name, editorial, edition);
        Author = author;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Author='" + Author + '\'' +
                "} " + super.toString();
    }
}
