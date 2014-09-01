package org.study.simpleweb.dao.base.implbatis;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.study.simpleweb.dao.base.BaseDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by haoyuewen on 8/31/14.
 */
public class BaseDaoImplBatis<E, PK extends Serializable> extends SqlSessionDaoSupport implements BaseDao<E, PK> {

    private Class<E> entryClass;

    /**
     * be use for connect class full name to become its namespace
     */
    public static final String NAMESPACE_CONN_STR = "Mapper.";

    // sqlmap.xml定义文件中对应的sqlid
    public static final String SQLID_INSERT = "insert";
    public static final String SQLID_FIND_BY_ID = "findById";

    public BaseDaoImplBatis()  {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        entryClass = (Class<E>) params[0];
    }

    @Override
    public Integer insert(E object) {
        return getSqlSession().insert(getNamespace(SQLID_INSERT), object);
    }

    @Override
    public E findById(PK id) {
        return getSqlSession().selectOne(getNamespace(SQLID_FIND_BY_ID), id);
    }

    private String getNamespace(String sqlid) {
        return entryClass.getName() + NAMESPACE_CONN_STR + sqlid;
    }

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    public void commit() {
        getSqlSession().commit();
    }
}
