package org.study.simpleweb.base;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

/**
 * Created by haoyuewen on 8/28/14.
 */
@SpringApplicationContext({"classpath:conf/spring.xml", "classpath:conf/spring-mybatis.xml"})
public class BaseTest extends UnitilsJUnit4 {

    @SpringApplicationContext
    protected ApplicationContext applicationContext;

    @Test
    public void testApplicationContext() {
        Assert.notNull(applicationContext);
    }

}
