package employee.manager.service;


import employee.manager.dao.PositionDao;
import employee.manager.dao.impl.PositionDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService{

    @Autowired
    private PositionDaoImpl positionDaoImp;

    @Override
    public PositionDao getPosition(PositionDao positionDao){
        return positionDao;
    }



}
