



/*






-- .4
SELECT * FROM EMPLOYEE WHERE Title = 'Sales Representative' AND Country = 'USA';


-- .5
SELECT orderid, employeeId FROM salesorder WHERE employeeId = '1';


-- .6 suppliers and ContactTitles
SELECT companyName, contactTitle FROM supplier;


-- .7 products with "queso" in ProductName
SELECT productName FROM product WHERE productName LIKE '%queso%';


-- 8. Orders shipping to France or Belgium
SELECT * FROM salesorder WHERE shipCountry = 'France' OR shipCountry = 'Belgium';


-- 9. Orders shipping to any country in Latin America
SELECT * from salesorder WHERE shipCountry IN ('Venezuela', 'Brazil', 'Mexico');


-- 10. Employees, in order of age
SELECT * FROM Employee ORDER BY birthDate;


-- 11. Showing only the Date with a DateTime field


-- 12. Employees full name
SELECT CONCAT(titleOfCourtesy," ", firstname," ", lastname) AS "Full Name" FROM employee;


-- 13. OrderDetails amount per line item
SELECT orderID, COUNT(quantity) AS "Amount Per Line Item" FROM orderdetail GROUP BY orderID;


-- 14. How many customers?
SELECT COUNT(custId) AS "Number of Customers" FROM customer;


-- 15. When was the first order?
SELECT orderDate FROM salesorder ORDER BY orderDate limit 1;


-- 16. Countries where there are customers
SELECT country, COUNT(country) AS "Number of customers in country" FROM customer GROUP BY country;


-- 17. Contact titles for customers
SELECT contactTitle, COUNT(contactTitle) AS "Number of employees with specific Contact Title" FROM customer GROUP BY contactTitle;


-- 18. Products with associated supplier names
SELECT product.productName, supplier.companyName
FROM product
INNER JOIN supplier USING(supplierId);


-- 19. Orders and the Shipper that was used
SELECT salesorder.orderId, shipper.companyName 
FROM salesorder
INNER JOIN shipper USING(shipperid);


-- 20. Categories and the total products in each category
SELECT category.categoryName, COUNT(product.productId) AS "Number of Products"
 FROM category
 INNER JOIN product USING(categoryId)
 GROUP BY category.categoryName;
 
 
 -- 21. Total customers per country/city
SELECT country, COUNT(custId) AS "Customers per Country" FROM customer GROUP BY country;


-- 24. Customer list by region
SELECT customer.contactName, customer.region FROM customer ORDER BY customer.region;

*/