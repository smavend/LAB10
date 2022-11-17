package com.example.lab10.servlet;

import com.example.lab10.bean.Credencial;
import com.example.lab10.dao.DaoCliente;
import com.example.lab10.dao.DaoCredencial;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = "/Login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ?
                "loginform" : request.getParameter("action");

        RequestDispatcher view;

        switch (action) {
            case "loginform":
                view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
                break;

        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
    ServletException, IOException {
        RequestDispatcher requestDispatcher;
        DaoCredencial daoCredencial = new DaoCredencial();
        DaoCliente daoCliente = new DaoCliente();

        HttpSession session;

        String nro_documento = request.getParameter("nro_documento");
        String password = request.getParameter("password");

        Credencial credencial = daoCredencial.buscarUsuario(nro_documento, password);

        if(credencial != null){
            session = request.getSession();
            session.setAttribute("clienteSession", credencial);

            switch (credencial.getTipoUsuario()){
                case 1:
                    request.setAttribute("listaCliente",daoCliente.listarClientes());
                    requestDispatcher = request.getRequestDispatcher("admin/form.jsp");
                    requestDispatcher.forward(request, response);
                    break;

                case 2:
                    request.setAttribute("listaCliente",daoCliente.listarClientes());
                    requestDispatcher = request.getRequestDispatcher("login/list.jsp");
                    requestDispatcher.forward(request, response);
                    break;
            }
        }else{
            session = request.getSession();
            session.setAttribute("error", "error");
            response.sendRedirect(request.getContextPath()+"/Login");
        }
    }
}
