<%@ page import="com.example.lab10.bean.Cliente" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaCliente" type="java.util.ArrayList<com.example.lab10.bean.Cliente>" scope="request" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
        <title>LAB 9</title>
    </head>
    <body>
        <jsp:include page="../includes/navbarAdmin.jsp">
            <jsp:param name="currentPage" value="par"/>
        </jsp:include>
        <div class='container'>

            <div class="row mb-4">
                <div class="col"></div>
                <div class="col-md-6">
<<<<<<< HEAD
                    <h1 class='mb-3'>Crear nuevo cliente</h1>
                    <form method="post" action="<%=request.getContextPath()%>/PartidoServlet?action=guardar">
=======
                    <h1 class='mb-3'>CREAR NUEVO CLIENTE</h1>
                    <form method="post" action="<%=request.getContextPath()%>/ServletAdmin?action=guardar">
>>>>>>> 964f996f79fcf798cc88e26a332c5ac7c337567c
                        <div class="form-group">
                            <label for="nro_document">N° de Documento</label>
                            <select name="nro_document" id ="nro_document" class="form-control">
                                <% for (Cliente cliente : listaCliente) {%>
                                <option value="<%=cliente.getNumDocumento()%>"><%=cliente.getNumDocumento()%>
                                </option>
                                <%}%>
                            </select>


                        </div>
                        <div class="form-group">
                            <label for="tipo_user">Tipo de Usuario</label>
                            <select name="tipo_user" id ="tipo_user" class="form-control">

                                <option value="1">1
                                </option>
                                <option value="2">2
                                </option>
                            </select>


                        </div>
                        <div class="form-group">
                            <label for="password">Contraseña</label>
                            <input class="form-control datetimepicker" id="password" name="password"/>
                        </div>



                        <button type="submit" class="btn btn-primary">Guardar</button>
                        <a href="<%=request.getContextPath()%>/ServletAdmin" class="btn btn-danger">Cancelar</a>
                    </form>
                </div>
                <div class="col"></div>
            </div>
            <div style="position: fixed; bottom: 40px; right: 40px;" aria-live="polite" aria-atomic="true">
                <div class="toast text-black" id=toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="5000">
                    <div class="toast-header">
                        <strong class="mr-auto text-primary">En caso de error</strong>
                        <small>now</small>
                        <button type="button" class="ml-2 mb-1 close close-white" data-dismiss="toast" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="toast-body">
                        Revise que el partido no esté registrado e intente nuevamente.
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"></script>
        <script>
            $(document).ready(function (){
                $('.toast').toast('show');
            })
        </script>
    </body>
</html>
