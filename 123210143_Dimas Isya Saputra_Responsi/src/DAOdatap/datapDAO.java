package DAOdatap;

import java.sql.*;
import java.util.*;
import Koneksi.Connector;
import model.*;
import DAOImplement.datapimplement;
import Model.datap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class datapDAO implements datapimplement {
    Connection connection;
    
    final String select = "select * from perpustakaan;";
    final String insert = "INSERT INTO dataperpus (judul, genre, penulis, penerbit, lokasi) VALUES (?, ?, ?, ?, ?);";
    final String update = "update dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=? where id=?, stock=?";
    final String delete = "delete from dataperpus where id=?, stock=?";
    public datapDAO(){
        connection = Connector.connection();
    }

    @Override
    public void insert(datap p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datap p) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getJudul());
            statement.setString(2, p.getGenre());
            statement.setString(3, p.getPenulis());
            statement.setString(4, p.getPenerbit());
            statement.setString(5, p.getLokasi());
            statement.setInt(5, p.getStock());
            statement.setInt(6, p.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datap> getAll() {
        List<datap> dp = null;
        try{
            dp = new ArrayList<datap>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datap p = new datap();
                p.setId(rs.getInt("id"));
                p.setJudul(rs.getString("judul"));
                p.setGenre(rs.getString("genre"));
                p.setPenulis(rs.getString("penulis"));
                p.setPenerbit(rs.getString("penerbit"));
                p.setLokasi(rs.getString("lokasi"));
                p.setStock(rs.getInt("stock"));
                dp.add(p);
                
            }
        }catch(SQLException ex){
            Logger.getLogger(datapDAO.class.getName()).log(Level.SEVERE, null,ex);
        }
        
        return dp;
    }

    @Override
    public void tampil(datap p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
