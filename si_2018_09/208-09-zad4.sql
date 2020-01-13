1

SELECT  s.class,
min(b.DATE) as `Date of First Batte`,
max(b.date) as `Date of  Last Battel`,
COUNT(DISTINCT(b.NAME)) as `Number of battles`
from ships as s join outcomes as o
on s.NAME = o.SHIP
join battles as b 
on o.BATTLE = b.name
#where s.class like 'm%'
GROUP by s.CLASS

2

SELECT b.NAME  #,COUNT(c.TYPE = 'bb') , COUNT(c.TYPE = 'bc')
from classes as c join ships as s 
on c.CLASS = s.CLASS 
join outcomes as o
on s.name = o.SHIP
join battles as b 
on o.BATTLE = b.NAME
GROUP by b.NAME
HAVING COUNT(c.TYPE = 'bb') > COUNT(c.TYPE = 'bc')