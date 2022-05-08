package io.hoon.springdb1.jdbc.repository;

import io.hoon.springdb1.jdbc.domain.Member;

public interface MemberRepository {
    Member save(Member member);
    Member findById(String memberId);
    void update(String memberId, int money);
    void delete(String memberId);
}
