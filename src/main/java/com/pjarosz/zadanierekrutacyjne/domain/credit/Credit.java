package com.pjarosz.zadanierekrutacyjne.domain.credit;


import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Credit {

    @Setter
    private Long id;
    @NotBlank
    private String creditName;
}
