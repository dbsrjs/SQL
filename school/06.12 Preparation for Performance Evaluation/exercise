select *
from book_master
where borrowed_by is not null;

select count(mem_no)
from member_master;

select count(borrowed_by)
from book_master;

select genre, count(*) 명수
from book_master
group by genre
order by 명수 desc;

select genre, count(*) 명수
from book_master
group by genre
order by 명수 asc;

select name 회원묭, to_char(join_date, 'YYYY/MM/DD') 가입일자, '010-' || substr(phone, 1, 4) || '-' || substr(phone, 5, 4) 전화번호
from member_master
where join_date < '2023-01-01';
