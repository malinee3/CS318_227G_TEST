package com.example.demo;

/**
 * DigitalSafe class demonstrating encapsulation principles
 * - Private properties to prevent direct access
 * - Only deposit method for adding money (no withdrawal method)
 * - Getter methods for reading balance and owner name
 */
public class DigitalSafe {
    
    // Private properties to ensure encapsulation
    private String ownerName;
    private double balance;
    
    /**
     * Constructor for DigitalSafe
     * @param ownerName The name of the safe owner
     */
    public DigitalSafe(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0; // Initialize balance to 0
    }
    
    /**
     * Deposit money into the safe
     * Only accepts positive amounts
     * @param amount The amount to deposit (must be positive)
     * @throws IllegalArgumentException if amount is negative or zero
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this.balance += amount;
    }
    
    /**
     * Get the current balance
     * @return Current balance amount
     */
    public double getBalance() {
        return this.balance;
    }
    
    /**
     * Get the owner name
     * @return Name of the safe owner
     */
    public String getOwnerName() {
        return this.ownerName;
    }
}
