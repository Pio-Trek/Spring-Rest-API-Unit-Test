package com.sundaydevblog.springrestapitest.service;

import com.sundaydevblog.springrestapitest.entity.Member;
import com.sundaydevblog.springrestapitest.repository.MemberRepository;
import com.sundaydevblog.springrestapitest.service.impl.MemberServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    private Member m1 = new Member("Paddy Welbourn", "pwelbourn0@ed.gov");
    private Member m2 = new Member("Wren Flori", "wflori2@webeden.co.uk");
    private Member m3 = new Member("Ambrosio Smewing", "asmewing4@hostgator.com");

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        m1.setId(1L);
        m2.setId(2L);
        m3.setId(3L);
    }

    @Test
    public void testGetAllMembers() {
        //given
        given(memberRepository.findAll()).willReturn(Arrays.asList(m1, m2, m3));

        //calling method under the test
        List<Member> result = memberService.getAllMembers();

        //assert respond has 3 objects
        assertThat(result).hasSize(3);

        //assert
        assertMemberFields(result.get(0));

        //verify that repository was called
        verify(memberRepository, times(1)).findAll();
    }

    @Test
    public void testGetMemberById() {
        //given
        given(memberRepository.findById(1L)).willReturn(Optional.of(m1));

        //calling method under the test
        Optional<Member> result = memberService.getMemberById(1L);

        //assert
        assertThat(result.isPresent()).isTrue();

        //assert
        assertMemberFields(result.orElseGet(null));

        //verify that repository was called
        verify(memberRepository, times(1)).findById(1L);
    }

    @Test
    public void testInsertMember() {
        //given
        given(memberRepository.save(m1)).willReturn(m1);

        //calling method under the test
        Member result = memberService.saveMember(m1);

        //assert
        assertMemberFields(result);

        //verify that repository was called
        verify(memberRepository, times(1)).save(m1);
    }

    @Test
    public void testRemoveMember() {
        memberService.removeMember(1L);

        //verify that repository was called
        verify(memberRepository, times(1)).deleteById(1L);
    }

    //verify that Member 'm1' object have same fields
    private void assertMemberFields(Member member) {
        assertThat(member.getId()).isInstanceOf(Long.class);
        assertThat(member.getId()).isEqualTo(1);
        assertThat(member.getName()).isEqualTo("Paddy Welbourn");
        assertThat(member.getEmail()).isEqualTo("pwelbourn0@ed.gov");
    }
}