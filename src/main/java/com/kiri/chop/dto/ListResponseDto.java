package com.kiri.chop.dto;

import com.kiri.chop.domain.ListEntity;

import lombok.Getter;

@Getter
public class ListResponseDto {
	
	private Long giftId;
	private String giftName;
	private String giftBrand;
	private String giftCategory;
	private String giftPrice;
	private int giftSold;
	private String giftContent;
	
	public ListResponseDto(ListEntity listEntity) {
		this.giftId = listEntity.getGiftId();
		this.giftName = listEntity.getGiftName();
		this.giftBrand = listEntity.getGiftBrand();
		this.giftCategory = listEntity.getGiftCategory();
		this.giftPrice = listEntity.getGiftPrice();
		this.giftSold = listEntity.getGiftSold();
		this.giftContent = listEntity.getGiftContent();
	}
}
