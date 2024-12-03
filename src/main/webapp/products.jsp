<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/styles.css' />">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mt-4">Products</h1>
    <form class="form-inline mb-4" method="get" action="products">
        <input type="text" name="search" class="form-control mr-sm-2" placeholder="Search products...">
        <button type="submit" class="btn btn-outline-success">Search</button>
    </form>
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-md-4 d-flex align-items-stretch">
                <div class="card mb-4">
                    <img src="<c:url value='/images/${product.image}' />" class="card-img-top" alt="${product.name}">
                    <div class="card-body d-flex flex-column">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">${product.description}</p>
                        <p class="card-text">Price: $${product.price}</p>
                        <form action="cart" method="post" class="mt-auto">
                            <input type="hidden" name="productId" value="${product.id}">
                            <input type="hidden" name="productName" value="${product.name}">
                            <input type="hidden" name="productDescription" value="${product.description}">
                            <input type="hidden" name="productPrice" value="${product.price}">
                            <input type="hidden" name="productCategory" value="${product.category}">
                            <input type="hidden" name="productImage" value="${product.image}">
                            <button type="submit" class="btn btn-primary">Add to Cart</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <a href="cart?action=viewCart" class="btn btn-success">View Cart</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>