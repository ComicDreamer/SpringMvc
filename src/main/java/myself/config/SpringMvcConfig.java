package myself.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("myself.controller")
@EnableWebMvc
//开启json数据类型自动转换 功能非常强大
public class SpringMvcConfig {
}
