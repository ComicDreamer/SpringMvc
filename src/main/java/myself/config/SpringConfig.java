package myself.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value = "myself", excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = Controller.class
))
// 为了防止Spring去加载了SpringMvc管理的bean，要进行过滤
// 设置排除式过滤器
// 过滤方式为按照注解过滤
// 过滤内容为注解是Controller的类
// 但是这样不够完善，因为会扫描到config包中的SpringMvcConfig，其中又有一个包扫描包含了controller包，所有还是会管理Controller的bean
// 解决办法是可以把SpringMvcConfig放到Spring扫描不到的包里
public class SpringConfig {
}
