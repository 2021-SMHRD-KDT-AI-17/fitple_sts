package com.smhrd.flutter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.flutter.model.Member;
import com.smhrd.flutter.repository.MemberRepository;

@Service
public class MemberService implements MemberServiceImpl{
	
	@Autowired
	MemberRepository repo;
	
	@Override
	public int memberJoin(Member m) {
		Member result = repo.save(m);
		if(result!=null) return 1;
		else return 0;
	}
	
	@Override
	public Member memberLogin(Member m) {
		return repo.findByIdAndPassword(m.getEmail(), m.getPassword());
	}

	@Override
	public Member memberUpdate(Member m) {
		Member member = repo.findById(m.getEmail()).orElseThrow(()->{
			throw new IllegalArgumentException("해당하는 이메일이 없습니다");
		});
		member.setName(m.getName());
		member.setNick(m.getNick());
		member.setPassword(m.getPassword());
		member.setEmail(m.getEmail());
		member.setGender(m.getGender());
		
		Member result = repo.save(member);
		return result;
	}

	@Override
	public void memberDelete(long email) {
		repo.deleteById(email);
		
	}
	
	
	
}
