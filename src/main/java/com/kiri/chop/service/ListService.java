package com.kiri.chop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kiri.chop.domain.ListEntity;
import com.kiri.chop.domain.ListRepository;
import com.kiri.chop.dto.ListAllResponseDto;
import com.kiri.chop.dto.ListResponseDto;
import com.kiri.chop.dto.ListSaveRequestDto;
import com.kiri.chop.dto.ListUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListService {
	
	private final ListRepository listRepository;
	
	@Transactional
	public Long save(ListSaveRequestDto requestDto) {
		return listRepository.save(requestDto.toEntity()).getGiftId();
	}
	//등록
	
	@Transactional
	public Long update(Long giftId, ListUpdateRequestDto requestDto) {
		ListEntity listEntity = listRepository.findById(giftId)
				.orElseThrow(() -> new 
						IllegalArgumentException("해당 게시글이 없습니다. id = " + giftId));
		
		listEntity.update(requestDto.getGiftName(), requestDto.getGiftBrand(), 
				requestDto.getGiftCategory(), requestDto.getGiftPrice(), 
				requestDto.getGiftSold(), requestDto.getGiftContent());
		
		return giftId;
	}
	//수정
	
	@Transactional
	public ListResponseDto findById(Long id) {
		ListEntity listEntity = listRepository.findById(id)
				.orElseThrow(() -> new 
						IllegalArgumentException("해당 게시글이 없습니다 id = " + id));
		
		return new ListResponseDto(listEntity);
	}
	//조회
	
	@Transactional(readOnly = true)
	public List<ListAllResponseDto> findAllDesc() {
		return listRepository.findAllDesc().stream()
				.map(ListAllResponseDto::new)
				.collect(Collectors.toList());
	}
	
	@Transactional
	public void delete(Long giftId) {
		ListEntity listEntity = listRepository.findById(giftId)
				.orElseThrow(() -> new 
						IllegalArgumentException("해당 게시글이 없습니다. id = " + giftId));
		
		listRepository.delete(listEntity);
	}
}
