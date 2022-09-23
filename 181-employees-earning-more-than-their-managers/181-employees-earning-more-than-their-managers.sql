/*
# please upvote, if like my solutions :)
# 1.
SELECT e1.name as Employee from Employee e1, Employee e2
where e1.managerid = e2.id AND e1.salary > e2.salary;
*/

# 2.
SELECT e.name AS Employee 
FROM Employee e JOIN Employee m
ON e.managerid = m.id
where e.salary > m.salary;
/*
# 3.
SELECT e.name as Employee FROM Employee e
where e.salary > (SELECT salary from Employee where e.managerid = id);
*/
