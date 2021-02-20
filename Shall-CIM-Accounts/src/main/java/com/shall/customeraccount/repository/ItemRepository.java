package com.shall.customeraccount.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shall.customeraccount.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	public List<Item> findByItemType(Long itemType);
}
