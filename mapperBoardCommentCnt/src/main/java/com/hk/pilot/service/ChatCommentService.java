package com.hk.pilot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.pilot.dto.ChatComment;
import com.hk.pilot.mapper.ChatCommentMapper;

@Service
public class ChatCommentService {

	@Autowired
	ChatCommentMapper ccMapper;

	//댓글 작성하기
	public void writeComment(ChatComment ccment) {
		
		System.out.println("ccmentService -writeComment 호출");
		
		System.out.println(ccment.toString());
		
		ccMapper.writeComment(ccment);
	}

	//작성 댓글 조회
	public List<ChatComment> readComment(int c_no){
		
		System.out.println("ccmentService -readComment 호출");

		return ccMapper.readComment(c_no);

	}

}
