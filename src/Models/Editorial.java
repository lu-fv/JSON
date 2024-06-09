package Models;

import Services.*;
import Services.impl.FileServiceImpl;
import Services.impl.LibraryServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.*;

public class Editorial {
    private FileServiceImpl fileService;
    private ILibraryService libraryService;

    public Editorial() {
        this.fileService = new FileServiceImpl<Library>("library.json");
        this.libraryService = new LibraryServiceImpl();
    }

    public void CreateAndSave() {
        try {

            this.libraryService.CreateBook(" The Lord of the ring ", " Planet ", 2010, " Tolkien ");
            this.libraryService.CreateBook(" Harry Potter ", " Planet ", 2012, " J.K. Rowling ");

            this.libraryService.CreateMagazine(" Anteojito ", " Orsai", 1998, 1);
            this.libraryService.CreateMagazine(" Billiken ", " Orsai", 1995, 12);
            this.libraryService.CreateMagazine(" mafalda ", " Ediciones de la flor", 1994, 9);

            List<Library> libraryList = this.libraryService.getLibraryList();
            fileService.Add(libraryList);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void ShowList ()  {
        try {
            List libraryListHashMap = this.fileService.Lists()  ;
            System.out.println(libraryListHashMap);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void JsonToList ()  {
        try {
            List<Library> libraryList = new ArrayList();
            List libraryListHashMap = this.fileService.Lists()  ;
            this.libraryService.HashToList(libraryListHashMap);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void DeleteInJson (String name) throws IOException {
        List<LinkedHashMap<String, Object>> l = this.fileService.Lists();
        List <LinkedHashMap<String,Object>> aux = new ArrayList<>() ;
        for (LinkedHashMap<String, Object> linkedHashMap: l){
            if (! linkedHashMap.get("name").toString().equals(name)){
                aux.add(linkedHashMap);
            }
        }
        this.fileService.Add(aux);
    }
}
