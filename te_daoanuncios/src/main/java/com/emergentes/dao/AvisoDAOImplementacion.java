package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvisoDAOImplementacion extends ConexionBD implements AvisoDAO {

    @Override
    public void insert(Aviso aviso) throws Exception {
        String sql = "INSERT INTO avisos (titulo, contenido) VALUES (?, ?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, aviso.getTitulo());
        ps.setString(2, aviso.getContenido());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Aviso aviso) throws Exception {
        String sql = "UPDATE avisos SET titulo=?, contenido=? WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, aviso.getTitulo());
        ps.setString(2, aviso.getContenido());
        ps.setInt(3, aviso.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM avisos WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Aviso> getAll() throws Exception {
        /*String sql = "SELECT * FROM avisos";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Aviso> lista = null;
        lista = new ArrayList<Aviso>();
        while (rs.next()) {
            Aviso aviso = new Aviso();
            aviso.setId(rs.getInt("id"));
            aviso.setTitulo(rs.getString("titulo"));
            aviso.setContenido(rs.getString("contenido"));
            lista.add(aviso);
        }
        this.desconectar();
        return lista;*/
         List<Aviso> lista = null;
        String sql = "select * from avisos";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<Aviso>();
        while(rs.next()){
            Aviso avi = new Aviso();
            
            avi.setId(rs.getInt("id"));
            avi.setTitulo(rs.getString("titulo"));
            avi.setContenido(rs.getString("contenido"));
            
            lista.add(avi);
        }
        this.desconectar();
        return lista;

    }

    @Override
    public Aviso getById(int id) throws Exception {
        Aviso aviso = new Aviso();
        String sql = "SELECT * FROM avisos WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            aviso.setId(rs.getInt("id"));
            aviso.setTitulo(rs.getString("titulo"));
            aviso.setContenido(rs.getString("contenido"));
        }
        this.desconectar();
        return aviso;
    }
    
}
