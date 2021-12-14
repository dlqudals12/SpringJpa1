package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    //insert문을 보고 싶을 때
    @Autowired EntityManager em;

    @Test
    // transactional이 롤백 하기 때문에 롤백 하기 싫을 때
    // @Rollback(false)
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("KIM");

        //when
        Long saveId = memberService.join(member);

        //then
        //insert문을 보고 싶을 때
        em.flush();
        assertEquals(member, memberRepository.findOne(saveId));

    }

    //expected -> try catch문을 안쓰게 해줌
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예회() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2);


        //then
        // 예외가 발생하지 않으면 뜸
        fail("예외 발생 해야함");

    }

}