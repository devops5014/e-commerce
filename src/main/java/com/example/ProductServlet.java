package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServlet extends HttpServlet {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
        productList.add(new Product(1, "Laptop", "High performance laptop", 1000.0, "Electronics", "laptop.jpg"));
        productList.add(new Product(2, "Smartphone", "Latest model smartphone", 700.0, "Electronics", "smartphone.jpg"));
        productList.add(new Product(3, "Headphones", "Noise-cancelling headphones", 150.0, "Accessories", "headphones.jpg"));
        productList.add(new Product(4, "Running Shoes", "Comfortable running shoes", 120.0, "Footwear", "shoes.jpg"));
        productList.add(new Product(5, "Backpack", "Durable and spacious backpack", 80.0, "Accessories", "backpack.jpg"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        String searchQuery = request.getParameter("search");

        List<Product> filteredProducts = productList;
        if (category != null && !category.isEmpty()) {
            filteredProducts = filteredProducts.stream()
                    .filter(product -> product.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
        }
        if (searchQuery != null && !searchQuery.isEmpty()) {
            filteredProducts = filteredProducts.stream()
                    .filter(product -> product.getName().toLowerCase().contains(searchQuery.toLowerCase()))
                    .collect(Collectors.toList());
        }

        request.setAttribute("products", filteredProducts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
        dispatcher.forward(request, response);
    }
}
