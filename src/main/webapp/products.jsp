<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>Products</h1>
<div class="product-list">
    <c:forEach var="product" items="${products}">
        <div class="product">
            <h2>${product.name}</h2>
            <p>${product.description}</p>
            <p>Price: $${product.price}</p>
            <form action="cart" method="post">
                <input type="hidden" name="productId" value="${product.id}">
                <input type="hidden" name="productName" value="${product.name}">
                <input type="hidden" name="productDescription" value="${product.description}">
                <input type="hidden" name="productPrice" value="${product.price}">
                <button type="submit">Add to Cart</button>
            </form>
        </div>
    </c:forEach>
</div>
<a href="cart?action=viewCart">View Cart</a>
</body>
</html>
