package com.sundaydevblog.springrestapitest.service;

import com.sundaydevblog.springrestapitest.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    List<Member> getAllMembers();

    Optional<Member> getMemberById(long id);

    Member saveMember(Member member);

    void removeMember(long id);
}
