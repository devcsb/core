package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    //MemberServiceImpl입장에서 생성자를 통해 어떤 구현 객체가 들어올지 알 수 없다.
    //의존관계에 대한 고민은 외부에 맡기고, 나의 주요 관심사에만 집중할 수 있다.(관심사의 분리)
    private final MemberRepository memberRepository;

    @Autowired // 스프링이 스프링컨테이너에 있는 memberRepository인스턴스 의 타입과 같은 것이 있는지 찾아서 주입한다. (같은 타입이 여러개 있으면 충돌 남)
    public MemberServiceImpl(MemberRepository memberRepository) { //MemberRepository에 어떤 구현체가 들어갈 지는 생성자를 통해서 정한다.
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
