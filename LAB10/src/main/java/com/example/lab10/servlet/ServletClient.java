package com.example.lab10.servlet;

import com.example.lab10.bean.Cliente;
import com.example.lab10.dao.DaoCliente;
import com.example.lab10.dao.DaoContrato;
import com.mysql.cj.protocol.x.Notice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletClient", value = "/Client")
public class ServletClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher view;
        DaoContrato daoContrato = new DaoContrato();
        DaoCliente daoCliente = new DaoCliente();
        action = (action == null)?"inicio": action;
        HttpSession session = request.getSession();
        Cliente cliente;
        if(session.getAttribute("cliente")==null){
            response.sendRedirect(request.getContextPath());
        }
        else{
            switch (action){
                case "inicio":
                    view = request.getRequestDispatcher("client/datos.jsp");
                    view.forward(request,response);
                    break;
                case "contratos":
                    cliente = (Cliente) session.getAttribute("cliente");
                    request.setAttribute("contratos",daoContrato.listarContratos(cliente.getNumDocumento()));
                    view = request.getRequestDispatcher("client/contratos.jsp");
                    view.forward(request,response);
                    break;
                case "loss":
                    cliente = (Cliente) session.getAttribute("cliente");
                    request.setAttribute("expectedLoss",daoCliente.mostrarMaxExpectedLoss(cliente.getNumDocumento()));
                    view = request.getRequestDispatcher("client/expectedLoss.jsp");
                    view.forward(request,response);
                    break;

                case "cantContratos":
                    cliente = (Cliente) session.getAttribute("cliente");
                    request.setAttribute("contratos",daoContrato.lisarContradoEstado(cliente.getNumDocumento()));
                    view = request.getRequestDispatcher("client/cantContratos.jsp");
                    view.forward(request,response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
