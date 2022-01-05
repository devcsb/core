package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest { // 스프링이나 컨테이너 도움 없이 순수 자바코드로 돌아가는 단위테스트 활용이 중요하다.

    MemberService memberService;

    @BeforeEach //각 테스트 실행 전 무조건 실행되는 메서드
    public void beforeEach() { //appConfig
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
