package com.kiri.chop.domain;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepositoryTest {
	
	@Autowired
	TestRepository testRepository;
	
	@After
	public void cleanup() {
		testRepository.deleteAll();
	}
	
	@Test
	public void call_saved() {
		//given
		String title = "테스트 게시글";
		String content = "테스트 본문";
		
		testRepository.save(TestEntity.builder()
				.title(title)
				.content(content)
				.author("chopkiri")
				.build());
		
		//when
		List<TestEntity> testEntityList = testRepository.findAll();
		
		//then
		TestEntity testEntity = testEntityList.get(0);
		assertThat(testEntity.getTitle()).isEqualTo(title);
		assertThat(testEntity.getContent()).isEqualTo(content);
		
	}
}
