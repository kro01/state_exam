зад1
SELECT s.name, COUNT(m.title) as cnt
from studio as s  join movie as m
on s.name = m.studioName
GROUP BY s.name
HAVING cnt < 2

А e верен
В) where m.title is null вада филмите без заглавие
C) e верен
D) дава грешка резултатите от групиране се слагат в having  

зад 2
select *
from movieexec
where network LIKE
(SELECT network as n 
FROM movieexec
where network is not NUll
ORDER by network
LIMIT 1)

за mysql

select *
from movieexec
where network LIKE
(SELECT top 1 network as n 
FROM movieexec
where network is not NUll
ORDER by network)

за ms SQL