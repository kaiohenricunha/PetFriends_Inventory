package com.kcunha.petfriends_inventory.events;

import java.time.Instant;
import java.util.UUID;

/**
 * Abstract base class for all events in the Pet Friends application.
 * Provides common properties such as a unique identifier and timestamp.
 */
public abstract class BaseEvent {
    private final String id;
    private final Instant timestamp;
    /**
     * Constructs a new BaseEvent with a unique ID and the current timestamp.
     */
    public BaseEvent() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = Instant.now();
    }
    /**
     * Gets the unique identifier of the event.
     *
     * @return the event ID
     */
    public String getId() {
        return id;
    }
    /**
     * Gets the timestamp when the event was created.
     *
     * @return the event timestamp
     */
    public Instant getTimestamp() {
        return timestamp;
    }
}
