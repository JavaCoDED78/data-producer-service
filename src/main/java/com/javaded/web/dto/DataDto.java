package com.javaded.web.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record DataDto(
    Long sensorId,
    LocalDateTime timestamp,
    Double measuredValue,
    MeasurementType measurementType
) {

    public enum MeasurementType {

        TEMPERATURE,
        VOLTAGE,
        POWER

    }

}
