import java.io.BufferedReader;
import java.io.IOException;
import java.util.Formatter;

public class Tovar { //Класс Tovar определяет объект товара и содержит следующие методы:
    private String name;
    private String description;
    private int price;
    private int number;
    private String unit;
    private int ID;

    public Tovar() {  // конструктор без параметров, который инициализирует поля объекта значениями по умолчанию.
        name = "None";
        description = "None";
        price = 0;
        number = 0;
        unit = "None";
        ID = 0;
    }

    public Tovar(Tovar other) {  //конструктор копирования, который создает новый объект Tovar, копируя все поля из объекта other.
        name = other.name;
        description = other.description;
        price = other.price;
        number = other.number;
        unit = other.unit;
        ID = other.ID;
    }

    public Tovar clone() {
        return new Tovar(this);
    } //метод клонирования, который создает новый объект Tovar и копирует в него все поля текущего объекта.

    public boolean equal(Tovar other) {  //метод, который сравнивает текущий объект Tovar с объектом other и возвращает true, если все поля равны, и false в противном случае.
        return (name.equals(other.name) &&
                description.equals(other.description) &&
                price == other.price &&
                number == other.number &&
                unit.equals(other.unit) &&
                ID == other.ID);
    }

    public void readingFile(BufferedReader reader) throws IOException {  //метод для чтения данных из файла. Он принимает объект BufferedReader, считывает строку из файла, разбивает ее на поля и присваивает их значениям соответствующих полей текущего объекта.

        String line = reader.readLine();
        String[] fields = line.split(", ");

        name = fields[0];
        description = fields[1];
        price = Integer.parseInt(fields[2]);
        number = Integer.parseInt(fields[3]);
        unit = fields[4];
        ID = Integer.parseInt(fields[5]);
    }

    public void writeElement() {  //метод для вывода информации о товаре в консоль в формате "name, description, price, number, unit, ID".
        System.out.println(name + ", " +
                description + ", " +
                price + ", " +
                number + ", " +
                unit + ", " +
                ID);
    }

    public void writeTable(Formatter formatter) { // метод для вывода информации о товаре в таблицу в формате "%s ,%s ,%d ,%d ,%s ,%4d\n". Он принимает объект Formatter, который форматирует вывод в таблицу.
        formatter.format("%s ,%s ,%d ,%d ,%s ,%4d\n", name, description, price, number, unit, ID);
    }
}
