package com.kiri.chop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiri.chop.dto.TestResponseDto;
import com.kiri.chop.dto.TestSaveRequestDto;
import com.kiri.chop.dto.TestUpdateRequestDto;
import com.kiri.chop.service.TestService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestApiController {
	
	private final TestService testService;
	
	//글 등록
	@PostMapping("/api/v1/test")
	public Long save(@RequestBody TestSaveRequestDto requestDto) {
		
		return testService.save(requestDto);
	}
	
	//글 수정
	@PutMapping("/api/v1/test/{id}")
	public Long update(@PathVariable Long id, @RequestBody TestUpdateRequestDto requestDto) {
		return testService.update(id, requestDto);
	}
	
	//글 조회
	@GetMapping("/api/v1/test/{id}")
	public TestResponseDto findById(@PathVariable Long id) {
		return testService.findById(id);
	}
}
