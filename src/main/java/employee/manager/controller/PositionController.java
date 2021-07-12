package employee.manager.controller;

import employee.manager.dao.PositionDao;
import employee.manager.dao.impl.PositionDaoImpl;
import employee.manager.model.entity.Position;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/position")
public class PositionController {


    private final PositionDao positionDao;

    public PositionController(PositionDao positionDao) {
        this.positionDao = positionDao;
    }


    @GetMapping
    public ResponseEntity<List<Position>> getPosition(){
        List<Position> p = positionDao.getList();
        return new ResponseEntity<List<Position>>(p, HttpStatus.OK);
    }


}
