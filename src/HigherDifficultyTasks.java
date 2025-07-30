import java.util.Arrays;
import java.util.List;

/// Класс для решения задач повышенной сложности
public class HigherDifficultyTasks {
    public static List<Employee> GetListEmployeesOfDepartment(Employee[] arrayEmployees, int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = Arrays.stream(arrayEmployees).filter(e -> e.GetDepartmentId() == departmentNumber).toList();
        if(listEmployeesOfDepartment.size() == 0)
        {
            throw new RuntimeException("В отделе №" + departmentNumber + " нет сотрудников.");
        }
        return listEmployeesOfDepartment;
    }

    // 1. Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
    public static void IndexTheSalary(Employee[] employees, int percent)
    {
        float fPercent = 1 + (percent / 100);
        float salary = 0;
        for (Employee employee : employees) {
            salary = employee.GetSalary();
            salary = salary * fPercent;
            employee.SetSalary(salary);
        }
    }

    // 2.a Получить в качестве параметра номер отдела и найти сотрудника с минимальной ЗП
    public static Employee GetEmployeeWithAMinimumSalaryOfDepartment(Employee[] arrayEmployees, int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(arrayEmployees, departmentNumber);
        Employee minEmployee = listEmployeesOfDepartment.get(0);
        float minSalary = minEmployee.GetSalary();
        for (Employee employee : listEmployeesOfDepartment)
        {
            if(employee.GetSalary() < minSalary)
            {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    // 2.b Получить в качестве параметра номер отдела и найти сотрудника с максимальной ЗП
    public static Employee GetEmployeeWithAMaximumSalaryOfDepartment(Employee[] arrayEmployees, int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(arrayEmployees, departmentNumber);
        Employee maxEmployee = listEmployeesOfDepartment.get(0);
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

    // 2.c Получить в качестве параметра номер отдела и найти cумму затрат на ЗП по отделу;
    public static float GetSalariesAmountOfDepartment(Employee[] arrayEmployees, int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(arrayEmployees, departmentNumber);

        float amount = 0;
        for (Employee arrayEmployee : listEmployeesOfDepartment)
        {
            amount += arrayEmployee.GetSalary();
        }
        return amount;
    }

    // 2.d Получить в качестве параметра номер отдела и подсчитать среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public static float GetAverageSalaryOfDepartment(Employee[] arrayEmployees, int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(arrayEmployees, departmentNumber);
        float salariesAmount = GetSalariesAmountOfDepartment(arrayEmployees, departmentNumber);
        int employeeCount = listEmployeesOfDepartment.toArray().length;
        float averageSalary = salariesAmount / employeeCount;
        return averageSalary;
    }

    // 2.e Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
    public static List<Employee> IndexTheSalaryOfDepartment(Employee[] arrayEmployees, int departmentNumber, float percent)
    {
        float fPercent = 1 + (percent / 100);
        float salary = 0;

        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(arrayEmployees, departmentNumber);

        for (Employee employee : listEmployeesOfDepartment) {
            salary = employee.GetSalary();
            salary = salary * fPercent;
            employee.SetSalary(salary);
        }

        return listEmployeesOfDepartment;
    }

    // 2.f Напечатать всех сотрудников отдела (все данные, кроме отдела)
    public static void PrintAllEmployeesOfDepartment(Employee[] arrayEmployees, int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(arrayEmployees, departmentNumber);

        for (Employee employee : listEmployeesOfDepartment){
            System.out.println(employee.ToStringAllExceptTheDepartmentId());
        }
    }

    // 3.a Получить в качестве параметра число и вывести всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль)
    public static List<Employee> GetAllEmployeesWithSalaryOfLessThanNumberOfDepartment(Employee[] arrayEmployees, int departmentNumber, float salaryValue)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(arrayEmployees, departmentNumber);
        List<Employee> listEmployeesWithSalaryLessThanValue = (Arrays.stream(listEmployeesOfDepartment.toArray()).filter(e -> ((Employee)e).GetSalary() < salaryValue)).map(e -> (Employee)e).toList();
        return listEmployeesWithSalaryLessThanValue;
    }

    // 3.б Получить в качестве параметра число и вывести всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)
    public static List<Employee> GetAllEmployeesWithSalaryOfMoreThanNumberOfDepartment(Employee[] arrayEmployees, int departmentNumber, float salaryValue)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(arrayEmployees, departmentNumber);
        List<Employee> listEmployeesWithSalaryMoreThanValue = (Arrays.stream(listEmployeesOfDepartment.toArray()).filter(e -> ((Employee)e).GetSalary() >= salaryValue)).map(e -> (Employee)e).toList();
        return listEmployeesWithSalaryMoreThanValue;
    }
}
