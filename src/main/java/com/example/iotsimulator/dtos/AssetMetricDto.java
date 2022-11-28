package com.example.iotsimulator.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link AssetMetric} entity
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AssetMetricDto implements Serializable {

    private Integer value;
    @NotNull
    private Instant metricsTime;
    private Integer assetConnectionId;
}