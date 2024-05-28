package com.smhrd.flutter.service;

import com.smhrd.flutter.model.Member;

public interface MemberServiceImpl {
	
	// 회원가입
	public int memberJoin(Member m);
	
	// 로그인
	public Member memberLogin(Member m);
	
	// 회원정보수정
	public Member memberUpdate(Member m);
	
	// 회원탈퇴
	public void memberDelete(long email);
}
