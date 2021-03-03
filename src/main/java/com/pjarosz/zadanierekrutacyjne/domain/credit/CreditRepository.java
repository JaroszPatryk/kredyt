package com.pjarosz.zadanierekrutacyjne.domain.credit;

import java.util.List;
import java.util.Optional;

public interface CreditRepository {

    Optional<Credit> findOne(Long id);

    List<Credit> findAll();

    void create(Credit credit);

}
