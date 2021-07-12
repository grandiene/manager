package employee.manager.dao.impl;

import employee.manager.dao.PositionDao;
import employee.manager.model.entity.Position;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao {

    @Autowired
    private Session session;

    @Override
    public List<Position> getList() {
        Query query= session.createQuery("from Position ");
        List<Position> q= query.list();
        return q;
    }
}
