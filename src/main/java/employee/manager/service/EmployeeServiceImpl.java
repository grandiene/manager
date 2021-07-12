package employee.manager.service;

import employee.manager.dao.impl.EmployeeDaoImpl;
import employee.manager.model.entity.Employee;
import employee.manager.repository.EmployeeRepository;
import employee.manager.repository.PositionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoImpl employeeDao;

    @Autowired
    private  PositionRepository positionRepository;

    @Autowired
    private Session session;


    @Override
    public Employee save(Employee employee){
        return employeeDao.save(employee);
    }

    @Override
    public void setIsDelete(Integer id) {
        employeeDao.setIsDelete(id);
    }

    @Override
    public Employee update(Employee employee){
        return employeeDao.update(employee);
    }


}
