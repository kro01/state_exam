1 
SELECT s.name,min(m.year) as minYear ,max(m.year) as maxYear,COUNT(s.presc) as numFIlms
from studio as s left join movie as m
on s.name = m.studioName
WHERE name like 'm%'
GROUP by s.presc

2 
SELECT  m.name,COUNT(*) as cnt
from moviestar as m join starsin as s
on m.name = s.starName
WHERE m.gender = 'women'
GROUP by m.name