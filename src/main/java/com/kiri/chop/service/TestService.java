package com.kiri.chop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kiri.chop.domain.TestEntity;
import com.kiri.chop.domain.TestRepository;
import com.kiri.chop.dto.TestResponseDto;
import com.kiri.chop.dto.TestSaveRequestDto;
import com.kiri.chop.dto.TestUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TestService {
	
	private final TestRepository testRepository;
	
	@Transactional
	public Long save(TestSaveRequestDto requestDto) {
		return testRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, TestUpdateRequestDto requestDto) {
		TestEntity testEntity = testRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
		
		testEntity.update(requestDto.getTitle(), requestDto.getContent());
		
		return id;
	}
	
	public TestResponseDto findById(Long id) {
		TestEntity testEntity = testRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
		
		return new TestResponseDto(testEntity);
	}
}
