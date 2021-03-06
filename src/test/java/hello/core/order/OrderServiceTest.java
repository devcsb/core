package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach //각 테스트 실행 전 무조건 실행되는 메서드
    public void beforeEach() { //appConfig
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId =1L; //Wrapper type Long이 아닌 primitive type long으로 써도 상관없다. 다만 객체 생성단계에서 null이 들어갈 수도 있어서 wrapper를 쓴다.
                            // long memberId =null; << 기본형은 오류가 나지만 Long memberId = null;은 가능
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
