
SELECT Department.name AS Department , Employee.name AS Employee, Employee.salary AS Salary FROM Department 
        JOIN Employee 
            ON Employee.departmentId = Department.id 
                AND Employee.salary = (SELECT MAX(salary) FROM Employee 
                                            WHERE Employee.departmentId = Department.id);