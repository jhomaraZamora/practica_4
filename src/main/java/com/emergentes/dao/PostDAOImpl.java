/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Post;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhomara
 */
public class PostDAOImpl extends ConexionDB implements PostDAO {

    public PostDAOImpl() throws ClassNotFoundException {
    }

    @Override
    public void insert(Post post) throws Exception {
        String sql = "INSERT INTO posts(fecha, titulo, contenido) VALUES (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);

        ps.setString(1, post.getFecha());
        ps.setString(2, post.getTitulo());
        ps.setString(3, post.getContenido());

        ps.executeUpdate();
    }

    @Override
    public void update(Post post) throws Exception {
        String sql = "UPDATE posts SET fecha=?, titulo= ?, contenido=? WHERE id =?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, post.getFecha());
        ps.setString(2, post.getTitulo());
        ps.setString(3, post.getContenido());
        ps.setInt(4, post.getId());

        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM posts WHERE id =?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();
    }

    @Override
    public List<Post> getAll() throws Exception {
        List<Post> lista = null;
        String sql = "SELECT * FROM posts";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Post>();

        while (rs.next()) {
            Post p = new Post();

            p.setId(rs.getInt("id"));
            p.setFecha(rs.getString("fecha"));
            p.setTitulo(rs.getString("titulo"));
            p.setContenido(rs.getString("contenido"));

            lista.add(p);
        }
        // this.desconectar();
        return lista;
    }

    @Override
    public Post getById(int id) throws Exception {
        String sql = "SELECT * FROM posts WHERE id=?";
        Post p = new Post();

        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setFecha(rs.getString("fecha"));
                p.setTitulo(rs.getString("titulo"));
                p.setContenido(rs.getString("contenido"));
            }
        } catch (SQLException e) {
            System.out.println("Error al encontrar el registro " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return p;
    }

}
