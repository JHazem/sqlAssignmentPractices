/* Day 3     Classicmodels Database


	 1. Write a query which lists each cIty and the number of employees in each
		city.The output should be sorted first by the city name then by the count
		of employees.
		
		use classicmodels;

		SELECT offices.city 'City', COUNT(employees.employeeNumber) AS "Number of Employees"
		FROM employees
		INNER JOIN offices ON employees.officeCode = offices.officeCode
		GROUP BY offices.city
		ORDER BY offices.city, COUNT(employees.employeeNumber);





	2- Write a query which lists the customer's name and  the city from the office where their salesperson works. 
		For only 10 customers, order by the customer’s name in alphabetical order. 
	
		use classicmodels;
		
		SELECT customers.customerName, customers.city
		FROM customers
		INNER JOIN employees ON customers.salesRepEmployeeNumber = employees.employeeNumber
		INNER JOIN offices USING(officeCode)
		ORDER BY customers.customerName
		LIMIT 10;


	3- Write a query which lists the employee's last name  and the number of customers they have.
	The output should be sorted first by the count of customers  in descending order 
	followed by the  employee's last name.
	
		use classicmodels;
			
		SELECT COUNT(customers.customerNumber)  AS "Number of Customers", employees.lastName
		FROM customers
		INNER JOIN employees ON customers.salesRepEmployeeNumber = employees.employeeNumber
		GROUP BY customers.salesRepEmployeeNumber
		order by COUNT(customers.customerNumber) DESC;
		
	
	
	
	
									Banking Database
	
	4- Write a query which lists all departments and the total number of employees per department.
	 Ordered by the total number of employees in descending order. 
	
		use banking;
		
		SELECT department.NAME, COUNT(employee.EMP_ID) AS "Number of Customers"
		FROM employee
		INNER JOIN department USING(DEPT_ID)
		GROUP BY department.NAME
		ORDER BY COUNT(employee.EMP_ID) DESC;
		
	
	
	5- Write a query which lists customer ID , first name and last name. (Hint you can use Union  )

		use banking;
		
		SELECT CUST_ID,FIRST_NAME,LAST_NAME FROM INDIVIDUAL
		WHERE CUST_ID IS NOT NULL;


*/