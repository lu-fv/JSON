package Models;
import java.io.Serializable;
public abstract class Library {

    private String name;
    private String editorial;
    private Integer edition;

    public Library(String name, String editorial, Integer edition) {
        this.name = name;
        this.editorial = editorial;
        this.edition = edition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", editorial='" + editorial + '\'' +
                ", edition=" + edition +
                '}';
    }

}
