package io.hoon.springdb1.jdbc.domain;

import lombok.Data;

/**
 * 해당 어노테이션은 @Getter, @Setter, @EqualsAndHashCode, @ RequiredArgsConstructor
 * POJO와 bean과 관련된 모든 보일러플레이트(boilerplate = 재사용 가능한 코드)를 생성한다.
 */
@Data
public class Member {

    private String memberId;
    private int money;

    public Member() {
    }

    public Member(String memberId, int money) {
        this.memberId = memberId;
        this.money = money;
    }

}
