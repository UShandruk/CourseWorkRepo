import java.util.Objects;

/// Сотрудник
public class Employee {

    /// Уникальный идентификатор
    private int id;

    /// Счетчик сотрудников
    private static int counter;

    /// ФИО
    private String fIO;

    /// Номер отдела
    private int departmentId;

    /// Заработная плата
    private float salary;


    /// Конструктор
    public Employee(String FIO, int departmentId, float salary) {
        id = counter;
        counter++;
        this.fIO = FIO;
        this.departmentId = departmentId;
        this.salary = salary;
    }


    /// Методы
    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }

    public String getFIO() {
        return this.fIO;
    }

    public void setFIO(String FIO) {
        this.fIO = fIO;
    }

    public int getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    /// Конвертировать все поля класса в одну строку
    public String toStringAll() {
        return id + " - " + fIO + " - отдел №" + departmentId + " - " + salary;
    }

    /// Конвертировать все поля класса (кроме номера отдела) в одну строку
    public String toStringAllExceptTheDepartmentId() {
        return id + " - " + fIO + " - " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (this.id == ((Employee) o).id)
            return true;
        if (this.hashCode() == o.hashCode())
            return true;
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        /*int result = this != null ? this.hashCode() : 0;
        result = 31 * result + id;*/
        int result = Objects.hash(id);
        return result;
    }
}
