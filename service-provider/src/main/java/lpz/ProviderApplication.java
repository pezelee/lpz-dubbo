package lpz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@MapperScan(basePackages = "lpz.mapper")
@ImportResource("classpath:dubbo.xml")
public class ProviderApplication  implements ServletContextInitializer {

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(ProviderApplication.class, args);
    }

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        context.getSessionCookieConfig().setName("client-session");
    }

}
