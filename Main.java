import java.io.BufferedReader; //Импортируются необходимые классы
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;

public class Main {  //создается класс Main
    public static void main(String[] args) {  //Создается метод main(),который является точкой входа в программу
        Tovar[] tovars = new Tovar[50]; //Создается массив обьектов типа Tovar

        try { //В блоке try-catch открывается файл для чтения
            FileReader fileReader = new FileReader("C:\\Users\\КОКСИК\\IdeaProjects\\lab0aasdc\\src\\products.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            for(int i = 0; i < tovars.length; i++) { //В цикле for читается содержимое файла и создаются объекты Tovar, которые добавляются в массив
                tovars[i] = new Tovar();
                tovars[i].readingFile(bufferedReader);
            }

            Formatter form = new Formatter(System.out); //Создается объект Formatter, который будет использоваться для форматирования вывода таблицы
            for(int i = 0; i < tovars.length; i++) {  //В цикле for вызывается метод writeTable() для каждого объекта Tovar, который форматирует данные в виде таблицы и выводит их с помощью объекта Formatter
                tovars[i].writeTable(form);
            }

            bufferedReader.close(); //Закрывается BufferedReader
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage()); //Если происходит ошибка при открытии файла, выводится сообщение об ошибке
        }
    }
}