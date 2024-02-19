package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.BatchEntity;

public class BatchRepository {

    public BatchEntity get(Integer id, Session session) {

        BatchEntity batchEntity = session.get(BatchEntity.class, id);
        return batchEntity;
    }

    public List<BatchEntity> getAll(Session session) {
        String hql = "FROM BatchEntity";
        Query query = session.createQuery(hql);
        List<BatchEntity> batchEntities = query.list();
        return batchEntities;
    }

    public List<Object[]> getAllBySQL(Session session) {
        String sql = "SELECT * FROM batch";
        Query query = session.createSQLQuery(sql);
        List<Object[]> batchEntities = query.list();
        return batchEntities;
    }

    public List<String> getAllNames(Session session) {
        String hql = "SELECT B.name FROM BatchEntity B";
        Query query = session.createQuery(hql);
        List<String> nameList = query.list();
        return nameList;
    }

}
