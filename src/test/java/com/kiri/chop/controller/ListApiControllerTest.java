package com.kiri.chop.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.kiri.chop.domain.ListEntity;
import com.kiri.chop.domain.ListRepository;
import com.kiri.chop.dto.ListSaveRequestDto;
import com.kiri.chop.dto.ListUpdateRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListApiControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private ListRepository listRepository;
	
	@After
	public void tearDown() throws Exception {
		listRepository.deleteAll();
	}
	
	@Test
	public void List_save() throws Exception {
		//given
		String giftName = "name";
		String giftBrand = "brand";
		String giftCategory = "category";
		String giftPrice = "price";
		int giftSold = 30;
		String giftContent = "content";
		
		ListSaveRequestDto requestDto = ListSaveRequestDto.builder()
				.giftName(giftName)
				.giftBrand(giftBrand)
				.giftCategory(giftCategory)
				.giftPrice(giftPrice)
				.giftSold(giftSold)
				.giftContent(giftContent)
				.build();
		
		String url = "http://localhost:" + port + "/create/v1/gift";
		
		//when
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity
				(url, requestDto, Long.class);
		
		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<ListEntity> all = listRepository.findAll();
		assertThat(all.get(0).getGiftName()).isEqualTo(giftName);
		assertThat(all.get(0).getGiftBrand()).isEqualTo(giftBrand);
		assertThat(all.get(0).getGiftCategory()).isEqualTo(giftCategory);
		assertThat(all.get(0).getGiftPrice()).isEqualTo(giftPrice);
		assertThat(all.get(0).getGiftSold()).isEqualTo(giftSold);
		assertThat(all.get(0).getGiftContent()).isEqualTo(giftContent);
		
	}
	
	@Test
	public void List_update() throws Exception {
		//given
		ListEntity savedList = listRepository.save(ListEntity.builder()
				.giftName("Name")
				.giftBrand("Brand")
				.giftCategory("Category")
				.giftPrice("Price")
				.giftSold(30)
				.giftContent("Content")
				.build());
		
		Long updateId = savedList.getGiftId();
		String ExpectedGiftName = "Name2";
		String ExpectedGiftBrand = "Brand2";
		String ExpectedGiftCategory = "Category2";
		String ExpectedGiftPrice = "Price2";
		int ExpectedGiftSold = 100;
		String ExpectedGiftContent = "Content2";
		
		ListUpdateRequestDto requestDto = ListUpdateRequestDto.builder()
				.giftName(ExpectedGiftName)
				.giftBrand(ExpectedGiftBrand)
				.giftCategory(ExpectedGiftCategory)
				.giftPrice(ExpectedGiftPrice)
				.giftSold(ExpectedGiftSold)
				.giftContent(ExpectedGiftContent)
				.build();
		
		String url = "http://localhost:" + port + "/api/v1/gift/" + updateId;
		
		HttpEntity<ListUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
		
		//when
		ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, 
				requestEntity, Long.class);
		
		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<ListEntity> all = listRepository.findAll();
		assertThat(all.get(0).getGiftName()).isEqualTo(ExpectedGiftName);
		assertThat(all.get(0).getGiftBrand()).isEqualTo(ExpectedGiftBrand);
		assertThat(all.get(0).getGiftCategory()).isEqualTo(ExpectedGiftCategory);
		assertThat(all.get(0).getGiftPrice()).isEqualTo(ExpectedGiftPrice);
		assertThat(all.get(0).getGiftSold()).isEqualTo(ExpectedGiftSold);
		assertThat(all.get(0).getGiftContent()).isEqualTo(ExpectedGiftContent);
	}
}
