package employee.manager.dao.impl;

import employee.manager.dao.EmployeeDao;
import employee.manager.model.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private Session session;

    @Override
    public Employee getById(Integer idNya){
        Query query= session.createQuery("from Employee where id =: id");
        query.setParameter("id", idNya);
        return (Employee) query.list().get(0);
    }

    @Override
    public List<Employee> getEmployees(){
        Query query= session.createQuery("from Employee where isDelete =: isDelete");
        query.setParameter("isDelete", 0);
        List<Employee> employees= query.list();
        return employees;
    }

    @Override
    public Employee save(Employee employee){
        System.out.println("ini "+employee);
//        String text = "insert into Employee (name, birthDate, position, idPosition, nip, gender, isDelete) select name, birthDate, position, idPosition, nip, gender, isDelete from Employee";

        System.out.println();
        Integer id = (Integer) session.save(employee);
//        Query query =  session.createQuery(text);
        Employee employee1 = employee;
        System.out.println("ini " + employee1+ "udah");
        return employee1;
    }

    @Override
    public Employee update(Employee employee){
        session.saveOrUpdate(employee);
        return employee;
    }

    @Override
    public void setIsDelete(Integer id){
        Query query = session.createQuery("update Employee set isDelete=:isDelete where id=:id");
        query.setParameter("id", id);
        query.setParameter("isDelete", 1);
        int result =  query.executeUpdate();
        if (result>0)
            System.out.println("success "+ result);
    }



}
