package com.kiri.chop.dto;

import com.kiri.chop.domain.TestEntity;

import lombok.Getter;

@Getter
public class TestResponseDto {
	
	private Long id;
	private String title;
	private String content;
	private String author;
	
	public TestResponseDto(TestEntity testEntity) {
		this.id = testEntity.getId();
		this.title = testEntity.getTitle();
		this.content = testEntity.getContent();
		this.author = testEntity.getAuthor();
	}
}
