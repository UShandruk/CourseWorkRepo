import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String s = "";

    // Хранилище записей о сотрудниках
    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Иванов Иван Иванович", 1, 50000);
        employees[1] = new Employee("Петров Сергей Семёнович", 3, 40000);
        employees[2] = new Employee("Семёнова Екатерина Ивановна", 2, 60000);
        employees[3] = new Employee("Антонова Марина Сергеевна", 1, 90000);
        employees[4] = new Employee("Сергеев Семён Петрович", 1, 50000);
        employees[5] = new Employee("Иванов Александр Иванович", 1, 50000);
        employees[6] = new Employee("Петров Сергей Семёнович", 3, 50000);
        employees[7] = new Employee("Семёнова Елена Ивановна", 2, 60000);
        employees[8] = new Employee("Антонова Марина Сергеевна", 1, 80000);
        employees[9] = new Employee("Сергеев Семён Алексеевич", 1, 50000);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("8.a. Получить список всех сотрудников со всеми имеющимися по ним данными");//System.out.printf
        PrintAllEmployees();
        System.out.println();

        System.out.println("8.b. Посчитать сумму затрат на ЗП в месяц");
        System.out.println(GetSalariesAmount());
        System.out.println();

        System.out.println("8.c. Найти сотрудника с минимальной ЗП");
        System.out.println(GetEmployeeWithAMinimumSalary().ToString());
        System.out.println();

        System.out.println("8.d. Найти сотрудника с максимальной ЗП");
        System.out.println(GetEmployeeWithAMaximumSalary().ToString());
        System.out.println();

        System.out.println("8.e. Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b)");
        System.out.println(GetAverageSalary());
        System.out.println();

        System.out.println("8.f. Распечатать ФИО всех сотрудников (метод void)");
        PrintAllEmployeesFIO();
    }

    // Получить список всех сотрудников со всеми имеющимися по ним данными (значения всех полей (toString))
    private static List<String> getEmployeesString()
    {
        List<String> listStringEmployees = new ArrayList<>();
        for (Employee employee : employees)
        {
            listStringEmployees.add(employee.ToString());
        }
        return listStringEmployees;
    }

    // Вывести в консоль список всех сотрудников со всеми имеющимися по ним данными
    public static void PrintAllEmployees()
    {
        List<String> stringEmployees = getEmployeesString();
        for(String stringEmployee : stringEmployees){
            System.out.println(stringEmployee);
        }
    }

    // Посчитать сумму затрат на ЗП в месяц
    public static float GetSalariesAmount()
    {
        float amount = 0;
        for (Employee employee : employees)
        {
            amount += employee.GetSalary();
        }
        return amount;
    }

    // Найти сотрудника с минимальной ЗП
    public static Employee GetEmployeeWithAMinimumSalary()
    {
        Employee minEmployee = employees[0];
        float minSalary = minEmployee.GetSalary();
        for (Employee employee : employees)
        {
            if(employee.GetSalary() < minSalary)
            {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    // Найти сотрудника с максимальной ЗП
    public static Employee GetEmployeeWithAMaximumSalary()
    {
        Employee maxEmployee = employees[0];
        float maxSalary = maxEmployee.GetSalary();
        for (Employee employee : employees)
        {
            if(employee.GetSalary() > maxSalary)
            {
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }

    // Подсчитать среднее значение зарплат
    public static float GetAverageSalary()
    {
        float salariesAmount = GetSalariesAmount();
        int employeeCount = employees.length;
        float averageSalary = salariesAmount / employeeCount;
        return averageSalary;
    }

    // Распечатать ФИО всех сотрудников (метод void)
    public static void PrintAllEmployeesFIO()
    {
        for (Employee employee : employees){
            System.out.println(employee.GetFIO());
        }
    }
}