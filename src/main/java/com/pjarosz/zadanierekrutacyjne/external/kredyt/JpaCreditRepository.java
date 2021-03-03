package com.pjarosz.zadanierekrutacyjne.external.kredyt;

import com.pjarosz.zadanierekrutacyjne.domain.credit.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface JpaCreditRepository extends JpaRepository<CreditEntity, Long> {

    List<Credit> findByCreditName(String creditName);
}
