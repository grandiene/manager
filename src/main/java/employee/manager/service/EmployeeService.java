package employee.manager.service;

import employee.manager.model.entity.Employee;

public interface EmployeeService {
    Employee save(Employee employee);
    void setIsDelete(Integer id);
    Employee update(Employee employee);
}
