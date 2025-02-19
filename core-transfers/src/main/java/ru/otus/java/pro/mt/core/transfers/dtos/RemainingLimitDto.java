package ru.otus.java.pro.mt.core.transfers.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "DTO для представления оставшегося лимита")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemainingLimitDto {

    @Schema(
            description = "Оставшийся лимит",
            example = "1500.00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private BigDecimal remainingLimit;

}