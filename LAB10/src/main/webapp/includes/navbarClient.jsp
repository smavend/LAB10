<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String currentPage = request.getParameter("currentPage"); %>
<nav class="navbar navbar-expand-md navbar-light bg-light">
    <div class="container col-10">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/PartidoServlet">Banco del Perú</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item" >
                    <a class="nav-link <%=currentPage.equals("datos") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/PartidoServlet">Mis Datos</a>
                </li>
                <li class="nav-item" >
                    <a class="nav-link <%=currentPage.equals("cont") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/ArbitroServlet">Mis contratos</a>
                </li>
                <li class="nav-item" >
                    <a class="nav-link <%=currentPage.equals("contEst") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/ArbitroServlet">Contratos por Estado</a>
                </li>
                <li class="nav-item" >
                    <a class="nav-link <%=currentPage.equals("loss") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/ArbitroServlet">Expected Loss máximo</a>
                </li>
            </ul>
        </div>
    </div>
</nav>