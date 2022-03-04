package com.tistory.katfun.intro.service;

import com.tistory.katfun.intro.domain.Member;
import com.tistory.katfun.intro.repository.MemberRepository;
import com.tistory.katfun.intro.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    // 테스트 코드에서 같은 repository를 사용하기 위해 생성자를 사용
    // (직접 생성하는 것이 아니라 외부에서 넣어주도록)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     *
     * @param member
     * @return
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 X
        validateDuplicatedMember(member); //중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
