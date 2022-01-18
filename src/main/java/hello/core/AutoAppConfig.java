package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(//@Component 어노테이션이 붙은 클래스를 모두 찾아서 자동으로 스프링 빈에 등록해준다.
        //basePackages를 따로 지정하지 않을 시, @ComponentScan이 붙은 설정정보 클래스의 패키지가 시작위치가 된다.
        basePackages = "hello.core.member", // 탐색할 패키지의 시작 위치를 지정한다.
        basePackageClasses = AutoAppConfig.class, //AutoAppConfig가 위치한 패키지를 basePackage 삼는다.

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 보통 실무에서는 따로 제외하지 않지만, 기존 예제코드 최대한 남기기 위해 사용함.
)
public class AutoAppConfig {
    //자동등록된 memoryMemberRepository 과 중복되는 수동등록된 memoryMemberRepository를 만들면,
    //CoreApplicationTests에서는 중복등록되었다고 오류를 내뱉는다. 일반 테스트코드에서는 수동등록된 빈에 우선권을 준다.
    //오류 : The bean 'memoryMemberRepository', defined in class path resource [hello/core/AutoAppConfig.class], could not be registered.
    // properties에 spring.main.allow-bean-definition-overriding=true 설정을 하면 오류를 내뱉지 않는다.
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
