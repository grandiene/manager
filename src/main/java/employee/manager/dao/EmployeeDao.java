package employee.manager.dao;


import employee.manager.model.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    Employee getById(Integer id);

    List<Employee> getEmployees();

    Employee save(Employee employee);

    Employee update(Employee employee);

    void setIsDelete(Integer id);
}
