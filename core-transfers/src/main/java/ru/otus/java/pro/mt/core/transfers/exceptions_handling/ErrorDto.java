package ru.otus.java.pro.mt.core.transfers.exceptions_handling;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "DTO для представления ошибки")
public class ErrorDto {

    @Schema(
            description = "Код ошибки",
            example = "INTERNAL_SERVER_ERROR",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String code;

    @Schema(
            description = "Сообщение об ошибке",
            example = "NullPointerException",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String message;

    @Schema(
            description = "Время возникновения ошибки",
            example = "2023-10-01T12:00:00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private LocalDateTime dateTime;

    public ErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }

}
