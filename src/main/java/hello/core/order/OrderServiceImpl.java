package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //회원 등급 찾기 위해 정보 가져오기
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //할인 정책 가져오기
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    할인 정책을 변경하려면 클라이언트인 OrderServiceImpl 코드를 고쳐야 한다.
//    그러므로 아래처럼 인터페이스에만 의존하게 바꾼다. 물론 다른 설정을 안해주면 nullpointerexception이 남.
    private DiscountPolicy discountPolicy;


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원정보 조회
        Member member = memberRepository.findById(memberId);
        // 할인에 대해서는 orderService가 신경 쓸 일이 없다. discountPolicy만 고치면 된다. 단일책임원칙. SRP
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
