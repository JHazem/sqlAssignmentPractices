package sqlAssignment;

/* Q1
  1. Write a query which lists the total number of orders , and the total number of orders
   with a comment. Name the columns ‘total’ and ‘ comments’

 
	SELECT 
		COUNT(orderNumber) AS 'total', COUNT(comments) AS 'comments' 
	FROM 
		orders;

 */
 
/* Q2
  2. Write a query that lists the total number of orders without comments.
 
 
	SELECT
		count(orderNumber) as 'Total'
	from 
		orders
	where 
		comments 
	is null;
	

  
*/

/* Q3
  3. Write a query which lists the productLine and the number of products. The output
	should be sorted first by number of products in descending order.
  
 
	SELECT 
		productLine, COUNT(*) AS quantityInStock
	FROM 
		products
	GROUP BY 
		productLine
	ORDER BY 
		quantityInStock DESC;
  
*/



/* Q4
  4. Write a query which lists the city, the number of customers from that city and the
	average total credit limit rounded . The output should be sorted by credit limit in
	descending order .
  
 
	
	select 
		city,count(*) as customerNumber, round(avg(creditLimit)) as avgCriditLimit
	from 
		customers
	group by 
		city
	order by 
		avgCriditLimit desc;


  
*/



/* Q5
  	Write a query which lists the customers name and credit status depending on their
	credit limit. You should have two columns called ‘name’ and ‘status’. The output
	should be sorted by credit limit in descending order. Do not list customers with a zero
	credit limit.
	  
 
	select 
	customerName as 'Name',
	CASE
		when creditLimit > 200000 then 'Diamond'
		when creditLimit between 100000 and 199999 then 'Platinum'
		when creditLimit between 50000 and 99999 then 'Gold'
		when creditLimit between 5000 and 49000 then 'Silver'
	END
	as 'Credit Status', creditLimit 
	from 
		customers
	where 
		creditLimit > 0
	order by 
		creditLimit desc;
	  
*/


 
