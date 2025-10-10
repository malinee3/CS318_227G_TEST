package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for DigitalSafe operations
 * Demonstrates encapsulation through API endpoints
 */
@RestController
public class SafeController {
    
    // Create a single DigitalSafe instance for demonstration
    private DigitalSafe safe = new DigitalSafe("John Doe");
    
    /**
     * GET endpoint to retrieve the safe owner's name
     * @return Owner's name
     */
    @GetMapping("/safe/owner")
    public ResponseEntity<String> getOwner() {
        return ResponseEntity.ok(safe.getOwnerName());
    }
    
    /**
     * GET endpoint to retrieve the current balance
     * @return Current balance
     */
    @GetMapping("/safe/balance")
    public ResponseEntity<Double> getBalance() {
        return ResponseEntity.ok(safe.getBalance());
    }
    
    /**
     * POST endpoint to deposit money into the safe
     * @param amount The amount to deposit (from request parameter)
     * @return Updated balance after deposit
     */
    @PostMapping("/safe/deposit")
    public ResponseEntity<Double> deposit(@RequestParam double amount) {
        try {
            safe.deposit(amount);
            return ResponseEntity.ok(safe.getBalance());
        } catch (IllegalArgumentException e) {
            // Return bad request if amount is invalid
            return ResponseEntity.badRequest().build();
        }
    }
}
