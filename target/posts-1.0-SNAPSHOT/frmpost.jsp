<%-- 
    Document   : frmpost
    Created on : 14 may. de 2024, 14:47:06
    Author     : jhomara
--%>
<%@page import="com.emergentes.modelo.Post"%>
<%
    Post post = (Post) request.getAttribute("post");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Egregar / Editar registro</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1 class="text-center">Nuevo/Editar Entrada</h1>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="PostController" method="POST">
                        <input type="hidden" name="id" value="${post.id}" />


                        <label for="fecha" class="form-label">Fecha: </label>
                        <input class="form-control" type="date" name="fecha" value="${post.fecha}" required>
                        
                        <label for="titulo" class="form-label mt-3">Título: </label>
                        <input class="form-control" type="text" name="titulo" value="${post.titulo}"  required>
                        
                        
                         <label for="contenido" class="form-label mt-3">Contenido: </label>
                         <textarea id="contenido" class="form-control" name="contenido" rows="5" cols="10" required>${post.contenido}</textarea>
                      
                         <input type="submit" class="btn btn-primary mt-2" value="Guardar" />
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
