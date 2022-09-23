select d.name as "Department",e1.Name as "Employee", e1.Salary as "Salary"
from employee e1, employee e2, department d
where e1.DepartmentId = e2.DepartmentId
and e1.Salary <= e2.Salary
and e2.DepartmentId = d.Id
group by d.Name, e1.Name
having count(distinct(e2.salary)) <= 3;

/*
select d.Name as 'Department', e1.Name as 'Employee', e1.Salary
from Employee e1 join Department d on e1.DepartmentId = d.Id
where 3 > (select count(distinct e2.Salary)
           from Employee e2
           where e2.Salary > e1.Salary
           and e1.DepartmentId = e2.DepartmentId);
           */