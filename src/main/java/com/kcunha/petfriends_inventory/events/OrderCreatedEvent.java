package com.kcunha.petfriends_inventory.events;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Event triggered when an order is created in the Pet Friends application.
 */
@Getter
@NoArgsConstructor
public class OrderCreatedEvent extends BaseEvent {
    private String orderId;
    private String product;
    private int quantity;

    /**
     * Constructs a new OrderCreatedEvent with the specified order details.
     *
     * @param orderId  The ID of the order.
     * @param product  The product associated with the order.
     * @param quantity The quantity of the product ordered.
     */
    public OrderCreatedEvent(String orderId, String product, int quantity) {
        super(); // Call the constructor of BaseEvent to set id and timestamp
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }
}
