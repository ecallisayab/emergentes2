package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImplementacion extends ConexionBD implements UsuarioDAO  {

    @Override
    public void insert(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuarios (nombre, correo, clave) VALUES (?, ?, ?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getClave());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        String sql = "UPDATE usuarios SET nombre=?, correo=?, clave=? WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getClave());
        ps.setInt(4, usuario.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM usuarios WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        String sql = "SELECT * FROM usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Usuario>();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setClave(rs.getString("clave"));
            lista.add(usuario);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuarios WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            usuario.setId(rs.getInt("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setCorreo(rs.getString("correo"));
            usuario.setClave(rs.getString("clave"));
        }
        this.desconectar();
        return usuario;
    }
    
}
