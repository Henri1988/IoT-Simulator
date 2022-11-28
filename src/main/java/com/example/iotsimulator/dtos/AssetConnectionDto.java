package com.example.iotsimulator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link AssetConnection} entity
 */
@Data
@NoArgsConstructor
public class AssetConnectionDto implements Serializable {
    private  Integer id;
    private  Integer sourceAssetId;
    private  String sourceAssetName;
    private  String sourceAssetRole;
    private  Integer targetAssetId;
    private  String targetAssetName;
    private  String targetAssetRole;
    @NotNull
    private  Integer intervalMs;
    @NotNull
    private  Instant createdAt;
}