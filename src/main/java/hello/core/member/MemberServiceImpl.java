package hello.core.member;

public class MemberServiceImpl implements MemberService {
    //MemberServiceImpl입장에서 생성자를 통해 어떤 구현 객체가 들어올지 알 수 없다.
    //의존관계에 대한 고민은 외부에 맡기고, 나의 주요 관심사에만 집중할 수 있다.(관심사의 분리)
    private final MemberRepository memberRepository;

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
}
