package Services;

import Models.Library;

import java.io.IOException;
import java.util.List;

public interface IFileService {

    public void Add(List<Library> tList) throws IOException;
}
