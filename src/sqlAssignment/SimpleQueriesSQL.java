
/* Q1
1. Write a query to display the name, product line, and buy price
of all products. The output columns should display as “Name,”
“Product Line,” and “Buy Price.” The output should display the
most expensive items first.

result 1:
	
	SELECT 
		productName, ProductLine, BuyPrice
	FROM 
		Products
	ORDER BY 
		BuyPrice DESC;


 */



/* Q2
2. Write a query to display the first name, last name, and city
name of all customers from Germany. Columns should display
as “First Name,” “Last Name,” and “City.” The output should
be sorted by “Last Name” (ascending).

result 2:
	
	SELECT 
		contactFirstName AS "First Name", contactLastName AS "Last Name", city AS "City"
	FROM 
		customers
	WHERE 
		country = 'Germany'
	ORDER BY 
		contactLastName ASC;

 */


/* Q3
3. Write a query to display each of the unique values of the
status field in the orders table. The output should be sorted
alphabetically, increasing. Hint: The output should show
exactly six rows.

result 3:

	SELECT 
		DISTINCT status 
	FROM 
		orders 
	ORDER BY 
		status ASC; 
 */




/* Q4
4. Select all fields from the payments table for payments made
on or after January 1, 2005. The output should be sorted by the
payment date from highest to lowest.

result 4:
	
	SELECT * 
	FROM 
		payments
	WHERE 
		paymentDate >= '2005-01-01'
	ORDER BY 
		paymentDate DESC


 */




/* Q5
5. Write a query to display the Last Name, First Name, Email
Address, and Job Title of all employees working out of the San
Francisco office. Output should be sorted by “Last Name.”

result 5:

	select 
		lastName 'Last Name',firstName 'First Name',email, jobTitle
	from 
		employees
	where 
		officeCode = '1'
	order by 
		lastName;




 */


/* Q6
6. Write a query to display the Name, Product Line, Scale, and
Vendor of all of the Car products – both classic and vintage.
The output should display all vintage cars first (sorted
alphabetically by name), and all classic cars last (also sorted
alphabetically by name).


	SELECT 
		productName, ProductLine, productScale, productVendor
	FROM 
		products
	WHERE 
		ProductLine = 'classic Cars' OR ProductLine ='Vintage Cars'
	ORDER BY 
  		productLine desc, productName asc;

*/








