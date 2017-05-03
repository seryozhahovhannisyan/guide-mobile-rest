package com.connectto.mobile.repository;

import com.connectto.mobile.common.exception.InternalErrorException;
import com.connectto.mobile.common.util.DataConverter;
import com.connectto.mobile.common.util.QueryUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Created by Arthur on 7/13/2016.
 */
@Repository
public class ContainerRepositoryImpl implements ContainerCustomRepository<Object, Long> {

    private static Logger logger = Logger.getLogger(ContainerRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Object> getByParams(String operator, Map queryMap) throws InternalErrorException {
        try {
            String queryString = QueryUtil.buildQuery(queryMap, operator);
            Query query = em.createNativeQuery(queryString);
            return query.getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InternalErrorException(e);
        }
    }

    @Override
    public Long getCountByParams(String operator, Map queryMap) throws InternalErrorException {
        try {
            String queryString = QueryUtil.buildCountQuery(queryMap, operator);
            Query query = em.createNativeQuery(queryString);
            BigInteger count =  (BigInteger) query.getSingleResult();
            return count == null ? 0 : count.longValue();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InternalErrorException(e);
        }
    }

    @Override
    public List<Long> getIdesByParams(String operator, Map queryMap) throws InternalErrorException {
        try {
            String queryString = QueryUtil.buildQuery(queryMap, operator);
            Query query = em.createNativeQuery(queryString);
            List<Object> objects = query.getResultList();
            return DataConverter.convertIdesToLong(objects);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InternalErrorException(e);
        }
    }
}
