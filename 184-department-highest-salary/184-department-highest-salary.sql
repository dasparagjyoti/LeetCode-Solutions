# Write your MySQL query statement below
select Department.name as Department , Employee.name as Employee, Employee.salary as Salary from Department 
        join Employee 
            on Employee.departmentId = Department.id 
                and Employee.salary = (select max(salary) from Employee 
                                            where Employee.departmentId = Department.id);