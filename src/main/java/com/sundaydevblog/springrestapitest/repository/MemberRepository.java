package com.sundaydevblog.springrestapitest.repository;

import com.sundaydevblog.springrestapitest.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
