package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CartServlet extends HttpServlet {
    private List<Product> cart = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("viewCart".equals(action)) {
            request.setAttribute("cart", cart);
            RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("products");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String productCategory = request.getParameter("productCategory");
        String productImage = request.getParameter("productImage");

        Product product = new Product(productId, productName, productDescription, productPrice, productCategory, productImage);
        cart.add(product);

        response.sendRedirect("products");
    }
}
