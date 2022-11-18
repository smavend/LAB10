<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.lab10.bean.Contrato" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="cliente" scope="session" type="com.example.lab10.bean.Cliente" class="com.example.lab10.bean.Cliente"/>
<jsp:useBean id="contratos" scope="request" type="java.util.ArrayList<com.example.lab10.bean.Contrato>"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
        <title>Cliente / Mis Datos</title>
    </head>
    <body>
        <jsp:include page="../includes/navbarClient.jsp">
            <jsp:param name="currentPage" value="cont"/>
        </jsp:include>
        <div class='container'>
            <div class="row mb-5 mt-4">
                <div class="col-lg-6">
                    <h1 class=''>Mis Contratos</h1>
                </div>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col"># Contrato</th>
                        <th scope="col">Divisa</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Meses en ese Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <%for(Contrato c: contratos){%>
                    <tr>
                        <th scope="row"><%=c.getNroContrato()%></th>
                        <td><%=c.getDivisa()%></td>
                        <td><%=c.getEstado()%></td>
                        <td><%=c.getMesesEnEstado()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
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
    </body>
</html>
