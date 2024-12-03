package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServlet extends HttpServlet {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        productList.add(new Product(1, "Laptop", "High performance laptop", 1000.0));
        productList.add(new Product(2, "Smartphone", "Latest model smartphone", 700.0));
        productList.add(new Product(3, "Headphones", "Noise-cancelling headphones", 150.0));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
        dispatcher.forward(request, response);
    }
}
