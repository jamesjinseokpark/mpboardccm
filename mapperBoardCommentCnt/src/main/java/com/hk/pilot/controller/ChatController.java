package com.hk.pilot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.pilot.dto.Chat;
import com.hk.pilot.dto.ChatComment;
import com.hk.pilot.dto.Criteria;
import com.hk.pilot.dto.PageMaker;
import com.hk.pilot.dto.SearchCriteria;
import com.hk.pilot.service.ChatCommentService;
import com.hk.pilot.service.ChatService;

@Controller
@RequestMapping("/chat/*")
public class ChatController {
	
	@Autowired
	ChatService chatService;
	
	@Autowired
	ChatCommentService ccmentService;
	
	//게시글 작성화면
	@GetMapping(value="/chat/write")
	public String writeGet() {
		System.out.println("글작성 페이지 호출");
		return "chat/writeView";
	}
	
	//게시글 작성 - db저장
	@PostMapping(value="/chat/write")
	public String writePost(Model model, Chat chat) {
		System.out.println("글작성");
		chatService.write(chat);
		return "redirect:/chat/list";
				
	}
	
	//게시글 목록 조회
	@GetMapping(value="/chat/list")
	public String list(SearchCriteria scri, Model model) {
		System.out.println("목록 조회 list 호출");
		model.addAttribute("list", chatService.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(scri);
		
		pageMaker.setTotalCount(chatService.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
				
		return "chat/list";
		
	}
	
	//게시글 상세 조회
	@GetMapping(value="/chat/read")
	public String selectOne (Chat chat, Model model) {
		System.out.println("selectOne 들어옴");
		
		model.addAttribute("selectOne", chatService.selectOne(chat.getC_no()));
		
		List<ChatComment> commentList = ccmentService.readComment(chat.getC_no());
		
		model.addAttribute("commentList", commentList);
		
		
		return "chat/readView";
	}
	
	//게시글 수정 화면
	@GetMapping(value="/chat/update")
	public String updateGet(Chat chat, Model model) {
		System.out.println("updateGet 들어옴");
		
		model.addAttribute("update", chatService.selectOne(chat.getC_no()));
		
		return "chat/updateView";
	}
	
	//게시글 수정 - db저장
	@PostMapping(value="/chat/update")
	public String updatePost(Chat chat) {
		System.out.println("update 들어옴");
		
		chatService.update(chat);
		
		System.out.println(chat.toString() + "chatCon");
		
		return "redirect:/chat/list";
		
	}
	
	//게시글 삭제 - db저장
	@PostMapping(value="chat/delete")
	
	public String delete(Chat chat) {
		System.out.println("delete 들어옴");
		
		chatService.delete(chat.getC_no() );
		
		System.out.println("delete 반환");
		
		return "redirect:/chat/list";
	}
	
	//게시글 - 댓글달기
	@PostMapping(value="/commentWrite")
	
	public String writeCommentPost(ChatComment ccment) {
		
		System.out.println("commentWrite-con 들어옴");
		
		ccmentService.writeComment(ccment);
		
		return "redirect:/chat/list";
			
	}
	
	

}
