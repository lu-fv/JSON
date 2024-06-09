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

    public void Read ()  {
        try {
            List<Library> libraryList = new ArrayList();
            List libraryListHashMap = this.fileService.Lists()  ;

            libraryListHashMap.forEach((x)-> {
                Book library = (Book) x;
                System.out.println(x);
                System.out.println(library);
            });
            System.out.println(libraryList);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
