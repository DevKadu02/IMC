/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author kadu
 */
@WebServlet(urlPatterns = {"/servlet", "/IMC", "/NewServlet"})
public class NewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        double peso = Double.parseDouble(request.getParameter("peso"));
        double altura = Double.parseDouble(request.getParameter("altura"));

        // Calcula o IMC
        double imc = peso / (altura * altura);

        // Verifica a situação da pessoa em relação ao seu peso
        String situacao;
        if (imc < 20) {
            situacao = "Abaixo do peso";
        } else if (imc <= 25) {
            situacao = "Peso normal";
        } else {
            situacao = "Obesidade ";
        }

        // Escreve a resposta para o usuário
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Resultado</h1>");
        response.getWriter().println("<p>Seu IMC é: " + imc + "</p>");
        response.getWriter().println("<p>Situação: " + situacao + "</p>");
        response.getWriter().println("</body></html>");
    }

}
