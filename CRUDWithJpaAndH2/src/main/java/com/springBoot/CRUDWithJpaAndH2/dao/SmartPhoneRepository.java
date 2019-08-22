package com.springBoot.CRUDWithJpaAndH2.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.CRUDWithJpaAndH2.dto.SmartPhone;

@Repository
public interface SmartPhoneRepository extends CrudRepository<SmartPhone, Integer>
{
	@Modifying
	@Query("UPDATE SmartPhone SET price = ?1 WHERE Id = ?2")
	@Transactional
	void updatePrice(int Id, int price);
}
