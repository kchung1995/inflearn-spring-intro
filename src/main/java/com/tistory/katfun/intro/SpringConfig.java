package com.tistory.katfun.intro;

import com.tistory.katfun.intro.repository.MemberRepository;
import com.tistory.katfun.intro.repository.MemoryMemberRepository;
import com.tistory.katfun.intro.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
