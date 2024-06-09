package Interfaces;

import java.util.List;

public interface IServiceFile <T> {

    public void Add ( T t);
    public void Delete (T t);
    public List<Object> Lists ( );

}
