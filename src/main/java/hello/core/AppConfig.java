package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { //AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.

    @Bean
    public MemberService memberService() {  //MemberServiceImpl이란 구현체를 생성시킬 때 MemoryMemberRepository를 생성자 주입 시킨다.
        return new MemberServiceImpl(memberRepository());  //memoryMemberRepository 객체를 생성하고 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달한다.
        // -> MemberServiceImpl을 만들고 내가 만든 MemberServiceImpl은 MemoryMemberRepository를 사용할 것이다. 라는 뜻.
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new RateDiscountPolicy();
        return new FixDiscountPolicy();
    }

}
