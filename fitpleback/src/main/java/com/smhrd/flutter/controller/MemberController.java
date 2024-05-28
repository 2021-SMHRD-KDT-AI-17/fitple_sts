package com.smhrd.flutter.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.flutter.model.Member;
import com.smhrd.flutter.service.MemberServiceImpl;

@Controller
public class MemberController {
	
	@Autowired
	MemberServiceImpl service;
	
	@PostMapping("/join")
	public int memberJoin(@RequestBody HashMap<String, Object> map) {
		ObjectMapper om = new ObjectMapper();
		Member joinMember = om.convertValue(map.get("joinMember"), Member.class);
		int result = service.memberJoin(joinMember);
		return result;
	}
	
	@PostMapping("/login")
	public String memberLogin(@RequestBody HashMap<String, Object> map) {
		ObjectMapper om = new ObjectMapper();
		Member loginMember = om.convertValue(map.get("loginMember"), Member.class);
		
		Member result = service.memberLogin(loginMember);
		
		String jsonString = null;
		if(result!=null) {
			try {
				jsonString = om.writeValueAsString(result);
			}catch(JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return jsonString;
	}
	@PostMapping("/update")
	public String memberUpdate(@RequestBody HashMap<String, Object> map) {
		ObjectMapper om = new ObjectMapper();
		Member updateMember = om.convertValue(map.get("updateMember"), Member.class );
		
		Member result = service.memberUpdate(updateMember);
		
		String jsonString = null;
		if(result != null) {
			try {
				jsonString = om.writeValueAsString(result);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jsonString;
	}
	@DeleteMapping("/delete")
	public int memberDelete(@RequestBody HashMap<String, Object> map) {
		ObjectMapper om = new ObjectMapper();
		Long email = om.convertValue(map.get("email"), Long.class);
		
		service.memberDelete(email);
		return 0;
	}
	
	
	
}
