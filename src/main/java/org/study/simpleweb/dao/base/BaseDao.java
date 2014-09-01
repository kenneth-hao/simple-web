package org.study.simpleweb.dao.base;

import java.io.Serializable;

/**
 * Created by haoyuewen on 8/31/14.
 */
public interface BaseDao<E, PK extends Serializable> {

    Integer insert(E object);

    Integer update(E object);

    E delete(PK id);

    E findById(PK id);

}
