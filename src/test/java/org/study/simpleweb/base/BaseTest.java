package org.study.simpleweb.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by haoyuewen on 8/28/14.
 */
public class BaseTest {

    protected ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:conf/spring.xml", "classpth:conf/spring-mybatis.xml" });


}
