/// Сотрудник
public class Employee {

    /// Уникальный идентификатор
    private int id;

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        Id = id;
    }*/


    /// Конструктор
    public Employee(String FIO, int departmentId, float salary) {
        id = counter;
        counter++;
        this.fIO = FIO;
        this.departmentId = departmentId;
        this.salary = salary;
    }


    /// Счетчик сотрудников
    private static int counter;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Employee.counter = counter;
    }


    /// ФИО
    private String fIO;

    public String getFIO() {
        return this.fIO;
    }

    public void setFIO(String FIO) {
        this.fIO = fIO;
    }


    /// Номер отдела
    private int departmentId;

    public int getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


    /// Заработная плата
    private float salary;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    /// Конвертировать все поля класса в одну строку
    public String toStringAll()
    {
        return id + " - " + fIO + " - отдел №" + departmentId + " - " + salary;
    }

    /// Конвертировать все поля класса (кроме номера отдела) в одну строку
    public String toStringAllExceptTheDepartmentId()
    {
        return id + " - " + fIO + " - " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.id == ((Employee)o).id) return true;
        else {
            return false;
        }
    }

    // Вернуть, починить
    /*
    @Override
    public int hashCode() {
        //int result = this.id != null ? position.hashCode() : 0;
        int result = this.hashCode();
        result = 31 * result + id;
        return result;
    }
     */
}
