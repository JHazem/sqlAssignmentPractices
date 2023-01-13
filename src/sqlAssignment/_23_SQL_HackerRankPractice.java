package sqlAssignment;
/*

------------------1---------------------

1. There is a database with the exam scores of every student. Write a query to print the maximum and minimum marks of the students. The result should be in the following format: MAX_MARKS MIN_ MARKS



select max(marks) as MAX_MARKS, min(marks)as MIN_MARKS
from marks;

 
------------------2---------------------


2. The locations of the superheroes have been stored in the SUPERHERO table. Write a query to print the IDs, i.e., SUPERHERO.ID of the superheroes whose latitudes and longitudes both have a value smaller than 50. The order of output does not matter.



select ID
from SUPERHERO 
where LATITUDE < 50 and LONGITUDE  < 50

 

-----------------3----------------------

3. A company maintains the data of its customers in the CUSTOMER table. Write a query to print the IDs and the NAMEs of the customers who are from the USA and whose credit limit is greater than 100000, ordered by increasing /D number.



select ID, NAME 
from CUSTOMER
where country = 'USA' and credits> 100000
order by ID asc;





--------------------4-------------------



4. The information of the superheroes have been stored in the SUPERHERO table.
Write a query to print the names, i.e., SUPERHERO.NAME of the superheroes whose NAME has fewer than 7 characters. Sort the output in increasing order of their IDs.


select NAME
from SUPERHERO
where length(NAME)< 7
order by ID asc;





--------------------5-------------------



5. A company maintains the information about its orders in the ORDERS table. Write a query to print the number of orders which are not yet delivered, i.e., the ORDERS.STATUS is not equal to DELIVERED.


select count(*)
from ORDERS 
where status  not in ('delivered');




-------------------6--------------------



6. A retail company maintains the data of its customers in the CUSTOMERtable. Write a query to print the IDs and the NAMEs of the customers, sorted by CUSTOMER.NAME in descending order. If two or more customers have the same CUSTOMER.NAME, then sort these by CUSTOMER.ID in ascending order.

select ID, NAME

from CUSTOMER 

order by NAME desc, ID asc;

  


------------------7---------------------



7. There is a database with exam scores. Write a query to print the names of the students who scored an even number of marks. The names should be listed in uppercase, alphabetically


SELECT upper(NAME) , MARKS
FROM exam
where MARKS %2 =0
order by NAME asc;




-------------------8--------------------



8. A coding platform maintains all the participating hackers' data in the HACKER table.
Write a query to print the names of all the hackers who have earned more than 100 hackos in less than 10 months. Print the output in the ascending order of their ID.

SELECT NAME
FROM HACKER
where hackos * months > 100 and months < 10
order by ID asc;




-------------------9--------------------


9. The math scores of each student have been stored in the STUDENTtable. Write a query to print the /D and the NAME of each of the three highest scoring students. Print the NAMEs in descending order by SCORE, then ascending order by ID for matching SCOREs.



SELECT ID , NAME
from student
order by score desc, id asc
limit 3; 



-------------------10--------------------


10. A company maintains information about its orders in the ORDERStable. Write a query to print details of the earliest five orders (sorted by ORDER_DATE, ascending) that have not been delivered (i.e., STATUS is not DELIVERED). If there are more than five orders to choose from, select the ones with the lowest order ID. Sort the output in the increasing order of order ID. The output should contain ID, ORDER_DATE, STATUS, CUSTOMER_ID.





SELECT ID, ORDER_DATE, STATUS, CUSTOMER_ID
from ORDERS
where STATUS != 'delivered' 
order by ORDER_DATE asc, ID asc
limit 5;



-------------------11--------------------



11. A ride hailing company has their DB structured in 3 major tables as described in SCHEMA below.
Write a query to fetch the city names along with earnings from each city. 'Earnings' are calculated as the sum of fares of all the rides taken in that city. The output should be structured as: cities.name earnings
The output is sorted ascending by earnings, then ascending by the city name.



SELECT c.NAME , sum(r.fare) as earnings
FROM cities c 
join users u on c.id= u.city_id
join rides r on u.id = r.user_id
group by c.NAME
order by earnings asc, c.NAME asc;


-----------------12----------------------

12. A university stores students' standardized test scores in a table named STUDENT.
Student X placed 213th on the test.
Write a query to find Student X's test score (i.e., the 213th highest STUDENT.SCORE in STUDENT).



select  student.score
from student
order by  score desc limit 212,1;




-------------------13--------------------

13- CWrite a query to print the ID and StudentGrade for each record in the STUDENT table. Sort the output by student ID, ascending, and use the following format.



select 
case
	when STUDENT.SCORE < 20 then concat("Student ", STUDENT.ID, " has grade: F")
	when STUDENT.SCORE < 40 then concat("Student ", STUDENT.ID, " has grade: D")
	when STUDENT.SCORE < 60 then concat("Student ", STUDENT.ID, " has grade: C")
	when STUDENT.SCORE < 80 then concat("Student ", STUDENT.ID, " has grade: B")
	when STUDENT.SCORE >= 80 then concat("Student ", STUDENT.ID, " has grade: A")
end
from STUDENT 
order by STUDENT.ID ASC;






-------------------14--------------------

14. Student's Major
A university maintains data on students and their majors in three tables: STUDENTS, MAJORS, and REGISTER. The university needs a list of the STUDENT_NAME and MAJOR_NAME of the first 20 students. Do not sort the list.


select STUDENTS.STUDENT_NAME, MAJORS.MAJOR_NAME
FROM STUDENTS
INNER JOIN REGISTER ON STUDENTS.STUDENT_ID = REGISTER.STUDENT_ID

INNER JOIN MAJORS ON REGISTER.MAJOR_ID = MAJORS.MAJOR_ID
limit 20;




---------------------15------------------


15 A travel and tour company has 2 tables that relate to customers: FAMILIES and COUNTRIES. Each tour offers a discount if a minimum number of people book at the same time.
Write a query to print the maximum number of discounted tours any 1 family in the FAMILIES table can choose from.



SELECT COUNT(COUNTRIES.MIN_SIZE)
FROM FAMILIES
CROSS JOIN COUNTRIES
WHERE FAMILIES.FAMILY_SIZE > COUNTRIES.MIN_SIZE
GROUP BY FAMILIES.NAME
ORDER BY COUNT(COUNTRIES.MIN_SIZE) DESC LIMIT 1;





--------------------16-------------------



16. Write a query to return a list of professor names and their associated courses. The results can be in any order but must not contain duplicate rows.


SELECT DISTINCT PROFESSOR.NAME, COURSE.NAME 
FROM PROFESSOR
INNER JOIN SCHEDULE ON PROFESSOR.ID = SCHEDULE.PROFESSOR_ID
INNER JOIN COURSE ON SCHEDULE.COURSE_ID = COURSE.ID
ORDER BY COURSE.NAME;



--------------------17-------------------


17. Write a query to return a list of professor names and their associated courses for all courses outside of their departments. There should be no duplicate rows, but they can be in any order.
The output should contain two columns: professor.name, course.name.


SELECT DISTINCT PROFESSOR.NAME, COURSE.NAME 
FROM PROFESSOR
INNER JOIN SCHEDULE ON PROFESSOR.ID = SCHEDULE.PROFESSOR_ID
INNER JOIN COURSE ON SCHEDULE.COURSE_ID = COURSE.ID
where PROFESSOR.DEPARTMENT_ID != COURSE.DEPARTMENT_ID
ORDER BY COURSE.NAME;



-------------------18--------------------



18 There is a database containing the marks of some students in various subjects. The data may contain any number of subjects for a student.
Retrieve the records of students who have a sum of marks greater than or equal to 500.
The result should be in the following format: STUDENT_ID SUM_OF MARKS sorted descending by STUDENT_ID.



select STUDENT_ID, sum(MARKS)
from marks 
group by STUDENT_ID 
having sum(MARKS)  >= 500
order by STUDENT_ID desc;

--------------------19-------------------


19 Return a list of all students with at least one occurrence of a backlog item.
The result should be in the following format: student.name



SELECT student.name
FROM student
JOIN backlog ON student.id = backlog.student_id
GROUP BY student.name





--------------------20-------------------

20. Clumsy Administrator
A company maintains the records of all employees. 
The company pays the database administrator too little so the work has been quite clumsy. 
The administrator carelessly inserted the records of many employees into the employee records table multiple times.
An employee's record is considered duplicate only if all columns (fields) of the employee's 
record are duplicated.
Write a query to find the names of employees whose records occur more than once in the table.


select distinct Name
from employee
group by name, phone, age 
having count(Name)>1
and (phone)>1
and (age)>1
;

--------------------21-------------------
21.
There are two tables in a database of real estate owners. 
One has ownership information and the other has price information, in millions. 
An owner may own multiple houses, but a house will have only one owner.
Write a query to print the IDs of the owners who have at least 100 million 
worth of houses and own more than 1 house. The order of output does not matter.
 The result should be in the format: BUYER_/D TOTAL_WORTH



SELECT  house.BUYER_ID, sum(price.PRICE) as TOTAL_WORTH
from house  
inner join price on house.HOUSE_ID = price.HOUSE_ID
group by house.BUYER_ID
having sum(price.PRICE) > 100 and count(house.BUYER_ID) > 1
order by house.BUYER_ID asc;







--------------------22-------------------

22. The Beautiful Collection
A shopkeeper maintains the count of the different colored balls (Red, green, and blue) in the COLLECTION table.
 Each row of the table represents one of the following types:
GOOD: If the count of the red, green, and blue balls are equal.
• BAD: If the count of any two colored balls are equal, i.e., only one of the following conditions is true:
• Red balls count is equal to green balls.
• Red balls count is equal to blue balls.
• Green balls count is equal to blue balls.
• WORSE: If all the colored balls have different counts.
Write a query to print the type which is represented by each row of the table. 
Note that the output is case-sensitive, so make sure to output only GOOD, BAD, or WORSE.



SELECT
    CASE
        WHEN Red  = Green  AND Green = Blue  THEN 'GOOD'
        WHEN (Red = Green  AND Green != Blue) OR
             (Red = Blue   AND Blue != Green)  OR
             (Green = Blue AND Blue != Red) THEN 'BAD'
        WHEN Red != Green  AND Green != Blue AND Blue != Red THEN 'WORSE'
    END AS Type
FROM Collection;


 

--------------------23-------------------
23. City Revenue
A number of cities each have a number of agencies that estimate revenues. The average revenue of a city is defined as the average of all agencies' estimates of revenue for a city.
Write a query to print the floor of the average revenue of each city. The order of output does not matter. The result should be in the following format: CITY_ NAME AVERAGE_REVENUE



select CITIES.CITY_NAME, FLOOR(AVG(REVENUE.REVENUE)) 
FROM CITIES 
INNER JOIN REVENUE  using(CITY_CODE)
GROUP BY CITIES.CITY_NAME;


------- 2

select 
    d.name, 
    count(c.id)
from 
    department d
inner join 
    course c on (d.id = c.deptId)
group by 
    d.name
order by 
    count(c.id) asc, d.name asc;


----- 3

select 
    c.name, 
    count(s.studentId)
from 
    course c
inner join 
    studentCourse s on (c.id = s.courseId)
group by 
    c.name
order by 
    count(s.studentId) desc, c.name asc;

------ 4
select 
    name
from 
    course
where 
    id not in (
    select 
        courseId 
    from 
        facultyCourse)
order by 
    name;
    
    ------5
    
    select 
    c.name, 
    count(sc.studentId)
from 
    course c
inner join 
    studentCourse sc on (c.id = sc.courseId)
where 
    c.id not in (
    select 
        courseId 
    from 
        facultyCourse)
group by 
    c.name
order by 
    count(sc.studentId) desc, c.name asc;
    
    
    
    ---- 6
    
    select 
    count(distinct sc.studentId), 
    year(sc.startDate)
from 
    studentCourse sc
group by 
    year(sc.startDate)
order by 
    year(sc.startDate) asc, 
    count(sc.studentId) desc;



------7


select  
    sc.startDate, 
    count(distinct sc.studentId) 
from 
    studentcourse sc
where 
month
    (sc.startDate) = 8
group by 
    sc.startDate
order by 
    sc.startDate, 
    count(sc.studentId) ;





----- 8

	    select 
	    s.firstname,
	    s.lastname,
	    count(sc.courseId)
	from 
	    student s,
	    studentCourse sc,
	    course c
	where 
	    s.id = sc.studentId 
	and 
	    sc.courseId = c.id 
	and 
	    s.majorId = c.deptId
	group by 
	    s.lastname,
	    s.firstname
	order by 
	    count(sc.courseId) desc,
	    s.firstname,
	    s.lastname;


------9

	
select 
    s.firstname,
    s.lastname, 
    round(avg(sc.progress),1) as avg
from 
    student s
inner join 
    studentCourse sc 
on 
    s.id = sc.studentId  
group by 
    s.lastname, s.firstname
having 
    avg(sc.progress) < 50
order by 
    avg desc, 
    s.firstname, 
    s.lastname; 


------ 10
	
select 
    c.name,
    round(avg(sc.progress),1) as avg 
from 
    studentCourse sc,
    course c 
where 
    sc.courseId = c.id 
group by  
    c.name 
order by 
    avg desc,
    c.name asc; 
    

    ----- 11
    
    
    SELECT
	    c.name,
	    round(avg(sc.progress),1)
	from 
	   studentCourse sc 
	join  
	    course c
	ON
	    sc.courseId = c.id
	group by 
	    c.id,
	    c.name
	order by 
	    avg(sc.progress) DESC
	limit 1;
	


----- 12
    


SELECT
    f.firstname,
    f.lastname, 
    round(avg(sc.progress),1)
    
from 
    studentCourse sc, 
    facultyCourse fc, 
    faculty f  
WHERE 
    sc.courseId = fc.courseId
AND 
    fc.facultyId = f.id
group by 
    f.lastname,
    f.firstname
order by 
    round(avg(sc.progress),1) desc,
    f.firstname asc,
    f.lastname asc;
     

---- 13

select 
    firstname,
    lastname,
    case
        when min(c.progress) < 40 then "F"
        when min(c.progress) < 50 then "D"
        when min(c.progress) < 60 then "C"
        when min(c.progress) < 70 then "B"
        else "A"
    end 
        as min_grade,
    case
        when max(c.progress) < 40 then "F"
        when max(c.progress) < 50 then "D"
        when max(c.progress) < 60 then "C"
        when max(c.progress) < 70 then "B"
        else "A"
    end 
        as max_grade
from 
    student s
JOIN    
    studentCourse c
on
    s.id = c.studentId
group by 
    s.id,
    s.firstname,
    s.lastname
order by
    min_grade desc,
    max_grade desc,
    s.firstname,
    s.lastname;
      
       



*/


