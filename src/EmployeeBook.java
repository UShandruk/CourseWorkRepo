import java.util.*;
import java.util.ArrayList;

// Хранилище записей о сотрудниках
public class EmployeeBook {

    // Записи о сотрудниках
    private Employee[] arrayEmployees;



    // Конструктор
    public EmployeeBook() {
        this.arrayEmployees = new Employee[10];
        fill();
    }



    // Заполнить книгу
    public void fill()
    {
        arrayEmployees[0] = new Employee("Иванов Иван Иванович", 4, 50000);
        arrayEmployees[1] = new Employee("Иванов Иван Иванович", 3, 50000);
        arrayEmployees[2] = new Employee("Павлова Екатерина Ивановна", 2, 70000);
        arrayEmployees[3] = new Employee("Антонова Марина Сергеевна", 1, 90000);
        arrayEmployees[4] = new Employee("Сергеев Семён Петрович", 5, 90000);
       /* arrayEmployees[5] = new Employee("Иванов Александр Иванович", 1, 40000);
        arrayEmployees[6] = new Employee("Петров Семён Александрович", 3, 50000);
        arrayEmployees[7] = new Employee("Семёнова Елена Ивановна", 2, 60000);
        arrayEmployees[8] = new Employee("Антонова Марина Сергеевна", 4, 80000);
        arrayEmployees[9] = new Employee("Сергеев Семён Алексеевич", 1, 50000);*/
    }

    // Добавить нового сотрудника
    public String addEmployee(Employee employeeToAdd) {
        boolean isEmployeeExist = (Arrays.stream(arrayEmployees).filter(emp -> emp.getId() == employeeToAdd.getId())) == null;
        if(isEmployeeExist)
        {
            return ("Сотрудник был добавлен ранее.");
        }
        else {
            int cellCounter = 0;
            for (Employee e : arrayEmployees) {
                if (e == null) {
                    arrayEmployees[cellCounter] = employeeToAdd;
                    return ("Cотрудник успешно добавлен.");
                }
                else cellCounter++;
            }
            return ("cellCounter = " + cellCounter + ", employeeToAdd.Id = " + employeeToAdd.getId());
        }
    }

    // Удалить сотрудника
    public String deleteEmployee(int employeeToDelId) {
        Employee employeeToDel = findEmployeeById(employeeToDelId);
        if(employeeToDel == null)
        {
            return ("Сотрудник был удалён ранее.");
        }
        else {
            int cellCounter = 0;
            for (Employee e : arrayEmployees) {
                if (e.getId() == employeeToDelId) {
                    arrayEmployees[cellCounter] = null;
                    return ("Cотрудник успешно удалён.");
                }
                else cellCounter++;
            }
        }
        return ("Сотрудник успешно удалён.");
    }

    // Найти сотрудника по его id
    public Employee findEmployeeById(int employeeId)
    {
        //Arrays.stream(arrayEmployees).filter(emp -> emp.getId() == employeeId);
        for (Employee e : arrayEmployees) {
            if (e.getId() == employeeId)
            {
                return e;
            }
        }
        return null;
    }


    // Получить список сотрудников отдела
    public List<Employee> getListEmployeesOfDepartment(int departmentNumber) {
        List<Employee> listEmployeesOfDepartment = null;
        if (departmentNumber > 0) {
            //listEmployeesOfDepartment = Arrays.stream(arrayEmployees).filter(e -> e.getDepartmentId() == departmentNumber).toList();
            listEmployeesOfDepartment = Arrays.stream(arrayEmployees).filter(e -> e != null).filter(e -> e.getDepartmentId() == departmentNumber).toList();
            if (listEmployeesOfDepartment.size() == 0) {
                throw new RuntimeException("В отделе №" + departmentNumber + " нет сотрудников.");
            }
        }
        else {
            listEmployeesOfDepartment = getListEmployeesAll();
        }
        return listEmployeesOfDepartment;
    }

    // Получить список сотрудников (всех отделов)
    public List<Employee> getListEmployeesAll()
    {
        List<Employee> listEmployeesAll = Arrays.stream(arrayEmployees).filter(e -> e != null).toList();
        return listEmployeesAll;
    }

    // 1. Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %)
    public void indexTheSalary(int percent)
    {
        float fPercent = 1 + (percent / 100);
        float salary = 0;
        for (Employee employee : arrayEmployees) {
            salary = employee.getSalary();
            salary = salary * fPercent;
            employee.setSalary(salary);
        }
    }

