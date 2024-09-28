package com.kcunha.petfriends_inventory.services;

import com.kcunha.petfriends_inventory.entities.InventoryItem;
import com.kcunha.petfriends_inventory.repositories.InventoryItemRepository;
import com.kcunha.petfriends_inventory.events.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service to listen and handle OrderCreatedEvent messages for the PetFriends_Inventory microservice.
 */
@Service
public class OrderEventListener {

    private final InventoryItemRepository inventoryItemRepository;

    public OrderEventListener(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @RabbitListener(queues = "order-created-queue")
    @Transactional
    public void handleOrderCreated(OrderCreatedEvent event) {
        // Retrieve the ordered product information from the event
        String productCode = event.getProduct();
        int orderedQuantity = event.getQuantity();

        Optional<InventoryItem> inventoryItemOpt = inventoryItemRepository.findByProductCode(productCode);

        if (inventoryItemOpt.isPresent()) {
            InventoryItem inventoryItem = inventoryItemOpt.get();
            int newQuantity = inventoryItem.getQuantity() - orderedQuantity;

            if (newQuantity < 0) {
                throw new IllegalArgumentException("Insufficient inventory for product: " + productCode);
            }

            inventoryItem.setQuantity(newQuantity);
            inventoryItemRepository.save(inventoryItem);
        } else {
            throw new IllegalArgumentException("Product not found in inventory: " + productCode);
        }
    }
}
