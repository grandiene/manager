package employee.manager.controller;


import employee.manager.dao.EmployeeDao;
import employee.manager.model.dto.EmployeeDto;
import employee.manager.model.entity.Employee;
import employee.manager.model.entity.Position;
import employee.manager.service.EmployeeServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees = employeeDao.getEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id){
        Employee employee = employeeDao.getById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> editSave(@RequestBody EmployeeDto employeeDto){

        Employee employee =modelMapper.map(employeeDto, Employee.class);
        employee.setIsDelete(0);
        employee.setIdPosition(employeeDto.getIdPosition());
        EmployeeDto employeeDto1 = modelMapper.map(employeeService.save(employee), EmployeeDto.class);
        System.out.println("sekalian" + employeeDto1);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto){
        Employee employee =modelMapper.map(employeeDto, Employee.class);
        employee.setIsDelete(0);
        employee.setIdPosition(employeeDto.getIdPosition());
        EmployeeDto employeeDto1 = modelMapper.map(employeeService.update(employee), EmployeeDto.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> setIsDelete(@PathVariable Integer id) {
        employeeService.setIsDelete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
