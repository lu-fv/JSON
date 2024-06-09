package Services;

import Models.Library;

import java.util.List;

public interface ILibraryService {

    public void CreateMagazine(String name, String editorial, Integer edition, Integer id);

    public void CreateBook(String name, String editorial, Integer edition, String author);

    public List<Library> getLibraryList();
}
