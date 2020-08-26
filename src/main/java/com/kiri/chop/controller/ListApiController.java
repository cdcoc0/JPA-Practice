package com.kiri.chop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiri.chop.dto.ListResponseDto;
import com.kiri.chop.dto.ListSaveRequestDto;
import com.kiri.chop.dto.ListUpdateRequestDto;
import com.kiri.chop.service.ListService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
//등록, 수정, 조회
public class ListApiController {

	private final ListService listService;
	
	@PostMapping("/api/v1/gift")
	public Long save(@RequestBody ListSaveRequestDto requestDto) {
		return listService.save(requestDto);
	}
	
	@PutMapping("/api/v1/gift/{giftId}")
	public Long update(@PathVariable Long giftId, @RequestBody ListUpdateRequestDto requestDto) {
		return listService.update(giftId, requestDto);
	}
	
	@GetMapping("/api/v1/gift/{id}")
	public ListResponseDto findById(@PathVariable Long giftId) {
		return listService.findById(giftId);
	}
}
