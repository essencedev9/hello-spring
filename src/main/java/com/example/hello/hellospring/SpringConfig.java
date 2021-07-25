package com.example.hello.hellospring;

import com.example.hello.hellospring.repository.JdbcMemberRepository;
import com.example.hello.hellospring.repository.MemberRepository;
import com.example.hello.hellospring.repository.MemoryMemberRepository;
import com.example.hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
