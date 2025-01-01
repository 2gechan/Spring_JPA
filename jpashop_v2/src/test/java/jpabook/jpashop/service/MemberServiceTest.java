package jpabook.jpashop.service;

import jpabook.jpashop.Repository.MemberRepository;
import jpabook.jpashop.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("")
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("lee");


        // when
        Long savedId = memberService.join(member);

        // then
        Assertions.assertEquals(member, memberRepository.findOne(savedId));

    }

    @Test()
    @DisplayName("")
    public void 중복회원예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("lee");

        Member member2 = new Member();
        member2.setName("lee");

        // when
        memberService.join(member1);

        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class,
                                () -> memberService.join(member2));

        Assertions.assertEquals(ex.getMessage(), "이미 존재하는 회원입니다.");


        // then
        // Assertions.fail("예외가 발생해야 한다.");

    }

}