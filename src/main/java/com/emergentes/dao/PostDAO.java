/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Post;
import java.util.List;

/**
 *
 * @author jhomara
 */
public interface PostDAO {

    public void insert(Post post) throws Exception;

    public void update(Post post) throws Exception;

    public void delete(int id) throws Exception;

    public List<Post> getAll() throws Exception;

    public Post getById(int id) throws Exception;

}
