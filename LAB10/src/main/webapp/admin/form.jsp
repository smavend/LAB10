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
                    <h1 class='mb-3'>Crear nuevo cliente</h1>
                    <form method="post" action="<%=request.getContextPath()%>/Admin?action=guardar">
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
                            <label for="password">Contraseña</label>
                            <input class="form-control datetimepicker" id="password" name="password" required>
                        </div>



                        <button type="submit" class="btn btn-primary">Guardar</button>
                    </form>
                </div>
                <div class="col"></div>
            </div>
            <%if(session.getAttribute("msg")!=null){%>
            <div style="position: fixed; top: 70px; right: 40px;" aria-live="polite" aria-atomic="true">
                <div  class="toast text-black" id=toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="5000">
                    <div class="toast-header">
                        <strong class="mr-auto text-primary">Mensaje</strong>
                        <small>ahora</small>
                        <button type="button" class="ml-2 mb-1 close close-white" data-dismiss="toast" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div style="background: #0d6efd" class="toast-body text-white">
                        <%=session.getAttribute("msg")%>
                    </div>
                </div>
            </div>
            <%session.removeAttribute("msg");
            }%>
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
