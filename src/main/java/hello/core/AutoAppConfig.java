package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(//@Component 어노테이션이 붙은 클래스를 모두 찾아서 자동으로 스프링 빈에 등록해준다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 보통 실무에서는 따로 제외하지 않지만, 기존 예제코드 최대한 남기기 위해 사용함.
)
public class AutoAppConfig {

}
