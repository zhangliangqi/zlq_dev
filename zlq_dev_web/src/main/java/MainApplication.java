import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author zhangliangqi
 * @Title: MainApplication
 * @Package PACKAGE_NAME
 * @Description
 * @date 2016-05-24
 */

@EnableAutoConfiguration
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
