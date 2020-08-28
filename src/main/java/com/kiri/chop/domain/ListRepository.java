package com.kiri.chop.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListRepository extends JpaRepository<ListEntity, Long>{

	@Query("select p from ListEntity p order by p.id desc")
	List<ListEntity> findAllDesc();
}
