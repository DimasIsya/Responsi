package DAOImplement;


import java.util.List;
import Model.*;

public interface datapimplement {
    
    public void insert(datap p);
    public void update(datap p);
    public void tampil(datap p); 
    public void delete(int id);
    public List<datap> getAll();
    
}
