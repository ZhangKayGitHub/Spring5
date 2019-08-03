package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 和spring链接数据库相关的配置类
 */
//@Configuration
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    /**
     * 该方法的作用就是创建一个QueryRunner对象
     * @param dateSource
     * @return
     */
    @Bean(name="runner")
    @Scope("prototype")//由于默认QueryRunner在spring容器中式单例对象，在这里声明为多例
    public QueryRunner createQueryRunner(DataSource dateSource){
        return new QueryRunner(dateSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name="dateSource")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
