package sqlAssignment;
//package sqlAssignment;
//
//public class MockSqlSBA30450 {
//
//}


/*
							304.5.0 - Mock SQL SBA

1. Create a query to return all orders made by users with the first name of “Marion”
 
			SELECT *
			FROM orders o
			INNER JOIN users u ON o.user_id = u.id
			WHERE u.first_name = 'Marion';

			  ----------------------------------------------------------


2. Create a query to select all users that have not made an order
 
			SELECT u.*
			FROM users u
			LEFT JOIN orders o ON u.id = o.user_id
			WHERE o.user_id IS NULL
			
			  ----------------------------------------------------------


3. Create a Query to select the names and prices of all items that have been part of 2 or
	more separate orders.

			 
			SELECT i.name, i.price
			FROM items i
			JOIN order_items oi ON i.id = oi.item_id
			GROUP BY i.id, i.name, i.price
			HAVING COUNT(DISTINCT oi.order_id) >= 2
			 
			  ----------------------------------------------------------

4. Create a query to return the Order Id, Item name, Item Price, and Quantity from orders
	made at stores in the city “New York”. Order by Order Id in ascending order.
 
			 
			SELECT o.id AS order_id, i.name AS item_name, i.price AS item_price, oi.quantity
			FROM orders o
			JOIN order_items oi ON o.id = oi.order_id
			JOIN items i ON oi.item_id = i.id
			JOIN stores s ON o.store_id = s.id
			WHERE s.city = 'New York'
			ORDER BY o.id ASC
			
			  ----------------------------------------------------------

5. Your boss would like you to create a query that calculates the total revenue generated
	by each item. Revenue for an item can be found as (Item Price * Total Quantity
	Ordered). Please return the first column as ‘ITEM_NAME’ and the second column as ‘REVENUE’.
	 
			SELECT i.name AS item_name, SUM(i.price * oi.quantity) AS revenue
			FROM items i
			JOIN order_items oi ON i.id = oi.item_id
			GROUP BY i.id, i.name
			
			  ----------------------------------------------------------

6. Create a query with the following output:
	a. Column 1 - Store Name
	
		i. The name of each store
	b. Column 2 - Order Quantity
		i. The number of times an order has been made in this store
	c. Column 3 - Sales Figure
		i. If the store has been involved in more than 3 orders, mark as ‘High’
		ii. If the store has been involved in less than 3 orders but more than 1 order, mark as ‘Medium’
		iii. If the store has been involved with 1 or less orders, mark as ‘Low’
	d. Should be ordered by the Order Quantity in Descending Order
 
			 
		SELECT STORES.NAME, COUNT(ORDER_ITEMS.ORDER_ID) AS "ORDER_QUANTITY",
		CASE
		    WHEN COUNT(ORDERS.ORDER_ID) > 3 THEN "HIGH"
		    WHEN COUNT(ORDERS.ORDER_ID) BETWEEN 2 AND 3 THEN "MEDIUM"
		    WHEN COUNT(ORDERS.ORDER_ID) <= 1 THEN "LOW"
		END AS "SALES_FIGURE"
		FROM STORES, ORDERS, ORDER_ITEMS
		WHERE STORES.STORE_ID = ORDERS.ORDER_ID
		AND ORDERS.ORDER_ID = ORDER_ITEMS.ORDER_ID
		GROUP BY STORES.NAME
		ORDER BY COUNT(ORDER_ITEMS.ORDER_ID) DESC;

		
		 
		 
 
 
							
							











*/