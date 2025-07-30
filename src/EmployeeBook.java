import java.util.Arrays;
import java.util.List;

// Хранилище записей о сотрудниках
public class EmployeeBook {
    private Employee[] arrayEmployees;

    public EmployeeBook() {
        this.arrayEmployees = new Employee[10];
        Fill();
    }

    // Заполнить книгу
    public void Fill()
    {
        arrayEmployees[0] = new Employee("Иванов Иван Иванович", 1, 50000);
        arrayEmployees[1] = new Employee("Петров Сергей Семёнович", 3, 40000);
        arrayEmployees[2] = new Employee("Павлова Екатерина Ивановна", 2, 70000);
        arrayEmployees[3] = new Employee("Антонова Марина Сергеевна", 1, 90000);
        arrayEmployees[4] = new Employee("Сергеев Семён Петрович", 5, 90000);
        arrayEmployees[5] = new Employee("Иванов Александр Иванович", 1, 50000);
        arrayEmployees[6] = new Employee("Петров Семён Александрович", 3, 50000);
        arrayEmployees[7] = new Employee("Семёнова Елена Ивановна", 2, 60000);
        arrayEmployees[8] = new Employee("Антонова Марина Сергеевна", 4, 80000);
        arrayEmployees[9] = new Employee("Сергеев Семён Алексеевич", 1, 50000);
    }

    // Добавить нового сотрудника
    public boolean AddEmployee(Employee employee)
    {
        for (Employee e : arrayEmployees) {
            if (e == null)
            {
                e = employee;
                return true;
            }
        }
        return false;
    }

    // Удалить сотрудника
    public boolean DeleteEmployee(int employeeId)
    {
        for (Employee e : arrayEmployees) {
            if (e.getId() == employeeId)
            {
                e = null;
                return true;
            }
        }
        return false;
    }

    // Найти сотрудника по его id
    public Employee FindEmployeeById(int employeeId)
    {
        for (Employee e : arrayEmployees) {
            if (e.getId() == employeeId)
            {
                return e;
            }
        }
        return null;
    }

    public List<Employee> GetListEmployeesOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = Arrays.stream(arrayEmployees).filter(e -> e.GetDepartmentId() == departmentNumber).toList();
        if(listEmployeesOfDepartment.size() == 0)
        {
            throw new RuntimeException("В отделе №" + departmentNumber + " нет сотрудников.");
        }
        return listEmployeesOfDepartment;
    }

    // 1. Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
    public void IndexTheSalary(int percent)
    {
        float fPercent = 1 + (percent / 100);
        float salary = 0;
        for (Employee employee : arrayEmployees) {
            salary = employee.GetSalary();
            salary = salary * fPercent;
            employee.SetSalary(salary);
        }
    }

    // 2.a Получить в качестве параметра номер отдела и найти сотрудника с минимальной ЗП
    public Employee GetEmployeeWithAMinimumSalaryOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(departmentNumber);
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
    public Employee GetEmployeeWithAMaximumSalaryOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(departmentNumber);
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
    public float GetSalariesAmountOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(departmentNumber);

        float amount = 0;
        for (Employee arrayEmployee : listEmployeesOfDepartment)
        {
            amount += arrayEmployee.GetSalary();
        }
        return amount;
    }

    // 2.d Получить в качестве параметра номер отдела и подсчитать среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public float GetAverageSalaryOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(departmentNumber);
        float salariesAmount = GetSalariesAmountOfDepartment(departmentNumber);
        int employeeCount = listEmployeesOfDepartment.toArray().length;
        float averageSalary = salariesAmount / employeeCount;
        return averageSalary;
    }

    // 2.e Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
    public List<Employee> IndexTheSalaryOfDepartment(int departmentNumber, float percent)
    {
        float fPercent = 1 + (percent / 100);
        float salary = 0;

        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(departmentNumber);

        for (Employee employee : listEmployeesOfDepartment) {
            salary = employee.GetSalary();
            salary = salary * fPercent;
            employee.SetSalary(salary);
        }

        return listEmployeesOfDepartment;
    }

    // 2.f Напечатать всех сотрудников отдела (все данные, кроме отдела)
    public void PrintAllEmployeesOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(departmentNumber);

        for (Employee employee : listEmployeesOfDepartment){
            System.out.println(employee.ToStringAllExceptTheDepartmentId());
        }
    }

    // 3.a Получить в качестве параметра число и вывести всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль)
    public List<Employee> GetAllEmployeesWithSalaryOfLessThanNumberOfDepartment(int departmentNumber, float salaryValue)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(departmentNumber);
        List<Employee> listEmployeesWithSalaryLessThanValue = (Arrays.stream(listEmployeesOfDepartment.toArray()).filter(e -> ((Employee)e).GetSalary() < salaryValue)).map(e -> (Employee)e).toList();
        return listEmployeesWithSalaryLessThanValue;
    }

    // 3.б Получить в качестве параметра число и вывести всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)
    public List<Employee> GetAllEmployeesWithSalaryOfMoreThanNumberOfDepartment(int departmentNumber, float salaryValue)
    {
        List<Employee> listEmployeesOfDepartment = GetListEmployeesOfDepartment(departmentNumber);
        List<Employee> listEmployeesWithSalaryMoreThanValue = (Arrays.stream(listEmployeesOfDepartment.toArray()).filter(e -> ((Employee)e).GetSalary() >= salaryValue)).map(e -> (Employee)e).toList();
        return listEmployeesWithSalaryMoreThanValue;
    }

    // Посчитать сумму затрат на ЗП в месяц
    public float GetSalariesAmount()
    {
        float amount = 0;
        for (Employee employee : arrayEmployees)
        {
            amount += employee.GetSalary();
        }
        return amount;
    }
}