    // 2.a Получить в качестве параметра номер отдела и найти сотрудника с минимальной ЗП
    public Employee getEmployeeWithAMinimumSalaryOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = getListEmployeesOfDepartment(departmentNumber);
        Employee minEmployee = listEmployeesOfDepartment.get(0);
        float minSalary = minEmployee.getSalary();
        for (Employee employee : listEmployeesOfDepartment)
        {
            if(employee.getSalary() < minSalary)
            {
                minEmployee = employee;
            }
        }
        return minEmployee;
    }

    // 2.b Получить в качестве параметра номер отдела и найти сотрудника с максимальной ЗП
    public Employee getEmployeeWithAMaximumSalaryOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = getListEmployeesOfDepartment(departmentNumber);
        Employee maxEmployee = listEmployeesOfDepartment.get(0);
        float maxSalary = maxEmployee.getSalary();
        for (Employee employee : listEmployeesOfDepartment)
        {
            if(employee.getSalary() > maxSalary)
            {
                maxEmployee = employee;
            }
        }
        return maxEmployee;
    }

    // 2.c Получить в качестве параметра номер отдела и найти cумму затрат на ЗП по отделу;
    public float getSalariesAmountOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = getListEmployeesOfDepartment(departmentNumber);

        float amount = 0;
        for (Employee employee : listEmployeesOfDepartment)
        {
            amount += employee.getSalary();
        }
        return amount;
    }

    // 2.d Получить в качестве параметра номер отдела и подсчитать среднюю зп по отделу (учесть, что количество людей в отделе отличается от employees.length);
    public float getAverageSalaryOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = getListEmployeesOfDepartment(departmentNumber);
        float salariesAmount = getSalariesAmountOfDepartment(departmentNumber);
        int employeeCount = listEmployeesOfDepartment.toArray().length;
        float averageSalary = salariesAmount / employeeCount;
        return averageSalary;
    }

    // 2.e Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра;
    public List<Employee> indexTheSalaryOfDepartment(int departmentNumber, float percent)
    {
        float fPercent = 1 + (percent / 100);
        float salary = 0;

        List<Employee> listEmployeesOfDepartment = getListEmployeesOfDepartment(departmentNumber);

        for (Employee employee : listEmployeesOfDepartment) {
            salary = employee.getSalary();
            salary = salary * fPercent;
            employee.setSalary(salary);
        }

        return listEmployeesOfDepartment;
    }

    // 2.f Напечатать всех сотрудников отдела (все данные, кроме отдела)
    public void printAllEmployeesOfDepartment(int departmentNumber)
    {
        List<Employee> listEmployeesOfDepartment = getListEmployeesOfDepartment(departmentNumber);

        for (Employee employee : listEmployeesOfDepartment){
            System.out.println(employee.toStringAllExceptTheDepartmentId());
        }
    }

    // 3.a Получить в качестве параметра число и вывести всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль)
    public List<Employee> getAllEmployeesWithSalaryOfLessThanNumberOfDepartment(int departmentNumber, float salaryValue)
    {
        List<Employee> listEmployeesOfDepartment = getListEmployeesOfDepartment(departmentNumber);
        List<Employee> listEmployeesWithSalaryLessThanValue = (Arrays.stream(listEmployeesOfDepartment.toArray()).filter(e -> ((Employee)e).getSalary() < salaryValue)).map(e -> (Employee)e).toList();
        return listEmployeesWithSalaryLessThanValue;
    }

    // 3.б Получить в качестве параметра число и вывести всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)
    public List<Employee> getAllEmployeesWithSalaryOfMoreThanNumberOfDepartment(int departmentNumber, float salaryValue)
    {
        List<Employee> listEmployeesOfDepartment = getListEmployeesOfDepartment(departmentNumber);
        List<Employee> listEmployeesWithSalaryMoreThanValue = (Arrays.stream(listEmployeesOfDepartment.toArray()).filter(e -> ((Employee)e).getSalary() >= salaryValue)).map(e -> (Employee)e).toList();
        return listEmployeesWithSalaryMoreThanValue;
    }

    // Посчитать сумму затрат на ЗП в месяц
    public float getSalariesAmount()
    {
        float amount = 0;
        for (Employee employee : arrayEmployees)
        {
            amount += employee.getSalary();
        }
        return amount;
    }
}
