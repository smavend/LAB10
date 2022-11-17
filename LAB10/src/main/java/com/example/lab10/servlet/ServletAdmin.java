package com.example.lab10.servlet;

import com.example.lab10.bean.Credencial;
import com.example.lab10.dao.DaoCliente;
import com.example.lab10.dao.DaoCredencial;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAdmin", urlPatterns = {"/ServletAdmin"})
public class ServletAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
        String action = request.getParameter("action") == null ?
                "loginform" : request.getParameter("action");

        RequestDispatcher view;

        switch (action) {
            case "loginform":
                view = request.getRequestDispatcher("login.jsp");
                view.forward(request, response);
                break;

        }*/
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action") == null ? "inicio" : request.getParameter("action");

        RequestDispatcher requestDispatcher;
        DaoCredencial daoCredencial = new DaoCredencial();
        DaoCliente daoCliente = new DaoCliente();
        switch (action) {


            case "inicio":
                request.setAttribute("listaCliente",daoCliente.listarClientes());
                requestDispatcher = request.getRequestDispatcher("admin/form.jsp");
                requestDispatcher.forward(request, response);



                break;

            case "guardar":

                String nro_documento = request.getParameter("nro_document");
                String tipousuario = request.getParameter("tipo_user");
                int tipoUser = Integer.parseInt(tipousuario);
                String pass = request.getParameter("password");

                Credencial credencial = new Credencial();
                credencial.setNumDocumento(nro_documento);
                credencial.setTipoUsuario(tipoUser);
                credencial.setPassword(pass);

                daoCredencial.guardar(credencial);
                response.sendRedirect(request.getContextPath() + "/ServletAdmin");
                break;



        }




    }
}
