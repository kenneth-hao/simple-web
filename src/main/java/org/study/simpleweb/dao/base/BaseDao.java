package org.study.simpleweb.dao.base;

import java.io.Serializable;

/**
 * Created by haoyuewen on 8/31/14.
 */
public interface BaseDao<E, PK extends Serializable> {

    Integer insert(E object);

    E findById(PK id);

}
