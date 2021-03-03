package com.pjarosz.zadanierekrutacyjne.domain.credit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreditService {

    private final CreditRepository creditRepository;

    public void createCredit(Credit credit) {
        creditRepository.create(credit);
    }

    public Optional<Credit> getCreditById(Long id) {
        return creditRepository.findOne(id);
    }

    public List<Credit> getCredits() {
        return creditRepository.findAll();
    }
}
