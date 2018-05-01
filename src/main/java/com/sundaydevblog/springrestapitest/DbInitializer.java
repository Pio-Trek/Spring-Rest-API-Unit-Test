package com.sundaydevblog.springrestapitest;

import com.sundaydevblog.springrestapitest.entity.Member;
import com.sundaydevblog.springrestapitest.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInitializer implements CommandLineRunner {

    private MemberRepository memberRepository;

    public DbInitializer(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(String... args) {

        /*
        INITIALIZE THE DATABASE AND POPULATE IT WITH SOME FAKE AUTHORS AND BOOKS
         */
        Member member1 = new Member("John Wee", "jwee@yahoo.com");
        Member member2 = new Member("Mary Brown", "mary.b@gmail.com");

        this.memberRepository.save(member1);
        this.memberRepository.save(member2);


    }
}
