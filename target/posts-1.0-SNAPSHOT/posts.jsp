<%-- 
    Document   : posts
    Created on : 14 may. de 2024, 14:36:32
    Author     : jhomara
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.emergentes.modelo.Post"%>

<%@page import="java.util.List"%>
<%
    List<Post> posts = (List<Post>) request.getAttribute("posts");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Posts</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1 class="text-center">Blog de Tecnología</h1>
        <p class="text-center">Autor: Jhomara Quecaña Zamora</p>

        <div class="container">
            <div class="row">
                <div class="col-12 text-end">
                    <a class="btn btn-primary" href="PostController?action=add">Nueva Entrada</a>
                </div>

                <div class="col-12 mt-2">
                    <c:forEach var="item" items="${posts}">
                        <div class="card mt-2">
                            <div class="card-body">
                                <h4>${item.titulo}</h4>
                                <p>Fecha: ${item.fecha}</p>
                                <p>${item.contenido}</p>
                                <div class="d-flex justify-content-end mt-0">
                                    <a class="btn btn-warning btn-sm" href="PostController?action=edit&id=${item.id}">Editar</a>
                                    &nbsp;
                                    <a class="btn btn-danger btn-sm" href="PostController?action=delete&id=${item.id}">Eliminar</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

    </body>
</html>
