package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final SqlSessionTemplate sql;
    public int save(MemberDTO memberDTO) {
        memberDTO.getMemberEmail();
        if(!(memberDTO.getMemberEmail().contains("https://")) || !(memberDTO.getMemberEmail().contains("http://")))
            memberDTO.setMemberEmail("http://".concat(memberDTO.getMemberEmail()));
        System.out.println(memberDTO.getMemberEmail());
        memberDTO.extract(memberDTO.getMemberEmail());

        System.out.println(memberDTO);
        return sql.insert("Member.sum", memberDTO);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }
}
