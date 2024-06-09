package Models;

import java.io.Serializable;

public class Magazine extends  Library{
    private Integer id;

    public Magazine(String name, String editorial, Integer edition, Integer id) {
        super(name, editorial, edition);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + id +
                "} " + super.toString();
    }
}
