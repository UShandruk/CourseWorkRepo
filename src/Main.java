import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {


        // Базовая сложность
        /*
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
        */

        // Повышенная сложность
        /*System.out.println("1. Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)");//System.out.printf
        float percentValue = 50;
        System.out.println("Число = " + percentValue);
        List<Employee> listEmployeesIndexed = HigherDifficultyTasks.IndexTheSalaryOfDepartment(arrayEmployees, 3, percentValue);
        PrintAllEmployees(listEmployeesIndexed);
        System.out.println();

        System.out.println("2.a. Получить в качестве параметра номер отдела (1-5) и найти сотрудника с минимальной зп");
        System.out.println(HigherDifficultyTasks.GetEmployeeWithAMinimumSalaryOfDepartment(arrayEmployees, 2).ToStringAll());
        System.out.println();

        System.out.println("2.b. Получить в качестве параметра номер отдела (1-5) и найти сотрудника с максимальной зп");
        System.out.println(HigherDifficultyTasks.GetEmployeeWithAMaximumSalaryOfDepartment(arrayEmployees, 5).ToStringAll());
        System.out.println();

        System.out.println("2.c. Получить в качестве параметра номер отдела (1-5) и найти сумму затрат на зп по отделу");
        System.out.println(HigherDifficultyTasks.GetSalariesAmountOfDepartment(arrayEmployees, 4));
        System.out.println();

        System.out.println("2.d. Получить в качестве параметра номер отдела (1-5) и найти среднюю зп по отделу");
        System.out.println(HigherDifficultyTasks.GetAverageSalaryOfDepartment(arrayEmployees, 4));
        System.out.println();

        System.out.println("2.e. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра");
        System.out.println("Дублирует задание 1");
        System.out.println();

        System.out.println("2.f. Напечатать всех сотрудников отдела (все данные, кроме отдела)");
        // System.out.println(HigherDifficultyTasks.GetListEmployeesOfDepartment(arrayEmployees, 1));
        List<Employee> listEmployeesOfDepartment = HigherDifficultyTasks.GetListEmployeesOfDepartment(arrayEmployees, 1);
        PrintAllEmployeesExceptTheDepartmentId(listEmployeesOfDepartment);
        System.out.println();

        System.out.println("3.a. Получить в качестве параметра число и вывести всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль)");
        float salaryValue1 = 50000;
        System.out.println("Число = " + salaryValue1);
        List<Employee> listEmployeesWithSalaryLess = HigherDifficultyTasks.GetAllEmployeesWithSalaryOfLessThanNumberOfDepartment(arrayEmployees, 5, salaryValue1);
        PrintAllEmployeesExceptTheDepartmentId(listEmployeesWithSalaryLess);
        System.out.println();

        System.out.println("3.b. Получить в качестве параметра число и вывести всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)");
        float salaryValue2 = 50000;
        System.out.println("Число = " + salaryValue2);
        List<Employee> listEmployeesWithSalaryMore = HigherDifficultyTasks.GetAllEmployeesWithSalaryOfMoreThanNumberOfDepartment(arrayEmployees, 5, salaryValue2);
        PrintAllEmployeesExceptTheDepartmentId(listEmployeesWithSalaryMore);*/
        /*
        List<Employee> listEmployeesOfDepartment = HigherDifficultyTasks.GetListEmployeesOfDepartment(arrayEmployees,4);
        PrintAllEmployees(listEmployeesOfDepartment);*/

        // Очень сложно
        EmployeeBook employeeBook = new EmployeeBook();
        System.out.println("1. Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)");//System.out.printf
        float percentValue = 50;
        System.out.println("Число = " + percentValue);
        List<Employee> listEmployeesIndexed = employeeBook.indexTheSalaryOfDepartment(3, percentValue);
        printAllEmployees(listEmployeesIndexed);
        System.out.println();

        System.out.println("2.a. Получить в качестве параметра номер отдела (1-5) и найти сотрудника с минимальной зп");
        System.out.println(employeeBook.getEmployeeWithAMinimumSalaryOfDepartment(2).toStringAll());
        System.out.println();

        System.out.println("2.b. Получить в качестве параметра номер отдела (1-5) и найти сотрудника с максимальной зп");
        System.out.println(employeeBook.getEmployeeWithAMaximumSalaryOfDepartment(5).toStringAll());
        System.out.println();

        System.out.println("2.c. Получить в качестве параметра номер отдела (1-5) и найти сумму затрат на зп по отделу");
        System.out.println(employeeBook.getSalariesAmountOfDepartment(4));
        System.out.println();

        System.out.println("2.d. Получить в качестве параметра номер отдела (1-5) и найти среднюю зп по отделу");
        System.out.println(employeeBook.getAverageSalaryOfDepartment(4));
        System.out.println();

        System.out.println("2.e. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра");
        System.out.println("Дублирует задание 1");
        System.out.println();

        System.out.println("2.f. Напечатать всех сотрудников отдела (все данные, кроме отдела)");
        // System.out.println(HigherDifficultyTasks.GetListEmployeesOfDepartment(arrayEmployees, 1));
        List<Employee> listEmployeesOfDepartment = employeeBook.getListEmployeesOfDepartment(1);
        printAllEmployeesExceptTheDepartmentId(listEmployeesOfDepartment);
        System.out.println();

        System.out.println("3.a. Получить в качестве параметра число и вывести всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль)");
        float salaryValue1 = 50000;
        System.out.println("Число = " + salaryValue1);
        List<Employee> listEmployeesWithSalaryLess = employeeBook.getAllEmployeesWithSalaryOfLessThanNumberOfDepartment(5, salaryValue1);
        printAllEmployeesExceptTheDepartmentId(listEmployeesWithSalaryLess);
        System.out.println();

        System.out.println("3.b. Получить в качестве параметра число и вывести всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)");
        float salaryValue2 = 50000;
        System.out.println("Число = " + salaryValue2);
        List<Employee> listEmployeesWithSalaryMore = employeeBook.getAllEmployeesWithSalaryOfMoreThanNumberOfDepartment(5, salaryValue2);
        printAllEmployeesExceptTheDepartmentId(listEmployeesWithSalaryMore);

        System.out.println("1-й equals() 2-й // false");
        System.out.println(listEmployeesOfDepartment.get(1).equals(listEmployeesOfDepartment.get(2)));
    }
