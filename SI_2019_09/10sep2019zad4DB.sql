10 септемви 2019
зад4
1 А) заявката вади и продуцентите който нямат нито един филм NULL стойности
а не бива да ги вади
вади само филми с без заглавие Голяма грешка
  не е А
  Б) верния отговор
  В) последния ред where дава грешка
  не е В
  Г) збъркано е grop by с order by
  не е Г


2 
SELECT name,birthdate
from moviestar
where birthdate is not Null
ORDER by birthdate
LIMIT 1

това е за mysql


SELECT top 1 name,birthdate
from moviestar
where birthdate is not Null
ORDER by birthdate

mysql 