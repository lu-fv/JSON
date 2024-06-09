package Services.impl;

import Models.*;
import Services.*;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.*;

public class LibraryServiceImpl implements ILibraryService {

    private List<Library> libraryList = new ArrayList<>();

    @Override
    public void CreateMagazine(String name, String editorial, Integer edition, Integer id) {
        try {
            if (name == null || editorial == null || edition == null || id == null) {
                throw new IllegalArgumentException(" This information is null ");
            }
            if (id <= 0) {
                throw new IllegalArgumentException(" the Id has to be greater than 0 ");
            }
            if (this.Exist(name)) {
                throw new InvalidObjectException(" this magazine is already exist ");
            }
            Magazine magazine = new Magazine(name, editorial, edition, id);
            this.libraryList.add(magazine);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvalidObjectException e) {
            e.printStackTrace(); //search browser
        }
    }

    @Override
    public void CreateBook(String name, String editorial, Integer edition, String author) {
        try {
            if (name == null || editorial == null || edition == null || author == null) {
                throw new IllegalArgumentException(" This information is null ");
            }
            if (this.Exist(name)) {
                throw new InvalidObjectException(" this book is already exist ");
            }
            Book book = new Book(name, editorial, edition, author);
            this.libraryList.add(book);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }

    }

    private Boolean Exist(String name) {
        boolean isExist = false;
        for (Library l : libraryList) {
            if (l.getName().equals(name)) {
                isExist = true;
            }

        }
        return isExist;
    }

    public List<Library> getLibraryList() {
        return libraryList;
    }

    public void HashToList(List<LinkedHashMap<String, Object>> linkedHashMap) {
        linkedHashMap.forEach((x) -> {
            if (x.containsKey("id")) {
               this.CreateMagazine(x.get("name").toString(), x.get("editorial").toString(), (Integer) x.get("edition"), (Integer) x.get("id"));
            } else {
               this.CreateBook(x.get("name").toString(), x.get("editorial").toString(), (Integer) x.get("edition"), x.get("author").toString());
            }
        });
    }
}