/*
    // Получить список всех сотрудников со всеми имеющимися по ним данными (значения всех полей (toString))
    private static List<String> getEmployeesString()
    {
        List<String> listStringEmployees = new ArrayList<>();
        for (Employee employee : arrayEmployees)
        {
            listStringEmployees.add(employee.ToStringAll());
        }
        return listStringEmployees;
    }*/

    // Вывести в консоль список всех сотрудников со всеми имеющимися по ним данными
    public static void PrintAllEmployeesString(List<String> listStringEmployees)
    {
        //List<String> listStringEmployees = getEmployeesString();
        for(String stringEmployee : listStringEmployees){
            System.out.println(stringEmployee);
        }
    }

    // Вывести в консоль список всех сотрудников со всеми имеющимися по ним данными
    public static void printAllEmployees(List<Employee> listEmployees)
    {
        for(Employee employee : listEmployees){
            System.out.println(employee.toStringAll());
        }
    }

    // Вывести в консоль список всех сотрудников со всеми имеющимися по ним данными кроме номера отдела
    public static void printAllEmployeesExceptTheDepartmentId(List<Employee> listEmployees)
    {
        for(Employee employee : listEmployees){
            System.out.println(employee.toStringAllExceptTheDepartmentId());
        }
    }


/*
    // Найти сотрудника с минимальной ЗП
    public static Employee GetEmployeeWithAMinimumSalary()
    {
        Employee minEmployee = arrayEmployees[0];
        float minSalary = minEmployee.GetSalary();
        for (Employee employee : arrayEmployees)
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
        Employee maxEmployee = arrayEmployees[0];
        float maxSalary = maxEmployee.GetSalary();
        for (Employee employee : arrayEmployees)
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
        int employeeCount = arrayEmployees.length;
        float averageSalary = salariesAmount / employeeCount;
        return averageSalary;
    }

    // Распечатать ФИО всех сотрудников (метод void)
    public static void PrintAllEmployeesFIO()
    {
        for (Employee employee : arrayEmployees){
            System.out.println(employee.GetFIO());
        }
    }*/
}