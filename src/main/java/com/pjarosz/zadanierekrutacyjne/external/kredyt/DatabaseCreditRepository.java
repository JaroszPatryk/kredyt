package com.pjarosz.zadanierekrutacyjne.external.kredyt;

import com.pjarosz.zadanierekrutacyjne.domain.credit.Credit;
import com.pjarosz.zadanierekrutacyjne.domain.credit.CreditRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DatabaseCreditRepository implements CreditRepository {

    private JpaCreditRepository jpaCreditRepository;

    @Override
    public Optional<Credit> findOne(Long id) {
        return jpaCreditRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Credit> findAll() {
        return jpaCreditRepository.findAll()
                .stream().map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void create(Credit credit) {
        jpaCreditRepository.save(toEntity(credit));
    }

    private Credit toDomain(CreditEntity entity) {
        return Credit.builder()
                .id(entity.getId())
                .creditName(entity.getCreditName())
                .build();
    }

    private CreditEntity toEntity(Credit credit) {
        return CreditEntity.builder()
                .id(credit.getId())
                .creditName(credit.getCreditName())
                .build();
    }
}
