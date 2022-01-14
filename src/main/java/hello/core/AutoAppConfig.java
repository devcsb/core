package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(//@Component 어노테이션이 붙은 클래스를 모두 찾아서 자동으로 스프링 빈에 등록해준다.
        //basePackages를 따로 지정하지 않을 시, @ComponentScan이 붙은 설정정보 클래스의 패키지가 시작위치가 된다.
        basePackages = "hello.core.member", // 탐색할 패키지의 시작 위치를 지정한다.
        basePackageClasses = AutoAppConfig.class, //AutoAppConfig가 위치한 패키지를 basePackage 삼는다.

        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 보통 실무에서는 따로 제외하지 않지만, 기존 예제코드 최대한 남기기 위해 사용함.
)
public class AutoAppConfig {

}
