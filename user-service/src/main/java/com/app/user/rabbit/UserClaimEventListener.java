package com.app.user.rabbit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserClaimEventListener {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "claim.queue")
    public void handleClaimSubmission(String message) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);

            Long claimId = jsonNode.get("claimId").asLong();
            Long userId = jsonNode.get("userId").asLong();
            String policyNumber = jsonNode.get("policyNumber").asText();

            System.out.println("Received claim: " +
                    "Claim ID: " + claimId +
                    ", User ID: " + userId +
                    ", Policy #: " + policyNumber);

        } catch (Exception e) {
            System.err.println("Failed to parse message: " + message);
            e.printStackTrace();
        }
    }
}
