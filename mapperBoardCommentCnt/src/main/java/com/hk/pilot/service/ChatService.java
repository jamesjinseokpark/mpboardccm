package com.hk.pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.Chat;
import com.hk.pilot.dto.Criteria;
import com.hk.pilot.mapper.ChatMapper;

@Service
public class ChatService {
	
	@Autowired
	ChatMapper chatMapper;
	
	//게시글 작성
	public void write(Chat chat) {
		
		System.out.println("chatService-write 호출");
		
		System.out.println(chat.toString());
		
		chatMapper.write(chat);
		
	}
	
	//게시글 목록 조회
	public List<Chat> list(Criteria cri){
		
		System.out.println("chatService-list 호출");
		
		return chatMapper.list(cri);
	}
	
	//게시물 총 개수
	public int listCount() {
		
		System.out.println("chatService-listCount 호출");
		
		return chatMapper.listCount();
	}
	
	//게시물 상세 조회하기
	public Chat selectOne(int c_no) {
		
		System.out.println("chatService-selectOne 호출");
		return chatMapper.selectOne(c_no);
	}
	
	//게시글 수정
	
	public void update(Chat chat) {
		System.out.println("chatService-update 호출");
		
		System.out.println(chat.toString()+"chatService");
		
		chatMapper.update(chat);
		
	}
	
	//게시글 삭제하기
	
	public void delete(int c_no) {
		System.out.println("chatService-delete 호출");
		
		chatMapper.delete(c_no);
		
	}
	


}
