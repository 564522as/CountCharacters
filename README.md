# CountCharacters
Для запуска программы необходимо собрать его в jar файл с помощью maven(~>mvn package), затем отдать на выполнение:
~>java -jar "FileName.jar"

Программа запускается на локальном хосту - http://localhost:8080 и имеет единственную конечную точку http://localhost:8080/sendingData, которая принимает 
строку в в формате json или xml:
  {
    "data":"text"
  }

или 
  <'data'>text<'data'>(без ковычек)

В ответ вернется массив в виде:
{
  {
  "character":"t",
  "quantity":2
  }
  ...
}
То есть ответом будет массив из символов отправленного текста и их количества в нем.
