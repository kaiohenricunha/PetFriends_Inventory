package com.kcunha.petfriends_inventory.repositories;

import com.kcunha.petfriends_inventory.entities.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository interface for InventoryItem entities.
 */
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
    Optional<InventoryItem> findByProductCode(String productCode);
}
