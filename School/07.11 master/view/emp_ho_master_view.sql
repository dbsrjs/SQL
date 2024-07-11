create view emp_ho_master_view
as
select emp_id, emp_name, emp_grade, emp_pay, ho_start, ho_end
 from emp_master, ho_master
where emp_grade = ho_grade;
