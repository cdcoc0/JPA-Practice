package com.kiri.chop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestUpdateRequestDto {
	
	private String title;
	private String content;
	
	@Builder
	public TestUpdateRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
