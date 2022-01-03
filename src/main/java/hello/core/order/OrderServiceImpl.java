package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //회원 등급 찾기 위해 정보 가져오기
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //할인 정책 가져오기
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원정보 조회
        Member member = memberRepository.findById(memberId);
        // 할인에 대해서는 orderService가 신경 쓸 일이 없다. discountPolicy만 고치면 된다. 단일책임원칙. SRP
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
