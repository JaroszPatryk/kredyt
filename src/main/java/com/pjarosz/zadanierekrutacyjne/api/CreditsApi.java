package com.pjarosz.zadanierekrutacyjne.api;

import com.pjarosz.zadanierekrutacyjne.domain.credit.Credit;
import com.pjarosz.zadanierekrutacyjne.domain.credit.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/credits")
@AllArgsConstructor
public class CreditsApi {

    private CreditService creditService;

    @GetMapping
    public List<Credit> getCredit() {
        return creditService.getCredits();
    }


    @GetMapping("/{creditId}")
    public ResponseEntity<Credit> getOne(@PathVariable Long creditId) {
        return creditService.getCreditById(creditId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCredit(@RequestBody @Valid Credit credit) {
        creditService.createCredit(credit);
    }


}
