package com.example.lab10.servlet;

import com.example.lab10.bean.Credencial;
import com.example.lab10.dao.DaoCliente;
import com.example.lab10.dao.DaoCredencial;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAdmin", urlPatterns = {"/Admin"})
public class ServletAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "inicio" : request.getParameter("action");

        RequestDispatcher requestDispatcher;
        DaoCredencial daoCredencial = new DaoCredencial();
        DaoCliente daoCliente = new DaoCliente();
        switch (action) {
            case "inicio":
                request.setAttribute("listaCliente", daoCliente.listarClientes());
                requestDispatcher = request.getRequestDispatcher("admin/form.jsp");
                requestDispatcher.forward(request, response);


                break;
        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action") == null ? "guardar" : request.getParameter("action");

        HttpSession session;

        RequestDispatcher requestDispatcher;
        DaoCredencial daoCredencial = new DaoCredencial();
        DaoCliente daoCliente = new DaoCliente();
        switch (action) {

            case "guardar":
                String nro_documento = request.getParameter("nro_document");
                String pass = request.getParameter("password");
                if(!daoCredencial.createCredentialCliente(nro_documento, pass)){
                    session = request.getSession();
                    session.setAttribute("msg", "No se ha podido crear la credencial");
                }else{
                    session = request.getSession();
                    session.setAttribute("msg", "Se creó el cliente con éxito");
                }
                response.sendRedirect(request.getContextPath() + "/Admin");
                break;
        }




    }
}
