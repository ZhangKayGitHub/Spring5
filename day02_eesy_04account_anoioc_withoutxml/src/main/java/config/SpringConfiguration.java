package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是一个配置类，它的作用和xml是一样的
 * Sptring 中的新注解：
 * Configuration
 *      作用：指定当前类是一个配置类
 * ComponentScan
 *      作用：用于通过注解指定spring在创建容器时要扫描的包
 *      细节：当配置类作为AnnototationConfigApplicationContext对象的参数时，该Configuration注解不用写
 *      属性：
 *          value：它和basePackages的作用时一样的，都是用于指定创建容器时要扫描的包
 *          我们使用此注解就等同于在xml中配置了：
 *           <context:component-scan base-package="com.kay"></context:component-scan>
 *
 * Bean
 *      作用：用于把当前方法大的返回值作为bean对象放入spring的ioc容器中
 *      属性：
 *          name：用以指定bean的id，当不写时，默认值就是当前方法的名称，
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring框架会去容器中查找有没有可用的bean对象
 *          查找的方式和Autowrite注解的方式一样
 *
 * Import
 *      作用：用于导入其他的配置类
 *      属性：
 *          value：用于指定其他配置类的字节码。
 *                  当我们使用Import的注解之后，有Import注解的类就是父配置类，而导入的都是子配置类
 * PropertySource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value：指定文件的名称和路径
 *              关键字：classpath：表示类路径下（如果配置文件在某个包下要加上包名）
 */
//@Configuration
//@ComponentScan(basePackages = {"com.kay","config"})//basePackages 的值必须是一个类路径，该注解的返回值是一个字符串数组，当只有有一个扫描包路径是可以省略basePackages
@ComponentScan(basePackages = "com.kay")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")//jdbcConfig.properties这个配置文件当运行时就会被加载到类路径下，因此在它的前面就添加了classPath。
public class SpringConfiguration {

}
