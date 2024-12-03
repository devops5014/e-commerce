<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>Your Cart</h1>
<div class="cart-list">
    <c:forEach var="product" items="${cart}">
        <div class="cart-item">
            <h2>${product.name}</h2>
            <p>${product.description}</p>
            <p>Price: $${product.price}</p>
        </div>
    </c:forEach>
</div>
<a href="products">Continue Shopping</a>
</body>
</html>
