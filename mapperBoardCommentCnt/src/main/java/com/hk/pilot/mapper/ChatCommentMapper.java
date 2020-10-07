package com.hk.pilot.mapper;

import java.util.List;

import com.hk.pilot.dto.ChatComment;

public interface ChatCommentMapper {

	public void writeComment(ChatComment ccment); //댓글 작성
	
	public List<ChatComment> readComment(int c_no); //작성 댓글 조회

}
