package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MemberApp { // Member 테스트. 실행환경에서 이렇게 테스트하는 것엔 한계가 있다.
                        //그러므로 test 폴더 내에서 junit으로 테스트코드를 작성한다.
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig(); // AppConfig 인스턴스 선언
//        MemberService memberService = appConfig.memberService(); //memberService 변수 안에 memberServiceImpl이 들어가 있다.

        //AppConfig안에 있는 환경설정 정보를 참고해서 스프링컨테이너에 객체생성해서 스프링 빈에 등록해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
