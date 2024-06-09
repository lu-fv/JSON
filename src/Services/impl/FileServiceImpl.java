package Services.impl;

import Models.Library;
import Services.IFileService;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl<T> {
    private ObjectMapper mapper = new ObjectMapper();
    private String pathname;

    public FileServiceImpl(String pathname) {
        this.pathname = pathname;
    }

    public void Add(List<T> tList) throws IOException {
        try {
            this.mapper.writeValue(new File(this.pathname), tList);

        } catch (StreamWriteException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        }
    }


    public void Delete(T t) {

    }

    public  List<T> Lists() throws IOException {
        List tList = new ArrayList<>();
        try {
            tList = this.mapper.readValue(new File(this.pathname), List.class);

        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tList;
    }

}
