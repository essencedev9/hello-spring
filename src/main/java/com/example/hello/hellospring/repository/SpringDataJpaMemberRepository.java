package com.example.hello.hellospring.repository;

import com.example.hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

    // select m from member m where m.name = ? and m.address=?
    // findByNameAndAddress
    @Override
    Optional<Member> findByName(String name);
}
