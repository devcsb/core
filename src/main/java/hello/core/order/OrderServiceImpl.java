package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {


    //생성자 주입 방식만 final 키워드를 사용할 수 있다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //    //필드주입 예시
//    // 필드 주입은 외부에서 변경이 불가능, DI컨테이너 없이는 아무것도 할 수 없다. 사용하지말자!
//    @Autowired private  MemberRepository memberRepository;
//    @Autowired private  DiscountPolicy discountPolicy;
//

//    //setter 주입 예시
//    @Autowired //주입할 대상이 없어도 동작하게 하려면, (required = false)옵션을 주면 된다.
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }


    @Autowired //생성자 주입은 스프링 빈을 등록할 때 같이 주입된다. why? : 스프링이 OrderServiceImpl 객체를 생성해야되므로 어쩔 수 없이 생성자가 불러와지므로.(자바 코드의 영역)
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("memberRepository1 = " + memberRepository);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원정보 조회
        Member member = memberRepository.findById(memberId);
        // 할인에 대해서는 orderService가 신경 쓸 일이 없다. discountPolicy만 고치면 된다. 단일책임원칙. SRP
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
