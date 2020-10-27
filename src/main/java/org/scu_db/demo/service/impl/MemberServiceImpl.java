package org.scu_db.demo.service.impl;

import org.scu_db.demo.Repository.MemberRepository;
import org.scu_db.demo.model.Member;
import org.scu_db.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "MemberService")
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

}
