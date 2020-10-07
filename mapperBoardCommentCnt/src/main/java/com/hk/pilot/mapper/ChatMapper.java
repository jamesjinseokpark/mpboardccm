package com.hk.pilot.mapper;

import java.util.List;

import com.hk.pilot.dto.Chat;
import com.hk.pilot.dto.Criteria;
import com.hk.pilot.dto.SearchCriteria;

public interface ChatMapper {
	
	public void write(Chat chat); //문의게시판 게시글작성
	
	public List<Chat> list(SearchCriteria cri); //게시글 목록 조회
	
	public int listCount(SearchCriteria scri); //게시글 총 개수
	
	public Chat selectOne(int c_no); //게시글 상세보기

	public void update(Chat chat); // 게시글 수정하기
	
	public void delete(int c_no); // 게시글 삭제하기
}
