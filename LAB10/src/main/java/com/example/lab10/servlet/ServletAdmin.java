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
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        RequestDispatcher view;

        switch (action) {


            case "buscar":
                /*
                String busqueda = request.getParameter("buscar");
                String tipo = request.getParameter("tipo");

                if (tipo.equalsIgnoreCase("Nombre")){

                    request.setAttribute("listaArbitro", daoArbitros.busquedaNombre(busqueda));

                }else{

                    request.setAttribute("listaArbitro", daoArbitros.busquedaPais(busqueda));
                }
                request.setAttribute("listaopciones",opciones);
                view = request.getRequestDispatcher("arbitros/list.jsp");
                view.forward(request, response);
*/



                break;

            case "guardar":

                String nro_documento = request.getParameter("nro_document");
                String tipousuario = request.getParameter("tipo_user");
                String pass = request.getParameter("password");
/*
                Arbitro arbitro1 = new Arbitro();
                arbitro1.setNombre(nombreArb);
                arbitro1.setPais(paisArb);
                daoArbitros.guardar(arbitro1);
                response.sendRedirect(request.getContextPath() + "/ArbitroServlet");*/
                break;



        }




    }
}
