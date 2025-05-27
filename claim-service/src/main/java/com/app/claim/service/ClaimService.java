package com.app.claim.service;

import com.app.claim.entity.Claim;
import com.app.claim.logging.LogProducer;
import com.app.claim.repository.ClaimRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final LogProducer logProducer;

    public ClaimService(ClaimRepository claimRepository, LogProducer logProducer) {
        this.claimRepository = claimRepository;
        this.logProducer = logProducer;
    }

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Optional<Claim> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    public Claim saveClaim(Claim claim) {
        Claim savedClaim = claimRepository.save(claim);
        logProducer.sendLog("Claim submitted: " + savedClaim.getId() +
                ", User ID: " + savedClaim.getUserId());
        return savedClaim;
    }

    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
        logProducer.sendLog("Claim deleted: ID = " + id);
    }
}
