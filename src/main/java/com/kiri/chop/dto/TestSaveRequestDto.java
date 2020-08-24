package com.kiri.chop.dto;

import com.kiri.chop.domain.TestEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestSaveRequestDto {
	
	private String title;
	private String content;
	private String author;
	
	@Builder
	public TestSaveRequestDto(String title, String content, String author) {
		
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public TestEntity toEntity() {
		return TestEntity.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}
