package com.smhrd.flutter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smhrd.flutter.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	public Member findByIdAndPassword(long email, long password);
}
