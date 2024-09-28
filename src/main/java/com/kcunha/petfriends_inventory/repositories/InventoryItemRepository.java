package com.kcunha.petfriends_inventory.repositories;

import com.kcunha.petfriends_inventory.entities.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for InventoryItem entities.
 */
@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    InventoryItem findByProductCode(String productCode);
}
