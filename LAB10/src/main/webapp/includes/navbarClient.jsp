<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="cliente" class="com.example.lab10.bean.Cliente" scope="session" type="com.example.lab10.bean.Cliente"/>
<% String currentPage = request.getParameter("currentPage"); %>
<nav class="navbar navbar-expand-md navbar-light bg-light">
    <div class="container col-10">
        <a class="navbar-brand">Banco del Perú</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item" >
                    <a class="nav-link <%=currentPage.equals("datos") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/Client">Mis Datos</a>
                </li>
                <li class="nav-item" >
                    <a class="nav-link <%=currentPage.equals("cont") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/Client?action=contratos">Mis contratos</a>
                </li>
                <li class="nav-item" >
                    <a class="nav-link <%=currentPage.equals("contEst") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/Client?action=cantContratos">Contratos por Estado</a>
                </li>
                <li class="nav-item" >
                    <a class="nav-link <%=currentPage.equals("loss") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/Client?action=loss">Expected Loss máximo</a>
                </li>
                <li class="nav-item" >
                    <a class="nav-link"
                       href="<%=request.getContextPath()%>/Login?action=logout"><%=cliente.getNombreCliente()%> (Cerrar sesión)</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
