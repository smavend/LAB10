package com.example.lab10.servlet;

import com.example.lab10.bean.Credencial;
import com.example.lab10.dao.DaoCliente;
import com.example.lab10.dao.DaoContrato;
import com.example.lab10.dao.DaoCredencial;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = {"/Login",""})
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ?
                "login" : request.getParameter("action");

        RequestDispatcher view;

        switch (action) {
            case "login":
                view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
                break;
            case "logout":
                HttpSession session = request.getSession();
                session.removeAttribute("doc");
                session.invalidate();
                response.sendRedirect(request.getContextPath());
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
    ServletException, IOException {
        RequestDispatcher requestDispatcher;
        DaoCredencial daoCredencial = new DaoCredencial();
        DaoCliente daoCliente = new DaoCliente();
        DaoContrato daoContrato = new DaoContrato();

        HttpSession session = request.getSession();

        String nro_documento = request.getParameter("nro_documento");
        String password = request.getParameter("password");

        Credencial credencial = daoCredencial.buscarUsuario(nro_documento, password);

        if(credencial != null){
            session.setAttribute("clienteSession", credencial);

            switch (credencial.getTipoUsuario()){
                case 1:
                    request.setAttribute("listaCliente",daoCliente.listarClientes());
                    session.setAttribute("doc", nro_documento);
                    response.sendRedirect(request.getContextPath()+"/Admin");
                    break;

                case 2:
                    session.setAttribute("cliente", daoCliente.buscarCliente(nro_documento));
                    request.setAttribute("listaContrato",daoContrato.listarContratos(credencial.getNumDocumento()));
                    response.sendRedirect(request.getContextPath()+"/Client");
                    break;
            }
        }else{
            session.setAttribute("error", "error");
            response.sendRedirect(request.getContextPath()+"/Login");
        }
    }
}
