package com.sundaydevblog.springrestapitest.service.impl;

import com.sundaydevblog.springrestapitest.entity.Member;
import com.sundaydevblog.springrestapitest.repository.MemberRepository;
import com.sundaydevblog.springrestapitest.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> getMemberById(long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }


    @Override
    public void removeMember(long id) {
        this.memberRepository.deleteById(id);
    }
}
