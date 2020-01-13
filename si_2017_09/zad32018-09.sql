1
SELECT ships.name, classes.country # , COUNT(outcomes.RESULT = 'sunk')
from ships join outcomes on ships.name = outcomes.ship 
join classes  on ships.CLASS = classes.CLASS

GROUP by ships.NAME
HAVING COUNT(outcomes.RESULT = 'sunk') = 0

2

SELECT name,displacement,numguns
from classes c join ships s on s.CLASS = c.CLASS
where displacement = ( select min(displacement)
                      from classes)
and numguns = (select min(c1.numguns)
                      from classes c1
                    where 1)

3

SELECT battle
FROM outcomes o1
where battle not in (SELECT BATTLE
      from outcomes o2
      where o1.SHIP not like o2.ship
     )

SELECT battle,COUNT(*)
FROM outcomes o1
GROUP by BATTLE
having COUNT(*) = 1

4 

SELECT c.CLASS, COUNT(DISTINCT(name))
from classes c join ships s
ON c.CLASS = s.CLASS
join outcomes o on o.SHIP = s.NAME
where o.RESULT = 'sunk'
and c.CLASS in (SELECT c.CLASS
				from classes c join ships s
				ON c.CLASS = s.CLASS
				GROUP by c.CLASS
				HAVING COUNT(*)>5)
GROUP by c.CLASS

A няма броя потънали кораба
Б съвпада с моето решение
В грешака с count трябва да е having
Г on на грешно място