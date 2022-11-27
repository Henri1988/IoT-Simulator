package com.example.iotsimulator.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalTime;

/**
 * A DTO for the {@link AssetConnection} entity
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetConnectionDto implements Serializable {


    private Integer id;
    private Integer sourceAssetId;
    @Size(max = 255)
    @NotNull
    private String sourceAssetName;
    @Size(max = 255)
    @NotNull
    private String sourceAssetRole;
    private Integer targetAssetId;
    @Size(max = 255)
    @NotNull
    private String targetAssetName;
    @Size(max = 255)
    @NotNull
    private String targetAssetRole;
    @NotNull
    private LocalTime createdAt;
    @NotNull
    private Integer intervalMs;
}